package api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import core.utils.JsonUtils;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.Test;
import properties.PropertiesHolder;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PostsTest {

    String apiUrl = PropertiesHolder.getProperty("baseApiUrl");
    RequestSpecification httpRequest = RestAssured.given();

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
        String expectedResponse = JsonUtils.getJsonFromFile("/json/posts/postId1.json").toString();

        Response response = httpRequest.get(apiUrl + "/posts/1");

        assertEquals(200, response.getStatusCode());
        JSONAssert.assertEquals(expectedResponse, response.body().asString(), false);
    }

    @Test
    public void postSmthInPostsDate() throws JSONException {
        Map<String, String> requestJson = new HashMap<>();
        requestJson.put("title", "someTitle");
        requestJson.put("body", "someBody");
        requestJson.put("userId", "166");

        httpRequest.header("Content-Type", "application/json; charset=UTF-8");
        httpRequest.body(requestJson);

        Response response = httpRequest.post(apiUrl + "/posts");
        String responseBody = response.body().asString();
        System.out.println("Request: " + requestJson.toString());
        System.out.println("Response: " + responseBody);

        String expectedResponse = JsonUtils.getJsonFromFile("/json/posts/posts.json").toString();
        System.out.println("ExpectedResponse: " + expectedResponse);

        assertEquals(201, response.getStatusCode());
        JSONAssert.assertEquals(expectedResponse, responseBody, false);
    }

}