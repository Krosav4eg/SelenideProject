package driver;

import org.openqa.selenium.chrome.ChromeOptions;


public class DriverCapabilities {

    public static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        return options;
    }
}