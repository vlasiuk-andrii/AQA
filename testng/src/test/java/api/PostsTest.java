package api;

import test.api.BaseRestApiTest;
import com.google.gson.JsonElement;
import main.core.utils.JsonUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PostsTest extends BaseRestApiTest {

    Path filePathPostId1 = Paths.get("/json/posts/postId1.json");
    Path filePathPosts = Paths.get("/json/posts/posts.json");

    @Test
    public void postsResponseIsCorrect() {
        given()
                .when()
                .get(apiUrl + "/posts")
                .then()
                .statusCode(200);
    }

    @Test
    public void postsWithIdResponseIsCorrect() {
        JsonElement expectedResponse = JsonUtils.getJsonFromFile(filePathPostId1);

        Response response = httpRequest.get(apiUrl + "/posts/1");
        JsonElement responseBody = JsonUtils.getJson( response.getBody().asString() );
        logRequest(responseBody, expectedResponse);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, responseBody);
    }

    @Test
    public void postSmthInPostsDate() {
        JsonElement expectedResponse = JsonUtils.getJsonFromFile(filePathPosts);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("title", "someTitle");
        requestBody.put("body", "someBody");
        requestBody.put("userId", "166");

        httpRequest.header("Content-Type", "application/json; charset=UTF-8");
        httpRequest.body(requestBody);

        Response response = httpRequest.post(apiUrl + "/posts");
        JsonElement responseBody = JsonUtils.getJson( response.getBody().asString() );
        logRequest(requestBody, responseBody, expectedResponse);

        assertEquals(201, response.getStatusCode());
        assertEquals(expectedResponse, responseBody);
    }

}