package cyou.joiplay.commons.parser;

import org.json.JSONException;
import org.json.JSONObject;

import cyou.joiplay.commons.model.Game;

public class GameParser {
    public static void parse(Game game, String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);

        if (jsonObject.has("title")){
            game.title = jsonObject.getString("title");
        }

        if (jsonObject.has("id")){
            game.id = jsonObject.getString("id");
        }

        if (jsonObject.has("folder")){
            game.folder = jsonObject.getString("folder");
        }

        if (jsonObject.has("execFile")){
            game.execFile = jsonObject.getString("execFile");
        }

        if (jsonObject.has("type")){
            game.type = jsonObject.getString("type");
        }

        return;
    }
}
