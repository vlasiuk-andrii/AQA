package api;

import org.testng.annotations.Test;
import properties.PropertiesHolder;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class PostsTest {

    String apiUrl = PropertiesHolder.getProperty("baseApiUrl");

    @Test
    public void postsResponseIsCorrect(){
        given()
        .when()
            .get(apiUrl + "/posts")
        .then()
            .statusCode(200);
    }

    @Test
    public void postsWithIdResponseIsCorrect(){
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
    public void postSomeDate(){
        Map<String, String> requestJson = new HashMap<>();
        requestJson.put("title", "someTitle");
        requestJson.put("body", "someBody");
        requestJson.put("userId", "166");

        given()
            .contentType("application/json; charset=UTF-8")
            .body(requestJson)
        .when()
            .post(apiUrl + "/posts")
        .then()
            .statusCode(201);
    }

}