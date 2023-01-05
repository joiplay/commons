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

            if (gamepadObject.has("hideGamepad")){
                gamePad.hideGamepad = gamepadObject.getJSONObject("hideGamepad").getBoolean("boolean");
            }

            if (gamepadObject.has("btnOpacity")){
                gamePad.btnOpacity = gamepadObject.getJSONObject("btnOpacity").getInt("int");
            }

            if (gamepadObject.has("btnScale")){
                gamePad.btnScale = gamepadObject.getJSONObject("btnScale").getInt("int");
            }

            if (gamepadObject.has("aKeyCode")){
                gamePad.aKeyCode[0] = gamepadObject.getJSONObject("aKeyCode").getInt("int");
            }

            if (gamepadObject.has("aKeyCode1")){
                gamePad.aKeyCode[1] = gamepadObject.getJSONObject("aKeyCode1").getInt("int");
            }

            if (gamepadObject.has("bKeyCode")){
                gamePad.bKeyCode[0] = gamepadObject.getJSONObject("bKeyCode").getInt("int");
            }

            if (gamepadObject.has("bKeyCode1")){
                gamePad.bKeyCode[1] = gamepadObject.getJSONObject("bKeyCode1").getInt("int");
            }

            if (gamepadObject.has("cKeyCode")){
                gamePad.cKeyCode[0] = gamepadObject.getJSONObject("cKeyCode").getInt("int");
            }

            if (gamepadObject.has("cKeyCode1")){
                gamePad.cKeyCode[1] = gamepadObject.getJSONObject("cKeyCode1").getInt("int");
            }

            if (gamepadObject.has("xKeyCode")){
                gamePad.xKeyCode[0] = gamepadObject.getJSONObject("xKeyCode").getInt("int");
            }

            if (gamepadObject.has("xKeyCode1")){
                gamePad.xKeyCode[1] = gamepadObject.getJSONObject("xKeyCode1").getInt("int");
            }

            if (gamepadObject.has("yKeyCode")){
                gamePad.yKeyCode[0] = gamepadObject.getJSONObject("yKeyCode").getInt("int");
            }

            if (gamepadObject.has("yKeyCode1")){
                gamePad.yKeyCode[1] = gamepadObject.getJSONObject("yKeyCode1").getInt("int");
            }

            if (gamepadObject.has("zKeyCode")){
                gamePad.zKeyCode[0] = gamepadObject.getJSONObject("zKeyCode").getInt("int");
            }

            if (gamepadObject.has("zKeyCode1")){
                gamePad.zKeyCode[1] = gamepadObject.getJSONObject("zKeyCode1").getInt("int");
            }

            if (gamepadObject.has("lKeyCode")){
                gamePad.lKeyCode[0] = gamepadObject.getJSONObject("lKeyCode").getInt("int");
            }

            if (gamepadObject.has("lKeyCode1")){
                gamePad.lKeyCode[1] = gamepadObject.getJSONObject("lKeyCode1").getInt("int");
            }

            if (gamepadObject.has("rKeyCode")){
                gamePad.rKeyCode[0] = gamepadObject.getJSONObject("rKeyCode").getInt("int");
            }

            if (gamepadObject.has("rKeyCode1")){
                gamePad.rKeyCode[1] = gamepadObject.getJSONObject("rKeyCode1").getInt("int");
            }

            if (gamepadObject.has("clKeyCode")){
                gamePad.clKeyCode[0] = gamepadObject.getJSONObject("clKeyCode").getInt("int");
            }

            if (gamepadObject.has("clKeyCode1")){
                gamePad.clKeyCode[1] = gamepadObject.getJSONObject("clKeyCode1").getInt("int");
            }

            if (gamepadObject.has("crKeyCode")){
                gamePad.crKeyCode[0] = gamepadObject.getJSONObject("crKeyCode").getInt("int");
            }

            if (gamepadObject.has("crKeyCode1")){
                gamePad.crKeyCode[1] = gamepadObject.getJSONObject("crKeyCode1").getInt("int");
            }
        }
    }

    public static void loadFromFile(GamePad gamePad, File file) throws IOException, JSONException {
        JSONObject jsonObject = new JSONObject(FileUtils.readText(file));

        if (jsonObject.has("diagonalMovement")){
            gamePad.diagonalMovement = jsonObject.getBoolean("diagonalMovement");
        }

        if (jsonObject.has("hideGamepad")){
            gamePad.hideGamepad = jsonObject.getBoolean("hideGamepad");
        }

        if (jsonObject.has("btnOpacity")){
            gamePad.btnOpacity = jsonObject.getInt("btnOpacity");
        }

        if (jsonObject.has("btnScale")){
            gamePad.btnScale = jsonObject.getInt("btnScale");
        }

        if (jsonObject.has("aKeyCode")){
            gamePad.aKeyCode[0] = jsonObject.getInt("aKeyCode");
        }

        if (jsonObject.has("aKeyCode1")){
            gamePad.aKeyCode[1] = jsonObject.getInt("aKeyCode1");
        }

        if (jsonObject.has("bKeyCode")){
            gamePad.bKeyCode[0] = jsonObject.getInt("bKeyCode");
        }

        if (jsonObject.has("bKeyCode1")){
            gamePad.bKeyCode[1] = jsonObject.getInt("bKeyCode1");
        }

        if (jsonObject.has("cKeyCode")){
            gamePad.cKeyCode[0] = jsonObject.getInt("cKeyCode");
        }

        if (jsonObject.has("cKeyCode1")){
            gamePad.cKeyCode[1] = jsonObject.getInt("cKeyCode1");
        }

        if (jsonObject.has("xKeyCode")){
            gamePad.xKeyCode[0] = jsonObject.getInt("xKeyCode");
        }

        if (jsonObject.has("xKeyCode1")){
            gamePad.xKeyCode[1] = jsonObject.getInt("xKeyCode1");
        }

        if (jsonObject.has("yKeyCode")){
            gamePad.yKeyCode[0] = jsonObject.getInt("yKeyCode");
        }

        if (jsonObject.has("yKeyCode1")){
            gamePad.yKeyCode[1] = jsonObject.getInt("yKeyCode1");
        }

        if (jsonObject.has("zKeyCode")){
            gamePad.zKeyCode[0] = jsonObject.getInt("zKeyCode");
        }

        if (jsonObject.has("zKeyCode1")){
            gamePad.zKeyCode[1] = jsonObject.getInt("zKeyCode1");
        }

        if (jsonObject.has("lKeyCode")){
            gamePad.lKeyCode[0] = jsonObject.getInt("lKeyCode");
        }

        if (jsonObject.has("lKeyCode1")){
            gamePad.lKeyCode[1] = jsonObject.getInt("lKeyCode1");
        }

        if (jsonObject.has("rKeyCode")){
            gamePad.rKeyCode[0] = jsonObject.getInt("rKeyCode");
        }

        if (jsonObject.has("rKeyCode1")){
            gamePad.rKeyCode[1] = jsonObject.getInt("rKeyCode1");
        }

        if (jsonObject.has("clKeyCode")){
            gamePad.clKeyCode[0] = jsonObject.getInt("clKeyCode");
        }

        if (jsonObject.has("clKeyCode1")){
            gamePad.clKeyCode[1] = jsonObject.getInt("clKeyCode1");
        }

        if (jsonObject.has("crKeyCode")){
            gamePad.crKeyCode[0] = jsonObject.getInt("crKeyCode");
        }

        if (jsonObject.has("crKeyCode1")){
            gamePad.crKeyCode[1] = jsonObject.getInt("crKeyCode1");
        }
    }

    public static void saveToFile(GamePad gamePad, File file) throws JSONException, IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("diagonalMovement", gamePad.diagonalMovement);
        jsonObject.put("hideGamepad", gamePad.hideGamepad);
        jsonObject.put("btnOpacity", gamePad.btnOpacity);
        jsonObject.put("btnScale", gamePad.btnScale);
        jsonObject.put("aKeyCode", gamePad.aKeyCode[0]);
        jsonObject.put("bKeyCode", gamePad.bKeyCode[0]);
        jsonObject.put("cKeyCode", gamePad.cKeyCode[0]);
        jsonObject.put("xKeyCode", gamePad.xKeyCode[0]);
        jsonObject.put("yKeyCode", gamePad.yKeyCode[0]);
        jsonObject.put("zKeyCode", gamePad.zKeyCode[0]);
        jsonObject.put("lKeyCode", gamePad.lKeyCode[0]);
        jsonObject.put("rKeyCode", gamePad.rKeyCode[0]);
        jsonObject.put("clKeyCode", gamePad.clKeyCode[0]);
        jsonObject.put("crKeyCode", gamePad.crKeyCode[0]);
        jsonObject.put("aKeyCode1", gamePad.aKeyCode[1]);
        jsonObject.put("bKeyCode1", gamePad.bKeyCode[1]);
        jsonObject.put("cKeyCode1", gamePad.cKeyCode[1]);
        jsonObject.put("xKeyCode1", gamePad.xKeyCode[1]);
        jsonObject.put("yKeyCode1", gamePad.yKeyCode[1]);
        jsonObject.put("zKeyCode1", gamePad.zKeyCode[1]);
        jsonObject.put("lKeyCode1", gamePad.lKeyCode[1]);
        jsonObject.put("rKeyCode1", gamePad.rKeyCode[1]);
        jsonObject.put("clKeyCode1", gamePad.clKeyCode[1]);
        jsonObject.put("crKeyCode1", gamePad.crKeyCode[1]);

        FileUtils.writeText(file, jsonObject.toString(4));
    }
}
