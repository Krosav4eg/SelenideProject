package autotests.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BaseTest {

    protected static final String PATH_TO_CREATION_BOOKING_RESPONSE_SCHEMA = "json/schemas/CreateBookingSchema.json";
    protected static final String PATH_TO_GENERAL_BOOKING_INFO_SCHEMA = "json/schemas/BookingInfoSchema.json";

    static {
        RestAssured.filters(new AllureRestAssured());
    }
}