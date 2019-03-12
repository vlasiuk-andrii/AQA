package api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import core.dto.BaseDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import properties.PropertiesHolder;

import java.util.Map;

public class BaseRestApiTest {

    protected String apiUrl = PropertiesHolder.getProperty("baseApiUrl");
    protected RequestSpecification httpRequest = RestAssured.given();

    static final Logger LOGGER = LoggerFactory.getLogger(BaseDTO.class);

    protected void logRequest(Map<String, String> request, JSONObject response, JSONObject expectedResponse){
        LOGGER.info("Request: " + request.toString());
        LOGGER.info("Response:          " + response.toString());
        LOGGER.info("Expected response: " + expectedResponse.toString() + "\n");
    }

    protected void logRequest(JSONObject response, JSONObject expectedResponse){
        LOGGER.info("Response:          " + response.toString());
        LOGGER.info("Expected response: " + expectedResponse.toString() + "\n");
    }

    protected void logRequest(JSONArray response, JSONArray expectedResponse){
        LOGGER.info("Response:          " + response.toString());
        LOGGER.info("Expected response: " + expectedResponse.toString() + "\n");
    }
}
