package driver;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.PropsConfig;


import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static browserfactory.BrowserFactory.getDriver;

public class WebDriverWaits {
    public static final PropsConfig PROPS = ConfigFactory.create(PropsConfig.class);
    private static final int WAITING_TIME = Integer.parseInt(PROPS.WAITING_TIMEOUT());
    private static final WebDriverWait WAIT = new WebDriverWait(getDriver(), WAITING_TIME);

    public static void waitForPageLoad() {
        WAIT.until((ExpectedCondition<Boolean>) driver1 -> ((JavascriptExecutor) Objects.requireNonNull(driver1))
                .executeScript("return document.readyState").equals("complete"));
    }


    /**
     * Method verifying that web element is clickable.
     *
     * @param element used to find the element
     */
    public static WebElement waitForElementClickable(WebElement element) {
        Wait<WebDriver> newWait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(WAITING_TIME))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class )
                .ignoring(StaleElementReferenceException.class);
        return newWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitElementIsClickable(WebElement webElement) {
        return WAIT.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static WebElement waitElementIsVisible(WebElement webElement) {
        return WAIT.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static List <WebElement> waitForElementCollectionIsVisible(List<WebElement> webElements) {
        return WAIT.until(ExpectedConditions.visibilityOfAllElements(webElements));
    }
}