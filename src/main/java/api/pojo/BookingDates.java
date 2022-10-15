package api.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingDates {

	@SerializedName("checkin")
	private String checkin;

	@SerializedName("checkout")
	private String checkout;

	public String getCheckin(){
		return checkin;
	}

	public String getCheckout(){
		return checkout;
	}
}