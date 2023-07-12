package api.service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/**
 * Following class contains certain specifications which can be reused for BookingSteps class.
 */

public class BookingRestService extends BaseRestService {

    public static RequestSpecification getRequestSpecificationForBookingUpdate() {
        return new RequestSpecBuilder()
                .addRequestSpecification(getRequestSpecification().accept("application/json")
                        .and().header("Cookie", "token=" + makeAuthorizationAndGetToken())).build();
    }
}