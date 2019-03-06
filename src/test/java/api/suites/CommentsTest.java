package api.suites;

import api.BaseRestApiTest;
import com.jayway.restassured.response.Response;
import core.utils.JsonUtils;
import org.json.simple.JSONArray;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
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
        logRequest(response.getBody().asString(), expectedResponse.toString());

        assertEquals(200, response.getStatusCode());
        JSONAssert.assertEquals(expectedResponse.toString(), response.getBody().asString(), false);
    }

}