package api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import core.dto.BaseDTO;
import core.utils.JsonUtils;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import properties.PropertiesHolder;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PostsTest {

    String apiUrl = PropertiesHolder.getProperty("baseApiUrl");
    RequestSpecification httpRequest = RestAssured.given();
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDTO.class);

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
        LOGGER.info("Request: " + requestBody.toString());
        LOGGER.info("Response: " + response.body().asString());
        LOGGER.info("Expected response: " + expectedResponse.toString());

        assertEquals(201, response.getStatusCode());
        JSONAssert.assertEquals(expectedResponse.toString(), response.body().asString(), false);
    }

}