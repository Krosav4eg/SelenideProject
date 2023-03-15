package driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverCapabilities {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        return options;
    }

    public static FirefoxOptions getFireFoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--width=1530");
        options.addArguments("--height=780");
        options.addArguments("--disable-notifications");
        options.addArguments("disable-infobars");
        return options;
    }
}