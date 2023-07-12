package api.pojo.bookingpojo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

/**
 * Class describes JSON data structure.
 * This class doesn't contains any additional logic.
 */

@Data
@Builder
public class BookingDatesPojo {

    @SerializedName("checkin")
    private String checkin;

    @SerializedName("checkout")
    private String checkout;
}