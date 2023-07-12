package autotests.api;

import api.steps.BookingSteps;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static api.service.BaseRestService.getResponseSpec;
import static api.service.BaseRestService.getResponseSpec;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

@Feature("Booking")
public class BookingTest extends BaseTest {

    private static String bookingId;

    @BeforeClass
    public void getBookingId() {
        Response response = BookingSteps.createNewBooking();
        bookingId = response.path("bookingid").toString();
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink("COM-754")
    @Description("Booking: API [Positive] - create booking with changed price")
    @Test(priority = 0)
    public void createBookingWithChangedPriceTest() {
        BookingSteps.createNewBookingWithChangedPrice()
                .then()
                .spec(getResponseSpec())
                .assertThat().body(matchesJsonSchemaInClasspath(PATH_TO_CREATION_BOOKING_RESPONSE_SCHEMA));
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink("COM-755")
    @Description("Booking: API [Positive] - create booking")
    @Test(priority = 1)
    public void createBookingTest() {
        BookingSteps.createNewBooking()
                .then()
                .spec(getResponseSpec())
                .assertThat().body("booking.bookingdates.checkin", equalTo("2022-11-01"))
                .assertThat().body(matchesJsonSchemaInClasspath(PATH_TO_CREATION_BOOKING_RESPONSE_SCHEMA));
    }

    @Test(dependsOnMethods = "createBookingTest")
    public void createBookingUsingJsonObjectTest() {
        BookingSteps.createNewBookingUsingJsonObject()
                .then()
                .spec(getResponseSpec())
                .assertThat().body("booking.bookingdates.checkin", equalTo("2022-11-01"))
                .assertThat().body(matchesJsonSchemaInClasspath(PATH_TO_CREATION_BOOKING_RESPONSE_SCHEMA));
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink("COM-756")
    @Description("Booking: API [Positive] - update booking")
    @Test(priority = 2)
    public void updateBookingTest() {
        BookingSteps.updateBooking(bookingId)
                .then()
                .spec(getResponseSpec())
                .assertThat().body("totalprice", equalTo(175));
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink("COM-751")
    @Description("Booking: API [Positive] - partial booking update")
    @Test(priority = 3)
    public void partialBookingUpdateTest() {
        BookingSteps.partialBookingUpdate(bookingId)
                .then()
                .spec(getResponseSpec())
                .assertThat().body("firstname", equalTo("Jim"));
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink("COM-757")
    @Description("Booking: API [Positive] - get booking info by id")
    @Test(priority = 4)
    public void getBookingByIdTest() {
        BookingSteps.getBookingId(bookingId)
                .then()
                .spec(getResponseSpec())
                .assertThat().body(matchesJsonSchemaInClasspath(PATH_TO_GENERAL_BOOKING_INFO_SCHEMA));
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @TmsLink("COM-759")
    @Description("Booking: API [Positive] - delete booking by id")
    @Test(priority = 5)
    public void deleteBookingByIdTest() {
        String responseBody = BookingSteps.deleteBookingById(bookingId)
                .then().assertThat().statusCode(HttpStatus.SC_CREATED).extract().body().asString();
        Assert.assertEquals(responseBody, "Created");
    }
}