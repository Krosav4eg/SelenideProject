package autotests.api;

import api.helper.ConsoleLoggingFilter;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

@Log4j2
public class BaseTest {

    protected static final String PATH_TO_CREATION_BOOKING_RESPONSE_SCHEMA = "json/schemas/CreateBookingSchema.json";
    protected static final String PATH_TO_GENERAL_BOOKING_INFO_SCHEMA = "json/schemas/BookingInfoSchema.json";
    public static final ThreadLocal<String> currentTestName = new ThreadLocal<>();

    @BeforeMethod
    public void beforeMethod(Method method) {
        currentTestName.set(method.getName());
        log.info("======////=== STARTING TEST: {} ===////======", method.getName());
        RestAssured.filters(new AllureRestAssured(),
                new ConsoleLoggingFilter());
    }

    @AfterMethod
    public void cleanup() {
        RestAssured.reset();
        currentTestName.remove();
    }
}