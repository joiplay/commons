package cyou.joiplay.commons.file;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class FileUtils {
    static public void copy(String sourcePath, String targetPath) throws IOException {
        File source = new File(sourcePath);
        File target = new File(targetPath);

        if (target.exists()) target.delete();

        InputStream in = new BufferedInputStream(new FileInputStream(source));
        OutputStream out = new BufferedOutputStream(new FileOutputStream(target));

        byte[] buffer = new byte[1024];
        int lengthRead;
        while ((lengthRead = in.read(buffer)) > 0) {
            out.write(buffer, 0, lengthRead);
            out.flush();
        }
    }

    static public void copyAssets(Context context, String sourcePath, String targetPath) throws IOException {
        File targetFolder = new File(targetPath);

        if (!targetFolder.exists())
            targetFolder.mkdirs();

        for(String path: context.getAssets().list(sourcePath)){
            boolean isFile = context.getAssets().list(sourcePath+"/"+path).length == 0;

            if (isFile){
                copyAsset(context, sourcePath+"/"+path, targetPath+"/"+path);
            } else {
                copyAssets(context, sourcePath+"/"+path, targetPath+"/"+path);
            }
        }
    }

    static public void copyAsset(Context context, String sourcePath, String targetPath) throws IOException {
        File target = new File(targetPath);

        if (target.exists()) target.delete();

        if (!target.getParentFile().exists())
            target.getParentFile().mkdirs();

        InputStream in = new BufferedInputStream(context.getAssets().open(sourcePath));
        OutputStream out = new BufferedOutputStream(new FileOutputStream(target));

        byte[] buffer = new byte[1024];
        int lengthRead;
        while ((lengthRead = in.read(buffer)) > 0) {
            out.write(buffer, 0, lengthRead);
            out.flush();
        }
    }

    static public String readText(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

    static public void writeText(File file, String string) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(string);
        bufferedWriter.close();
    }
}
