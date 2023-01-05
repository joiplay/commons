package cyou.joiplay.commons.parser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import cyou.joiplay.commons.file.FileUtils;
import cyou.joiplay.commons.model.RenPyConfiguration;

public class RenPyConfigurationParser {
    public static void parse(RenPyConfiguration configuration, String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);

        if (jsonObject.has("app")){
            JSONObject appObject = jsonObject.getJSONObject("app");

            if (appObject.has("cheats")){
                configuration.cheats = appObject.getJSONObject("cheats").getBoolean("boolean");
            }

            if (appObject.has("screenTimeout")){
                configuration.screenTimeout = appObject.getJSONObject("screenTimeout").getInt("int");
            }
        }

        if (jsonObject.has("renpy")){
            JSONObject renpyObject = jsonObject.getJSONObject("renpy");

            if (renpyObject.has("renpy_hw_video")){
                configuration.renpy_hw_video = renpyObject.getJSONObject("renpy_hw_video").getBoolean("boolean");
            }

            if (renpyObject.has("renpy_autosave")){
                configuration.renpy_autosave = renpyObject.getJSONObject("renpy_autosave").getBoolean("boolean");
            }

            if (renpyObject.has("renpy_phonesmallvariant")){
                configuration.renpy_phonesmallvariant = renpyObject.getJSONObject("renpy_phonesmallvariant").getBoolean("boolean");
            }

            if (renpyObject.has("renpy_vsync")){
                configuration.renpy_vsync = renpyObject.getJSONObject("renpy_vsync").getBoolean("boolean");
            }

            if (renpyObject.has("renpy_less_memory")){
                configuration.renpy_less_memory = renpyObject.getJSONObject("renpy_less_memory").getBoolean("boolean");
            }

            if (renpyObject.has("renpy_less_updates")){
                configuration.renpy_less_updates = renpyObject.getJSONObject("renpy_less_updates").getBoolean("boolean");
            }
        }
    }

    public static void loadFromFile(RenPyConfiguration configuration, File file) throws IOException, JSONException {
        JSONObject jsonObject = new JSONObject(FileUtils.readText(file));

        if (jsonObject.has("screenTimeout")){
            configuration.screenTimeout = jsonObject.getInt("screenTimeout");
        }

        if (jsonObject.has("cheats")){
            configuration.cheats = jsonObject.getBoolean("cheats");
        }

        if (jsonObject.has("renpy_hw_video")){
            configuration.renpy_hw_video = jsonObject.getBoolean("renpy_hw_video");
        }

        if (jsonObject.has("renpy_autosave")){
            configuration.renpy_autosave = jsonObject.getBoolean("renpy_autosave");
        }

        if (jsonObject.has("renpy_phonesmallvariant")){
            configuration.renpy_phonesmallvariant = jsonObject.getBoolean("renpy_phonesmallvariant");
        }

        if (jsonObject.has("renpy_vsync")){
            configuration.renpy_vsync = jsonObject.getBoolean("renpy_vsync");
        }

        if (jsonObject.has("renpy_less_memory")){
            configuration.renpy_less_memory = jsonObject.getBoolean("renpy_less_memory");
        }

        if (jsonObject.has("renpy_less_updates")){
            configuration.renpy_less_updates = jsonObject.getBoolean("renpy_less_updates");
        }
    }

    public static void saveToFile(RenPyConfiguration configuration, File file) throws JSONException, IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("screenTimeout", configuration.screenTimeout);
        jsonObject.put("cheats", configuration.cheats);
        jsonObject.put("renpy_hw_video", configuration.renpy_hw_video);
        jsonObject.put("renpy_autosave", configuration.renpy_autosave);
        jsonObject.put("renpy_phonesmallvariant", configuration.renpy_phonesmallvariant);
        jsonObject.put("renpy_vsync", configuration.renpy_vsync);
        jsonObject.put("renpy_less_memory", configuration.renpy_less_memory);
        jsonObject.put("renpy_less_updates", configuration.renpy_less_updates);

        FileUtils.writeText(file, jsonObject.toString(4));
    }
}
