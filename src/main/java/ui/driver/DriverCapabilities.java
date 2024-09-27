package ui.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverCapabilities {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }

    public static FirefoxOptions getFireFoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.merge(getChromeOptions());
        return options;
    }
}