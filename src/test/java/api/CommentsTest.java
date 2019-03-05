package api;

import com.jayway.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import properties.PropertiesHolder;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CommentsTest {

    String apiUrl = PropertiesHolder.getProperty("baseApiUrl");

    @Test
    public void serverResponseIsCorrect(){
        given()
        .when()
            .get(apiUrl + "/comments")
        .then()
            .statusCode(200);
    }

    @Test
    public void listOfCommentsIsCorrect(){
        ValidatableResponse response  = given()
                .when()
                .get(apiUrl + "/comments?postId=1&id=1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("postId", equalTo(1))
                .body("name", equalTo("id labore ex et quam laborum"))
                .body("email", equalTo("Eliseo@gardner.biz"));
    }

}