package cyou.joiplay.commons.parser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import cyou.joiplay.commons.file.FileUtils;
import cyou.joiplay.commons.model.GamePad;

public class GamePadParser {
    public static void parse(GamePad gamePad, String jsonString) throws JSONException{
        JSONObject jsonObject = new JSONObject(jsonString);

        if (jsonObject.has("gamepad")){
            JSONObject gamepadObject = jsonObject.getJSONObject("gamepad");

            if (gamepadObject.has("diagonalMovement")){
                gamePad.diagonalMovement = gamepadObject.getJSONObject("diagonalMovement").getBoolean("boolean");
            }

            if (gamepadObject.has("btnOpacity")){
                gamePad.btnOpacity = gamepadObject.getJSONObject("btnOpacity").getInt("int");
            }

            if (gamepadObject.has("btnScale")){
                gamePad.btnScale = gamepadObject.getJSONObject("btnScale").getInt("int");
            }

            if (gamepadObject.has("aKeyCode")){
                gamePad.aKeyCode = gamepadObject.getJSONObject("aKeyCode").getInt("int");
            }

            if (gamepadObject.has("bKeyCode")){
                gamePad.bKeyCode = gamepadObject.getJSONObject("bKeyCode").getInt("int");
            }

            if (gamepadObject.has("cKeyCode")){
                gamePad.cKeyCode = gamepadObject.getJSONObject("cKeyCode").getInt("int");
            }

            if (gamepadObject.has("xKeyCode")){
                gamePad.xKeyCode = gamepadObject.getJSONObject("xKeyCode").getInt("int");
            }

            if (gamepadObject.has("yKeyCode")){
                gamePad.yKeyCode = gamepadObject.getJSONObject("yKeyCode").getInt("int");
            }

            if (gamepadObject.has("zKeyCode")){
                gamePad.zKeyCode = gamepadObject.getJSONObject("zKeyCode").getInt("int");
            }

            if (gamepadObject.has("lKeyCode")){
                gamePad.lKeyCode = gamepadObject.getJSONObject("lKeyCode").getInt("int");
            }

            if (gamepadObject.has("rKeyCode")){
                gamePad.rKeyCode = gamepadObject.getJSONObject("rKeyCode").getInt("int");
            }
        }
    }

    public static void loadFromFile(GamePad gamePad, File file) throws IOException, JSONException {
        JSONObject jsonObject = new JSONObject(FileUtils.readText(file));

        if (jsonObject.has("diagonalMovement")){
            gamePad.diagonalMovement = jsonObject.getBoolean("diagonalMovement");
        }

        if (jsonObject.has("btnOpacity")){
            gamePad.btnOpacity = jsonObject.getInt("btnOpacity");
        }

        if (jsonObject.has("btnScale")){
            gamePad.btnScale = jsonObject.getInt("btnScale");
        }

        if (jsonObject.has("aKeyCode")){
            gamePad.aKeyCode = jsonObject.getInt("aKeyCode");
        }

        if (jsonObject.has("bKeyCode")){
            gamePad.bKeyCode = jsonObject.getInt("bKeyCode");
        }

        if (jsonObject.has("cKeyCode")){
            gamePad.cKeyCode = jsonObject.getInt("cKeyCode");
        }

        if (jsonObject.has("xKeyCode")){
            gamePad.xKeyCode = jsonObject.getInt("xKeyCode");
        }

        if (jsonObject.has("yKeyCode")){
            gamePad.yKeyCode = jsonObject.getInt("yKeyCode");
        }

        if (jsonObject.has("zKeyCode")){
            gamePad.zKeyCode = jsonObject.getInt("zKeyCode");
        }

        if (jsonObject.has("lKeyCode")){
            gamePad.lKeyCode = jsonObject.getInt("lKeyCode");
        }

        if (jsonObject.has("rKeyCode")){
            gamePad.rKeyCode = jsonObject.getInt("rKeyCode");
        }
    }

    public static void saveToFile(GamePad gamePad, File file) throws JSONException, IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("diagonalMovement", gamePad.diagonalMovement);
        jsonObject.put("btnOpacity", gamePad.btnOpacity);
        jsonObject.put("btnScale", gamePad.btnScale);
        jsonObject.put("aKeyCode", gamePad.aKeyCode);
        jsonObject.put("bKeyCode", gamePad.bKeyCode);
        jsonObject.put("cKeyCode", gamePad.cKeyCode);
        jsonObject.put("xKeyCode", gamePad.xKeyCode);
        jsonObject.put("yKeyCode", gamePad.yKeyCode);
        jsonObject.put("zKeyCode", gamePad.zKeyCode);
        jsonObject.put("lKeyCode", gamePad.lKeyCode);
        jsonObject.put("rKeyCode", gamePad.rKeyCode);

        FileUtils.writeText(file, jsonObject.toString(4));
    }
}
