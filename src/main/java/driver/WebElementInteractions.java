package driver;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static driver.WebDriverWaits.*;

public class WebElementInteractions {

    public static void clickOnElement(WebElement webElement) {
        waitForElementClickable(webElement).click();
    }

    public static void clearAndPopulateField(WebElement element, String text) {
        waitElementIsVisible(element).clear();
        waitElementIsVisible(element).sendKeys(text);
    }

    public static List<String> getWebElementText(List<WebElement> webElements) {
        waitForElementCollectionIsVisible(webElements);
        return webElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}