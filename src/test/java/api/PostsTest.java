package api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import core.utils.JsonUtils;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.Test;
import properties.PropertiesHolder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostsTest {

    String apiUrl = PropertiesHolder.getProperty("baseApiUrl");

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
        given()
                .when()
                .get(apiUrl + "/posts/1")
                .then()
                .body("id", equalTo(1))
                .body("userId", equalTo(1))
                .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
//                .body("body", contains("quia et suscipit\n" +
//                        "suscipit recusandae consequuntur expedita et cum\n" +
//                        "reprehenderit molestiae ut ut quas totam\n" +
//                        "nostrum rerum est autem sunt rem eveniet architecto"))
                .statusCode(200);
    }

    @Test
    public void postSmthInPostsDate() throws JSONException, IOException, ParseException {
        RequestSpecification httpRequest = RestAssured.given();

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

        JSONObject expectedResponse = JsonUtils.getJsonFromFile("/json/posts.json");
        System.out.println("ExpectedResponse: " + expectedResponse);
        JSONAssert.assertEquals(expectedResponse.toString(), responseBody, false);
    }

}