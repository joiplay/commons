package cyou.joiplay.commons.utils;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.text.format.Time;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogCapturer {
    private static final int REQ_CODE = 0xf113;

    private Activity mActivity;

    public LogCapturer(Activity activity){
        mActivity = activity;
    }

    private String getRAM(){
        ActivityManager activityManager = (ActivityManager) mActivity.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);

        double totalRam = memoryInfo.totalMem / (1024 * 1024 * 1024f);

        return String.format("%.2f GB", totalRam);
    }

    private String getAvailableSpace(){
        long freeSpace = new File(mActivity.getExternalFilesDir(null).toString()).getFreeSpace();

        return String.format("%.2f GB", freeSpace / (1024 * 1024 * 1024f));
    }

    private String getHeader(){
        return "### Device Information ###\n"
                + "Brand: "+ Build.BRAND+"\n"
                + "Model: "+ Build.MODEL+"\n"
                + "Android SDK: "+ Build.VERSION.SDK_INT+"\n"
                + "RAM: "+ getRAM()+"\n"
                + "Free Space: "+ getAvailableSpace()+"\n"
                + "##########################\n";
    }

    private String getLogs(){
        try{
            Process process = Runtime.getRuntime().exec("logcat -vlong -d");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveLog(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_hh_mm", Locale.US);
        String time = df.format(new Date());

        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TITLE, "Log-"+ time +".txt");

        mActivity.startActivityForResult(intent, REQ_CODE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        if (requestCode == REQ_CODE && resultCode == Activity.RESULT_OK) {
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();

                try{
                    ParcelFileDescriptor pfd = mActivity.getContentResolver().openFileDescriptor(uri, "w");
                    FileOutputStream fileOutputStream = new FileOutputStream(pfd.getFileDescriptor());
                    fileOutputStream.write((getHeader()+getLogs()).getBytes());
                    fileOutputStream.close();
                    pfd.close();

                    Toast.makeText(mActivity, "Logs are written.", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(mActivity, "Failed to write logs.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        }
    }
}
