package ui.driver;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;

import static ui.browserfactory.BrowserFactory.getDriver;

/**
 * This class is the container for single thread-safe instance of WebDriver.
 */
public class WebdriverUtils {

    @Step("Open base URL {url}")
    public static void openUrl(String url) {
        getDriver().navigate().to(url);
    }

    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public static void navigatePreviousPage() {
        getDriver().navigate().back();
    }

    public static void navigateNextPage() {
        getDriver().navigate().forward();
    }

    public static void navigateRefreshPage() {
        getDriver().navigate().refresh();
    }

    public static Alert switchToAlert() {
        return getDriver().switchTo().alert();
    }

    public static void acceptAlert() {
        switchToAlert().accept();
    }
}
