package core.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {

    static FileReader reader;
    static JSONParser jsonParser = new JSONParser();

    public static JSONObject getJsonObjectFromFile(String path) {
        JSONObject jsonObject = null;
        try {
            reader = new FileReader(System.getProperty("user.dir") + "\\target\\test-classes" + path);
                jsonObject = (JSONObject) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JSONArray getJsonArrayFromFile(String path) {
        JSONArray jsonArray = null;
        try {
            reader = new FileReader(System.getProperty("user.dir") + "\\target\\test-classes" + path);
            jsonArray = (JSONArray) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}