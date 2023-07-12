package api.pojo.bookingpojo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

/**
 * Class describes only JSON data structure.
 * This class doesn't contains any additional logic.
 */

@Data
@Builder
public class BookingCreationPojo {

    private String firstname;

    private String lastname;

    @SerializedName("total_price")
    private int totalprice;

    private boolean depositpaid;

    private BookingDatesPojo bookingdates;

    private String additionalneeds;
}