package api.service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BookingRestService extends BaseRestService {

    public static RequestSpecification getRequestSpecificationForBookingUpdate() {
        return new RequestSpecBuilder()
                .addRequestSpecification(getRequestSpecification().accept("application/json")
                        .and().header("Cookie", "token=" + makeAuthorizationAndGetToken())).build();
    }
}