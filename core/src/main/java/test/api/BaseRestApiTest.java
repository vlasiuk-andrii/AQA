package test.api;

import com.google.gson.JsonElement;
import main.core.dto.BaseDTO;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import main.properties.PropertiesHolder;

import java.util.Map;

public class BaseRestApiTest {

    protected String apiUrl = PropertiesHolder.getProperty("base.test.api.url");
    protected RequestSpecification httpRequest = RestAssured.given();

    static final Logger LOGGER = LoggerFactory.getLogger(BaseDTO.class);

    protected void logRequest(Map<String, String> request, JsonElement response, JsonElement expectedResponse){
        LOGGER.info("Request: " + request.toString());
        LOGGER.info("Response:          " + response.toString());
        LOGGER.info("Expected response: " + expectedResponse.toString() + "\n");
    }

    protected void logRequest(JsonElement response, JsonElement expectedResponse){
        LOGGER.info("Response:          " + response.toString());
        LOGGER.info("Expected response: " + expectedResponse.toString() + "\n");
    }
}
