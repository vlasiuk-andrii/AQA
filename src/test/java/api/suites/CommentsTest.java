package api.suites;

import api.BaseRestApiTest;
import com.google.gson.JsonElement;
import core.utils.JsonUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CommentsTest extends BaseRestApiTest {

    Path filePathId1PostId1 = Paths.get("/json/comments/commentId1PostId1.json");

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
        JsonElement expectedResponse = JsonUtils.getJsonFromFile(filePathId1PostId1);

        Response response = httpRequest.get(apiUrl + "/comments?postId=1&id=1");
        JsonElement responseBody = JsonUtils.getJson( response.getBody().asString() );
        logRequest(responseBody, expectedResponse);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, responseBody);
    }

}