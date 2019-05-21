package main.core.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;

public class JsonUtils {

    static FileReader reader;
    static JsonParser parser = new JsonParser();

    public static JsonElement getJsonFromFile(Path path) {
        JsonElement jsonElement = null;
        try {
            reader = new FileReader(System.getProperty("user.dir") + "\\target\\test-classes" + path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        jsonElement = parser.parse(reader);
        return jsonElement;
    }

    public static JsonElement getJson(String json) {
        return parser.parse(json);
    }
}