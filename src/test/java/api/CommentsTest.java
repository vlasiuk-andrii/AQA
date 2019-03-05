package api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import core.utils.JsonUtils;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.Test;
import properties.PropertiesHolder;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CommentsTest {

    String apiUrl = PropertiesHolder.getProperty("baseApiUrl");
    RequestSpecification httpRequest = RestAssured.given();


    @Test
    public void serverResponseIsCorrect(){
        given()
        .when()
            .get(apiUrl + "/comments")
        .then()
            .statusCode(200);
    }

    @Test
    public void listOfCommentsIsCorrect() throws JSONException {
        String expectedResponse = JsonUtils.getJsonFromFile("/json/comments/commentId1PostId1.json").toString();

        Response response = httpRequest.get(apiUrl + "comments?postId=1&id=1");

        assertEquals(200, response.getStatusCode());
        JSONAssert.assertEquals(expectedResponse, response.body().asString(), false);
    }

}