package api.pojo.request;

import lombok.Builder;
import lombok.Data;

/**
 * Class describes only JSON data structure.
 * This class doesn't contain any additional logic.
 */

@Data
@Builder
public class BookingCreationPojo {

    private String firstname;

    private String lastname;

    private int totalprice;

    private boolean depositpaid;

    private BookingDatesPojo bookingdates;

    private String additionalneeds;
}