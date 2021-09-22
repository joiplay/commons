package cyou.joiplay.commons.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamUtils {
    static public String inputStreamToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int data = inputStream.read(); data != -1; data = inputStream.read()) {
            byteArrayOutputStream.write(data);
        }
        return byteArrayOutputStream.toString("UTF-8");
    }
}
