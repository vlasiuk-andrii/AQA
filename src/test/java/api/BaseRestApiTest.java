package api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import core.dto.BaseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import properties.PropertiesHolder;

public class BaseRestApiTest {

    protected String apiUrl = PropertiesHolder.getProperty("baseApiUrl");
    protected RequestSpecification httpRequest = RestAssured.given();

    static final Logger LOGGER = LoggerFactory.getLogger(BaseDTO.class);

    protected void logRequest(String request, String response, String expectedResponse){
        LOGGER.info("Request: " + request);
        LOGGER.info("Response: " + response);
        LOGGER.info("Expected response: " + expectedResponse + "\n\n");
    }

    protected void logRequest(String response, String expectedResponse){
        LOGGER.info("Response: " + response);
        LOGGER.info("Expected response: " + expectedResponse + "\n\n");
    }
}
