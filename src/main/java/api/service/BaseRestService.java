package api.service;

import api.serializableClasses.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;
import utils.PropsConfig;

import static io.restassured.RestAssured.given;

public class BaseRestService {

    public static final PropsConfig PROPS_CONFIG = ConfigFactory.create(PropsConfig.class);

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(PROPS_CONFIG.BASE_API_URL())
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectHeader("Server", "Cowboy")
                .expectHeader("Connection", "keep-alive")
                .expectHeader("X-Powered-By", "Express")
                .expectHeader("Content-Type", "application/json; charset=utf-8")
                .expectHeader("Via", "1.1 vegur")
                .build();
    }

    public static String makeAuthorizationAndGetToken() {
        return given(getRequestSpecification())
                .body(new User(PROPS_CONFIG.LOGIN(), PROPS_CONFIG.PASSWORD()))
                .when()
                .post("/auth")
                .then().statusCode(HttpStatus.SC_OK).extract().path("token");
    }
}