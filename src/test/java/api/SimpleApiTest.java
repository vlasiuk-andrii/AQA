package api;

import org.testng.annotations.Test;
import properties.PropertiesHolder;

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
            .and()
            .body("userId", equalTo(1))
            .and()
            .body("title", equalTo("delectus aut autem"))
            .and()
            .body("completed", equalTo(false));
    }
}