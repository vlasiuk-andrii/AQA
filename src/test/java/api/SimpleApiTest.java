package api;

import org.testng.annotations.Test;
import properties.PropertiesHolder;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SimpleApiTest {

    String apiUrl = PropertiesHolder.getProperty("baseApiUrl");

    @Test
    public void isServerUp(){
        given()
        .when()
            .get(apiUrl)
        .then()
            .statusCode(200);
    }

    @Test
    public void todosResponseIsCorrect(){
        given()
        .when()
            .get(apiUrl + "/todos/1")
        .then()
            .body("id", equalTo(1))
            .body("userId", equalTo(1))
            .body("title", equalTo("delectus aut autem"))
            .body("completed", equalTo(false))
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