package cyou.joiplay.commons.parser;

import org.json.JSONException;
import org.json.JSONObject;

import cyou.joiplay.commons.model.RenPyConfiguration;

public class RenPyConfigurationParser {
    public static void parse(RenPyConfiguration configuration, String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);

        if (jsonObject.has("cheats")){
            configuration.cheats = jsonObject.getJSONObject("cheats").getBoolean("boolean");
        }

        if (jsonObject.has("renpy_hw_video")){
            configuration.renpy_hw_video = jsonObject.getJSONObject("renpy_hw_video").getBoolean("boolean");
        }

        if (jsonObject.has("renpy_autosave")){
            configuration.renpy_autosave = jsonObject.getJSONObject("renpy_autosave").getBoolean("boolean");
        }

        if (jsonObject.has("renpy_phonesmallvariant")){
            configuration.renpy_phonesmallvariant = jsonObject.getJSONObject("renpy_phonesmallvariant").getBoolean("boolean");
        }

        if (jsonObject.has("renpy_vsync")){
            configuration.renpy_vsync = jsonObject.getJSONObject("renpy_vsync").getBoolean("boolean");
        }

        if (jsonObject.has("renpy_less_memory")){
            configuration.renpy_less_memory = jsonObject.getJSONObject("renpy_less_memory").getBoolean("boolean");
        }

        if (jsonObject.has("renpy_less_updates")){
            configuration.renpy_less_updates = jsonObject.getJSONObject("renpy_less_updates").getBoolean("boolean");
        }

        return;
    }
}
