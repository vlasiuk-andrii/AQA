package core.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {

    public static JSONObject getJsonFromFile(String path) {
        FileReader reader;
        JSONObject jsonObject = null;
        try {
            reader = new FileReader(System.getProperty("user.dir") + "\\target\\test-classes" + path);
            JSONParser jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
