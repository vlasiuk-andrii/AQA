package core.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {

    public static JSONObject getJsonFromFile(String path) throws IOException, ParseException {
        FileReader reader = new FileReader(System.getProperty("user.dir") + "\\target\\test-classes" + path);
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(reader);
    }
}
