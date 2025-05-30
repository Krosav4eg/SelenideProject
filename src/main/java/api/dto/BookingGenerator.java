package api.dto;

import api.pojo.request.BookingCreationPojo;
import api.pojo.request.BookingDatesPojo;

import java.time.LocalDate;

/**
 * Class for creation request bodies.
 */
public class BookingGenerator {

    static String checkinDate = LocalDate.now().toString();
    static String checkout = LocalDate.now().plusDays(3).toString();

    public static BookingCreationPojo getBookingDto() {
        return BookingCreationPojo.builder()
                .firstname("Sergey")
                .lastname("Potapov")
                .totalprice(123)
                .depositpaid(true)
                .bookingdates(getBookingDatesDto())
                .additionalneeds("Breakfast")
                .build();
    }

    public static BookingDatesPojo getBookingDatesDto() {

        return BookingDatesPojo.builder()
                .checkin(checkinDate)
                .checkout(checkout)
                .build();
    }
}