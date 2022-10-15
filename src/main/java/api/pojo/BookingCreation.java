package api.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingCreation {

	@SerializedName("firstname")
	private String firstname;

	@SerializedName("lastname")
	private String lastname;

	@SerializedName("total_price")
	private int totalprice;

	@SerializedName("depositpaid")
	private boolean depositpaid;

	@SerializedName("bookingdates")
	private BookingDates bookingdates;

	@SerializedName("additionalneeds")
	private String additionalneeds;
}