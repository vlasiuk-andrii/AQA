package api.suites;

import api.BaseRestApiTest;
import core.utils.JsonUtils;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CommentsTest extends BaseRestApiTest {

    @Test
    public void serverResponseIsCorrect(){
        given()
        .when()
            .get(apiUrl + "/comments")
        .then()
            .statusCode(200);
    }

    @Test
    public void listOfCommentsIsCorrect() throws Exception {
        JSONArray expectedResponse = JsonUtils.getJsonArrayFromFile("/json/comments/commentId1PostId1.json");

        Response response = httpRequest.get(apiUrl + "/comments?postId=1&id=1");
        JSONArray responseBody = JsonUtils.getJsonArray( response.getBody().asString() );
        logRequest(responseBody, expectedResponse);

        assertEquals(200, response.getStatusCode());
        JSONAssert.assertEquals(expectedResponse.toString(), response.getBody().asString(), false);
    }

}