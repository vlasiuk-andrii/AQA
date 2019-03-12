package api.suites;

import api.BaseRestApiTest;
import com.jayway.restassured.response.Response;
import core.utils.JsonUtils;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PostsTest extends BaseRestApiTest {

    @Test
    public void postsResponseIsCorrect() {
        given()
                .when()
                .get(apiUrl + "/posts")
                .then()
                .statusCode(200);
    }

    @Test
    public void postsWithIdResponseIsCorrect() throws JSONException {
        JSONObject expectedResponse = JsonUtils.getJsonObjectFromFile("/json/posts/postId1.json");

        Response response = httpRequest.get(apiUrl + "/posts/1");
        JSONObject responseBody = JsonUtils.getJsonObject( response.getBody().asString() );
        logRequest(responseBody, expectedResponse);

        assertEquals(200, response.getStatusCode());
        JSONAssert.assertEquals(expectedResponse.toString(), response.body().asString(), false);
    }

    @Test
    public void postSmthInPostsDate() throws JSONException {
        JSONObject expectedResponse = JsonUtils.getJsonObjectFromFile("/json/posts/posts.json");

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("title", "someTitle");
        requestBody.put("body", "someBody");
        requestBody.put("userId", "166");

        httpRequest.header("Content-Type", "application/json; charset=UTF-8");
        httpRequest.body(requestBody);

        Response response = httpRequest.post(apiUrl + "/posts");
        JSONObject responseBody = JsonUtils.getJsonObject( response.getBody().asString() );
        logRequest(requestBody, responseBody, expectedResponse);

        assertEquals(201, response.getStatusCode());
        JSONAssert.assertEquals(expectedResponse.toString(), responseBody.toString(), false);
    }

}