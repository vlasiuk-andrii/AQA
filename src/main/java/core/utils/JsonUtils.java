package core.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {

    public static JSONObject getJsonFromFile(String path) {
        FileReader reader;
        JSONObject jsonObject = null;
        JSONArray jsonArray = null;
        String jsonString;
        try {
            reader = new FileReader(System.getProperty("user.dir") + "\\target\\test-classes" + path);
            JSONParser jsonParser = new JSONParser();
            if ( jsonParser.parse(reader).getClass().getName().equals("org.json.simple.JSONObject")){
                jsonObject = (JSONObject) jsonParser.parse(reader);
            } else if (jsonParser.parse(reader).getClass().getName().equals("org.json.simple.JSONArray")) {
                jsonArray = (JSONArray) jsonParser.parse(reader);
                jsonString = jsonArray.toJSONString();
                jsonObject = (JSONObject) jsonParser.parse(jsonString);
            } else throw new NullPointerException("Can't parse JSON from file");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
