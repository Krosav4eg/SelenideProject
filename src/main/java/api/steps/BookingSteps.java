package api.steps;

import api.endpoints.UrlEndPoints;
import api.service.BookingRestService;
import com.google.gson.JsonObject;
import io.restassured.response.Response;

import static api.dto.BookingGenerator.getBookingDto;
import static api.service.BookingJsonModificationService.generatePriceForJson;
import static io.restassured.RestAssured.given;

/**
 * Following class contains common business actions (CRUD operations) which can be reused in tests.
 */

public class BookingSteps extends BookingRestService {

    public static final String PATH_TO_NEW_BOOKING_FILE = "CreateBooking.json";

    /**
     * В этом методе тело передаётся как DTO
     */
    public static Response createNewBooking() {
        return given()
                .spec(getRequestSpecification())
                .when()
                .body(getBookingDto())
                .post(UrlEndPoints.CREATE_BOOKING.getData())
                .then()
                .extract()
                .response();
    }

    /**
     * В этом методе тело передаётся как Json Object (используется библиотека JSON)
     */
    public static Response createNewBookingUsingJsonObject() {
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("checkin", "2022-11-01");
        jsonObject2.addProperty("checkout", "2022-11-12");

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("firstname", "Sergey");
        jsonObject.addProperty("lastname", "Potapov");
        jsonObject.addProperty("totalprice", 123);
        jsonObject.addProperty("depositpaid", true);
        jsonObject.add("bookingdates", jsonObject2);
        jsonObject.addProperty("additionalneeds", "Breakfast");

        return given()
                .spec(getRequestSpecification())
                .when()
                .body(jsonObject.toString())
                .post(UrlEndPoints.CREATE_BOOKING.getData())
                .then()
                .extract()
                .response();
    }

    /**
     * Тело запроса меняется путём модификации самого JSON файла
     */
    public static Response createNewBookingWithChangedPrice() {
        return given()
                .spec(getRequestSpecification())
                .when()
                .body(generatePriceForJson(PATH_TO_NEW_BOOKING_FILE))
                .post(UrlEndPoints.CREATE_BOOKING.getData())
                .then()
                .extract()
                .response();
    }

    /**
     * В этом методе тело передаётся как строка+ в Request spec добавляется составной хэдер
     */
    public static Response updateBooking(String bookingId) {
        String body = "{\"firstname\":\"Jim\",\"lastname\":\"Brown\",\"totalprice\":175,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2022-11-11\",\"checkout\":\"2022-11-12\"},\"additionalneeds\":\"Diner\"}";

        return given()
                .spec(getRequestSpecificationForBookingUpdate())
                .when()
                .and()
                .body(body)
                .put(UrlEndPoints.UPDATE_BOOKING.getData() + bookingId)
                .then()
                .extract()
                .response();
    }

    public static Response partialBookingUpdate(String bookingId) {
        String body = "{\"firstname\":\"Jim\",\"lastname\":\"Brown\"}";
        return given()
                .spec(getRequestSpecificationForBookingUpdate())
                .when()
                .body(body)
                .patch(UrlEndPoints.UPDATE_BOOKING.getData() + bookingId)
                .then()
                .extract()
                .response();
    }

    public static Response getBookingId(String bookingId) {
        return given()
                .spec(getRequestSpecificationForBookingUpdate())
                .when()
                .get(UrlEndPoints.UPDATE_BOOKING.getData() + bookingId)
                .then()
                .extract()
                .response();
    }

    public static Response deleteBookingById(String bookingId) {
        return given()
                .spec(getRequestSpecification())
                .and().accept("application/json")
                .and().header("Cookie", "token=" + makeAuthorizationAndGetToken())
                .when()
                .delete(UrlEndPoints.UPDATE_BOOKING.getData() + bookingId)
                .then()
                .extract()
                .response();
    }
}