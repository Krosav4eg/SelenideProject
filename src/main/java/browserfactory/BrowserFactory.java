package browserfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static browserfactory.BrowserTypes.CHROME;
import static browserfactory.BrowserTypes.FIREFOX;
import static driver.DriverCapabilities.*;


public class BrowserFactory {

    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();
    public static final String DRIVER_NAME_FIREFOX = "webdriver.gecko.driver";
    public static final String FIREFOX_DRIVER_PATH = "/usr/local/bin/geckodriver";

    private static volatile BrowserFactory instance;

    public static BrowserFactory getInstance() {
        if (instance == null) {
            synchronized (BrowserFactory.class) {
                if (instance == null) {
                    instance = new BrowserFactory();
                }
            }
        }
        return instance;
    }

    private BrowserFactory() {
    }

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    public WebDriver createDriverInstance(String browserName) {
        if (browserName != null) {
            if (CHROME.getBrowser().equalsIgnoreCase(browserName)) {
                WebDriverManager.chromedriver().setup();
                driverThread.set(new ChromeDriver(getChromeOptions()));
            } else if (FIREFOX.getBrowser().equalsIgnoreCase(browserName)) {
                System.setProperty(DRIVER_NAME_FIREFOX, FIREFOX_DRIVER_PATH);
                driverThread.set(new FirefoxDriver(getFireFoxOptions()));
            }
        }
        return getDriver();
    }

    public static void closeBrowser() {
        if (getDriver() != null)
            getDriver().quit();
    }
}