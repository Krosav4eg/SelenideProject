package driver;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.PropsConfig;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static browserfactory.BrowserFactory.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WebDriverWaits {
    public static final PropsConfig PROPS = ConfigFactory.create(PropsConfig.class);
    private static final long DEFAULT_POLLING_MILLISECONDS = 500;
    private static final int WAITING_TIMEOUT = Integer.parseInt(PROPS.WAITING_TIMEOUT());
    private static final WebDriverWait WAIT = new WebDriverWait(getDriver(), WAITING_TIMEOUT);


    public static void waitForPageLoad() {
        WAIT.until((ExpectedCondition<Boolean>) driver1 -> ((JavascriptExecutor) Objects.requireNonNull(driver1))
                .executeScript("return document.readyState").equals("complete"));
    }


    /**
     * Method for waiting for Javascript and jQuery to finish loading.
     * Execute Javascript to check if jQuery.active is 0
     * and document.readyState is complete, which means the JS and jQuery load is complete.
     */
    public static boolean waitForJSandJQueryToLoad() {
        ExpectedCondition<Boolean> jQueryLoad = drivers -> {
            try {
                return ((Long) ((JavascriptExecutor) getDriver()).executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                return true;
            }
        };
        ExpectedCondition<Boolean> jsLoad = drivers -> ((JavascriptExecutor) getDriver()).executeScript("return document.readyState")
                .toString().equals("complete");
        return WAIT.until(jQueryLoad) && WAIT.until(jsLoad);
    }

    /**
     * Method verifying that web element is clickable.
     *
     * @param element used to find the element
     */
    public static WebElement waitForElementClickable(WebElement element) {
        Wait<WebDriver> newWait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(WAITING_TIMEOUT))
                .pollingEvery(Duration.ofMillis(DEFAULT_POLLING_MILLISECONDS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return newWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Method was created for helps to search for elements with certain intervals within a given period of time.
     * Web element searching every 500 MILLISECONDS for 30 seconds.
     *
     * @param element - used to find the element
     */
    public static WebElement waitForElementVisible(WebElement element) {
        WAIT.withTimeout(Duration.ofSeconds(WAITING_TIMEOUT))
                .pollingEvery(Duration.ofMillis(DEFAULT_POLLING_MILLISECONDS))
                .ignoring(NoSuchElementException.class);
        return WAIT.until(visibilityOf(element));
    }

    public static WebElement elementVisibility(WebElement element) {
        return WAIT.until(visibilityOf(element));

    }

    public static List<WebElement> elementListVisibility(List<WebElement> elements) {
        return WAIT.until(visibilityOfAllElements(elements));
    }

    public static void waitForInvisibilityOfElement(WebElement element) {
        WAIT.until(invisibilityOf(element));
    }

    public static void waitForInvisibilityOfElements(WebElement element) {
        WAIT.until(invisibilityOfAllElements(element));
    }

    public static void waitForTextIsPresent(WebElement element, String text) {
        WAIT.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static boolean waitForElementIsDisplayed(WebElement element) {
        return WAIT.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }


    public static boolean waitForElementIsEnabled(WebElement element) {
        return WAIT.until(ExpectedConditions.visibilityOf(element)).isEnabled();
    }

    public static boolean waitForElementIsSelected(WebElement element) {

        return WAIT.until(ExpectedConditions.visibilityOf(element)).isSelected();
    }
}