package cyou.joiplay.commons.parser;

import org.json.JSONException;
import org.json.JSONObject;

import cyou.joiplay.commons.model.GamePad;

public class GamePadParser {
    public static void parse(GamePad gamePad, String jsonString) throws JSONException{
        JSONObject jsonObject = new JSONObject(jsonString);

        if (jsonObject.has("btnOpacity")){
            gamePad.btnOpacity = jsonObject.getJSONObject("btnOpacity").getInt("int");
        }

        if (jsonObject.has("btnScale")){
            gamePad.btnScale = jsonObject.getJSONObject("btnScale").getInt("int");
        }

        if (jsonObject.has("aKeyCode")){
            gamePad.aKeyCode = jsonObject.getJSONObject("aKeyCode").getInt("int");
        }

        if (jsonObject.has("bKeyCode")){
            gamePad.bKeyCode = jsonObject.getJSONObject("bKeyCode").getInt("int");
        }

        if (jsonObject.has("cKeyCode")){
            gamePad.cKeyCode = jsonObject.getJSONObject("cKeyCode").getInt("int");
        }

        if (jsonObject.has("xKeyCode")){
            gamePad.xKeyCode = jsonObject.getJSONObject("xKeyCode").getInt("int");
        }

        if (jsonObject.has("yKeyCode")){
            gamePad.yKeyCode = jsonObject.getJSONObject("yKeyCode").getInt("int");
        }

        if (jsonObject.has("zKeyCode")){
            gamePad.zKeyCode = jsonObject.getJSONObject("zKeyCode").getInt("int");
        }

        if (jsonObject.has("lKeyCode")){
            gamePad.lKeyCode = jsonObject.getJSONObject("lKeyCode").getInt("int");
        }

        if (jsonObject.has("rKeyCode")){
            gamePad.rKeyCode = jsonObject.getJSONObject("rKeyCode").getInt("int");
        }

        return;
    }
}
