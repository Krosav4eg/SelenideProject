package api.service;

import api.serializableClasses.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;
import utils.PropsConfig;

import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * This class contains common specification and data which can be reused in specific classes' services.
 */

@Log4j2
public abstract class BaseRestService {

    public static final PropsConfig PROPS_CONFIG = ConfigFactory.create(PropsConfig.class);

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(PROPS_CONFIG.BASE_API_URL())
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification getResponseSpec() {
        Map<String, Object> expectedHeadersList = Map.of("Content-Type", "application/json; charset=utf-8");
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectHeaders(expectedHeadersList)
                .build();
    }

    public static String makeAuthorizationAndGetToken() {
        log.info("**************- Getting auth token before the test -*****************");
        try {
            Response response = given(getRequestSpecification())
                    .when()
                    .body(new User(PROPS_CONFIG.LOGIN(), PROPS_CONFIG.PASSWORD()))
                    .post("/auth");

            if (response.getStatusCode() == HttpStatus.SC_OK) {
                log.info("**************- Token was successfully generated -**************");
                return response.path("token").toString();
            } else {
                throw new RuntimeException("Failed to get token: " + response.getStatusLine());
            }
        } catch (Exception e) {
            throw new RuntimeException("Authorization error", e);
        }
    }
}