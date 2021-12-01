package cyou.joiplay.commons.parser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import cyou.joiplay.commons.file.FileUtils;
import cyou.joiplay.commons.model.MKXPConfiguration;

public class MKXPConfigurationParser {
    public static void parse(MKXPConfiguration configuration, String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);

        if (jsonObject.has("app")){
            JSONObject appObject = jsonObject.getJSONObject("app");

            if (appObject.has("cheats")){
                configuration.cheats = appObject.getJSONObject("cheats").getBoolean("boolean");
            }
        }

        if (jsonObject.has("rpg")){
            JSONObject rpgObject = jsonObject.getJSONObject("rpg");

            if (rpgObject.has("windowSize")){
                configuration.forcedDim = rpgObject.getJSONObject("windowSize").getString("string");
            }

            if (rpgObject.has("fontScale")){
                configuration.fontScale = rpgObject.getJSONObject("fontScale").getString("string");
            }

            if (rpgObject.has("speedUp")){
                configuration.fastForwardSpeed = rpgObject.getJSONObject("speedUp").getString("string");
            }

            if (rpgObject.has("customFont")){
                configuration.customFont = rpgObject.getJSONObject("customFont").getString("string");
            }

            if (rpgObject.has("enablePostloadScripts")){
                configuration.enablePostloadScripts = rpgObject.getJSONObject("enablePostloadScripts").getBoolean("boolean");
            }

            if (rpgObject.has("pathCache")){
                configuration.pathCache = rpgObject.getJSONObject("pathCache").getBoolean("boolean");
            }

            if (rpgObject.has("prebuiltPathCache")){
                configuration.prebuiltPathCache = rpgObject.getJSONObject("prebuiltPathCache").getBoolean("boolean");
            }

            if (rpgObject.has("smoothScaling")){
                configuration.smoothScaling = rpgObject.getJSONObject("smoothScaling").getBoolean("boolean");
            }

            if (rpgObject.has("vsync")){
                configuration.vsync = rpgObject.getJSONObject("vsync").getBoolean("boolean");
            }

            if (rpgObject.has("frameSkip")){
                configuration.frameSkip = rpgObject.getJSONObject("frameSkip").getBoolean("boolean");
            }

            if (rpgObject.has("solidFonts")){
                configuration.solidFonts = rpgObject.getJSONObject("solidFonts").getBoolean("boolean");
            }

            if (rpgObject.has("copyText")){
                configuration.copyText = rpgObject.getJSONObject("copyText").getBoolean("boolean");
            }

            if (rpgObject.has("debug")){
                configuration.debug = rpgObject.getJSONObject("debug").getBoolean("boolean");
            }

            if (rpgObject.has("useRuby18")){
                configuration.useRuby18 = rpgObject.getJSONObject("useRuby18").getBoolean("boolean");
            }
        }
    }

    public static void loadFromFile(MKXPConfiguration configuration, File file) throws IOException, JSONException {
        JSONObject jsonObject = new JSONObject(FileUtils.readText(file));

        if (jsonObject.has("windowSize")){
            configuration.forcedDim = jsonObject.getString("windowSize");
        }

        if (jsonObject.has("fontScale")){
            configuration.fontScale = jsonObject.getString("fontScale");
        }

        if (jsonObject.has("speedUp")){
            configuration.fastForwardSpeed = jsonObject.getString("speedUp");
        }

        if (jsonObject.has("customFont")){
            configuration.customFont = jsonObject.getString("customFont");
        }

        if (jsonObject.has("enablePostloadScripts")){
            configuration.enablePostloadScripts = jsonObject.getBoolean("enablePostloadScripts");
        }

        if (jsonObject.has("pathCache")){
            configuration.pathCache = jsonObject.getBoolean("pathCache");
        }

        if (jsonObject.has("prebuiltPathCache")){
            configuration.prebuiltPathCache = jsonObject.getBoolean("prebuiltPathCache");
        }

        if (jsonObject.has("smoothScaling")){
            configuration.smoothScaling = jsonObject.getBoolean("smoothScaling");
        }

        if (jsonObject.has("vsync")){
            configuration.vsync = jsonObject.getBoolean("vsync");
        }

        if (jsonObject.has("frameSkip")){
            configuration.frameSkip = jsonObject.getBoolean("frameSkip");
        }

        if (jsonObject.has("solidFonts")){
            configuration.solidFonts = jsonObject.getBoolean("solidFonts");
        }

        if (jsonObject.has("copyText")){
            configuration.copyText = jsonObject.getBoolean("copyText");
        }

        if (jsonObject.has("cheats")){
            configuration.cheats = jsonObject.getBoolean("cheats");
        }

        if (jsonObject.has("debug")){
            configuration.debug = jsonObject.getBoolean("debug");
        }

        if (jsonObject.has("useRuby18")){
            configuration.useRuby18 = jsonObject.getBoolean("useRuby18");
        }
    }

    public static void saveToFile(MKXPConfiguration configuration, File file) throws JSONException, IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("windowSize", configuration.forcedDim);
        jsonObject.put("fontScale", configuration.fontScale);
        jsonObject.put("speedUp", configuration.fastForwardSpeed);
        jsonObject.put("customFont", configuration.customFont);
        jsonObject.put("enablePostloadScripts", configuration.enablePostloadScripts);
        jsonObject.put("pathCache", configuration.pathCache);
        jsonObject.put("prebuiltPathCache", configuration.prebuiltPathCache);
        jsonObject.put("smoothScaling", configuration.smoothScaling);
        jsonObject.put("vsync", configuration.vsync);
        jsonObject.put("solidFonts", configuration.solidFonts);
        jsonObject.put("copyText", configuration.copyText);
        jsonObject.put("cheats", configuration.cheats);
        jsonObject.put("debug", configuration.debug);
        jsonObject.put("useRuby18", configuration.useRuby18);

        FileUtils.writeText(file, jsonObject.toString(4));
    }
}
