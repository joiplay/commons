package cyou.joiplay.commons.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
}
