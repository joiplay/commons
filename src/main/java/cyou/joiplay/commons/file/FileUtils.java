package cyou.joiplay.commons.file;

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
