package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;
import utils.PropsConfig;

import static api.serializableClasses.User.getUserAuth;
import static io.restassured.RestAssured.given;

public class BaseStep {
    public static final PropsConfig PROPS_CONFIG = ConfigFactory.create(PropsConfig.class);

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(PROPS_CONFIG.BASE_API_URL())
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectHeader("Server","Cowboy")
                .expectHeader("Connection","keep-alive")
                .expectHeader("X-Powered-By","Express")
                .expectHeader("Content-Type","application/json; charset=utf-8")
                .expectHeader("Via","1.1 vegur")
                .build();
    }

    public static RequestSpecification getRequestSpecificationForBookingUpdate() {
        return new RequestSpecBuilder()
                .setBaseUri(PROPS_CONFIG.BASE_API_URL())
                .setAccept("application/json")
                .setContentType(ContentType.JSON)
                .addHeader("Cookie", "token=" + makeAuthorizationAndGetToken())
                .build();
    }

    public static String makeAuthorizationAndGetToken() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(PROPS_CONFIG.BASE_API_URL())
                .setContentType(ContentType.JSON)
                .build();
        return given(requestSpecification)
                .body(getUserAuth(PROPS_CONFIG.LOGIN(), PROPS_CONFIG.PASSWORD()))
                .when()
                .post("/auth")
                .then().statusCode(HttpStatus.SC_OK).extract().path("token");
    }
}