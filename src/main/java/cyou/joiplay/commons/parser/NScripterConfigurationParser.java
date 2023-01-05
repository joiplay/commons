package cyou.joiplay.commons.parser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import cyou.joiplay.commons.file.FileUtils;
import cyou.joiplay.commons.model.NScripterConfiguration;

public class NScripterConfigurationParser {
    public static void parse(NScripterConfiguration configuration, String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);

        if (jsonObject.has("app")){
            JSONObject appObject = jsonObject.getJSONObject("app");

            if (appObject.has("screenTimeout")){
                configuration.screenTimeout = appObject.getJSONObject("screenTimeout").getInt("int");
            }
        }
    }

    public static void loadFromFile(NScripterConfiguration configuration, File file) throws IOException, JSONException {
        JSONObject jsonObject = new JSONObject(FileUtils.readText(file));

        if (jsonObject.has("screenTimeout")){
            configuration.screenTimeout = jsonObject.getInt("screenTimeout");
        }

    }

    public static void saveToFile(NScripterConfiguration configuration, File file) throws JSONException, IOException {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("screenTimeout", configuration.screenTimeout);

        FileUtils.writeText(file, jsonObject.toString(4));
    }
}
