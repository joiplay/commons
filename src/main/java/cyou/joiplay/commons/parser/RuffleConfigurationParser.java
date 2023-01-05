package cyou.joiplay.commons.parser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import cyou.joiplay.commons.file.FileUtils;
import cyou.joiplay.commons.model.RuffleConfiguration;

public class RuffleConfigurationParser {
    public static void parse(RuffleConfiguration configuration, String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);

        if (jsonObject.has("app")){
            JSONObject appObject = jsonObject.getJSONObject("app");

            if (appObject.has("screenTimeout")){
                configuration.screenTimeout = appObject.getJSONObject("screenTimeout").getInt("int");
            }
        }

        if (jsonObject.has("ruffle")){
            JSONObject ruffleObject = jsonObject.getJSONObject("ruffle");

            if (ruffleObject.has("backend")){
                configuration.backend = ruffleObject.getJSONObject("backend").getString("string");
            }

            if (ruffleObject.has("quality")){
                configuration.quality = ruffleObject.getJSONObject("quality").getString("string");
            }

            if (ruffleObject.has("scaleMode")){
                configuration.scaleMode = ruffleObject.getJSONObject("scaleMode").getString("string");
            }

            if (ruffleObject.has("letterbox")){
                configuration.letterbox = ruffleObject.getJSONObject("letterbox").getString("string");
            }

            if (ruffleObject.has("loadBehavior")){
                configuration.loadBehavior = ruffleObject.getJSONObject("loadBehavior").getString("string");
            }
        }
    }

    public static void loadFromFile(RuffleConfiguration configuration, File file) throws IOException, JSONException {
        JSONObject jsonObject = new JSONObject(FileUtils.readText(file));

        if (jsonObject.has("screenTimeout")){
            configuration.screenTimeout = jsonObject.getInt("screenTimeout");
        }

        if (jsonObject.has("backend")){
            configuration.backend = jsonObject.getString("backend");
        }

        if (jsonObject.has("quality")){
            configuration.quality = jsonObject.getString("quality");
        }

        if (jsonObject.has("scaleMode")){
            configuration.scaleMode = jsonObject.getString("scaleMode");
        }

        if (jsonObject.has("letterbox")){
            configuration.letterbox = jsonObject.getString("letterbox");
        }

        if (jsonObject.has("loadBehavior")){
            configuration.loadBehavior = jsonObject.getString("loadBehavior");
        }
    }

    public static void saveToFile(RuffleConfiguration configuration, File file) throws JSONException, IOException {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("screenTimeout", configuration.screenTimeout);
        jsonObject.put("backend", configuration.backend);
        jsonObject.put("quality", configuration.quality);
        jsonObject.put("scaleMode", configuration.scaleMode);
        jsonObject.put("letterbox", configuration.letterbox);
        jsonObject.put("loadBehavior", configuration.loadBehavior);

        FileUtils.writeText(file, jsonObject.toString(4));
    }
}
