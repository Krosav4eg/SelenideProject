package api.pojo.bookingpojo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingDatesPojo {

    @SerializedName("checkin")
    private String checkin;

    @SerializedName("checkout")
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }
}