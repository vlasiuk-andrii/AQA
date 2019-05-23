package main.core.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;

public class JsonUtils {

    static FileReader reader;
    static JsonParser parser = new JsonParser();

    public static JsonElement getJsonFromFile(Path path) {
        JsonElement jsonElement = null;
        try {
            File file = new File(System.getProperty("user.dir")).getParentFile();
            reader = new FileReader(file.getAbsolutePath() + "\\core\\target\\classes" + path);
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