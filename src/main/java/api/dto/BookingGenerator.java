package api.dto;

import api.pojo.bookingpojo.BookingCreationPojo;
import api.pojo.bookingpojo.BookingDatesPojo;

public class BookingGenerator {

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
                .checkin("2022-11-01")
                .checkout("2022-11-12")
                .build();
    }
}
