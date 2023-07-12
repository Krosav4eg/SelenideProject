package api.service;

import java.nio.file.Paths;


/**
 * BookingJsonModificationService class necessary for modifying requests of any json file.
 * For example generation random information/creation/edition/deletion of certain fields.
 */
public class BookingJsonModificationService extends BaseJsonModificationService {

    /**
     * A method for generation random value for "$.totalprice" field
     *
     * @param jsonFile – Path to required json file. It should be in format "file_name.json"
     * @return Json file sting with random value for $.totalprice field
     */
    public static synchronized String generatePriceForJson(String jsonFile) {
        String jsonObj = "$.totalprice";
        int value = BookingJsonModificationService.getRandomNum();
        return BookingJsonModificationService.modifyJsonFileValue(getJsonInStringFormat(jsonFile), jsonObj, value);
    }

    /**
     * A method for parsing JSON file.
     *
     * @return new JSON in string format.
     */
    private static synchronized String getJsonInStringFormat(String jsonFile) {
        return Paths.get(System.getProperty("user.dir"),
                "src", "test", "resources", "json", jsonFile).normalize().toString();
    }
}