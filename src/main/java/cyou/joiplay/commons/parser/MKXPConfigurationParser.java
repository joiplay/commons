package cyou.joiplay.commons.parser;

import org.json.JSONException;
import org.json.JSONObject;

import cyou.joiplay.commons.model.MKXPConfiguration;

public class MKXPConfigurationParser {
    public static void parse(MKXPConfiguration configuration, String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);

        if (jsonObject.has("windowSize")){
            configuration.forcedDim = jsonObject.getJSONObject("windowSize").getString("string");
        }

        if (jsonObject.has("fontScale")){
            configuration.fontScale = jsonObject.getJSONObject("fontScale").getString("string");
        }

        if (jsonObject.has("speedUp")){
            configuration.fastForwardSpeed = jsonObject.getJSONObject("speedUp").getString("string");
        }

        if (jsonObject.has("customFont")){
            configuration.customFont = jsonObject.getJSONObject("customFont").getString("string");
        }

        if (jsonObject.has("enablePostloadScripts")){
            configuration.enablePostloadScripts = jsonObject.getJSONObject("enablePostloadScripts").getBoolean("boolean");
        }

        if (jsonObject.has("pathCache")){
            configuration.pathCache = jsonObject.getJSONObject("pathCache").getBoolean("boolean");
        }

        if (jsonObject.has("prebuiltPathCache")){
            configuration.prebuiltPathCache = jsonObject.getJSONObject("prebuiltPathCache").getBoolean("boolean");
        }

        if (jsonObject.has("smoothScaling")){
            configuration.smoothScaling = jsonObject.getJSONObject("smoothScaling").getBoolean("boolean");
        }

        if (jsonObject.has("vsync")){
            configuration.vsync = jsonObject.getJSONObject("vsync").getBoolean("boolean");
        }

        if (jsonObject.has("frameSkip")){
            configuration.frameSkip = jsonObject.getJSONObject("frameSkip").getBoolean("boolean");
        }

        if (jsonObject.has("solidFonts")){
            configuration.solidFonts = jsonObject.getJSONObject("solidFonts").getBoolean("boolean");
        }

        if (jsonObject.has("copyText")){
            configuration.copyText = jsonObject.getJSONObject("copyText").getBoolean("boolean");
        }

        if (jsonObject.has("cheats")){
            configuration.cheats = jsonObject.getJSONObject("cheats").getBoolean("boolean");
        }

        if (jsonObject.has("debug")){
            configuration.debug = jsonObject.getJSONObject("debug").getBoolean("boolean");
        }

        if (jsonObject.has("useRuby18")){
            configuration.useRuby18 = jsonObject.getJSONObject("useRuby18").getBoolean("boolean");
        }

        return;
    }
}
