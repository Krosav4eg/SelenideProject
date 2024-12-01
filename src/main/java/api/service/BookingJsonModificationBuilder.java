package api.service;

import java.io.File;
import java.nio.file.Paths;

public class BookingJsonModificationBuilder extends BaseJsonBuilder<BookingJsonModificationBuilder>{

    public BookingJsonModificationBuilder(String jsonText) {
        super(jsonText);
    }

    public BookingJsonModificationBuilder(File file) {
        super(file);
    }

    /**
     * Creates a new BookingJsonBuilder initialized with contents of a file
     *
     * @param fileName name of a file
     *
     * @return a newly created BookingJsonModificationBuilder
     */
    public static BookingJsonModificationBuilder fromFile(String fileName) {
        File file = Paths.get(System.getProperty("user.dir"),
                "src", "test", "resources", "json", fileName).normalize().toFile();
        return new BookingJsonModificationBuilder(file);
    }

    /**
     * A method for generation a random price for "$.totalprice" field
     */
    public BookingJsonModificationBuilder generatePriceForJson() {
        int value = (int) (Math.random() * 10000);
        return modifyValue("$.totalprice", value);
    }
}