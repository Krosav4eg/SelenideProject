package api.service;

import java.nio.file.Paths;


/**
 * ListingService class necessary for modifying requests of Listings json file.
 * For example generation random information/creation/edition/deletion of certain fields.
 */
public class BookingService extends BaseService {

	/**
	 * A method for generation random value for "$.list_desc" field
	 *
	 * @param jsonFile – Path to required json file. It should be in format "file_name.json"
	 *
	 * @return Json file sting with random value for $.list_desc field
	 */
	public static synchronized String generatePriceForJson(String jsonFile) {
		String jsonObj = "$.totalprice";
		int value = BookingService.getRandomNum();
		return BookingService.modifyJsonFileValue(createListingJsonPath(jsonFile), jsonObj, value);
	}

	/**
	 * A method for creation listing.
	 *
	 * @return new listing in string format.
	 */
	private static synchronized String createListingJsonPath(String jsonFile) {
		return Paths.get(System.getProperty("user.dir"),
						 "src", "test", "resources", "json", jsonFile).normalize().toString();
	}
}