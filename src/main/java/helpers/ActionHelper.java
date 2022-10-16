package helpers;

import com.codeborne.selenide.*;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


/**
 * ActionsHelper class is intended for common actions on a webpage in tests.
 */
public class ActionHelper {

    public static void clickOnButton(SelenideElement element) {
        element.shouldBe(Condition.exist).shouldBe(Condition.visible).shouldBe(enabled).click();
    }

    public static boolean isElementDisplayed(SelenideElement element) {
        return element.is(Condition.visible);
    }

    public static boolean isElementNotDisplayed(SelenideElement element) {
        return !element.is(visible);
    }

    public static boolean isElementActive(SelenideElement element) {
        return element.shouldBe(Condition.exist).isEnabled();
    }

    public static boolean isElementInactive(SelenideElement element) {
        return !element.shouldBe(Condition.exist).isEnabled();
    }

    public static void setTextInField(SelenideElement element, String value) {
        element.shouldBe(Condition.exist).setValue(value);
    }

    public static void checkThatElementContainsText(SelenideElement element, String containsText) {
        element.shouldBe(visible).shouldHave(text(containsText));
    }

    public static void checkThatElementsContainTexts(ElementsCollection selenideElements, List<String> containsText) {
        selenideElements.shouldHave(texts(containsText));
    }

    public static ElementsCollection checkThatElementCollectionsHasSize(ElementsCollection selenideElements, int collectionSize) {
        return selenideElements.shouldHave(
                CollectionCondition.size(collectionSize));
    }

    public static ElementsCollection checkThatAllElementsAreVisible(ElementsCollection selenideElements) {
        return selenideElements.should(allMatch("All elements should be visible", WebElement::isDisplayed));
    }

    public static boolean checkThatAllElementsContainsText(ElementsCollection selenideElements, String searchWord) {
        return selenideElements.stream().map(WebElement::getText).allMatch(e -> e.contains(searchWord));
    }

    public static void selectOptionByText(ElementsCollection selenideElements, String text) {
        selenideElements.should(CollectionCondition.sizeGreaterThan(0));
        selenideElements.stream().filter(element -> element.getText().trim().equals(text.trim())).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to find element with text: " + text)).click();
    }

    public static SelenideElement scrollIntoElement(SelenideElement element) {
        return element.scrollIntoView(true);
    }


    public static String getElementText(SelenideElement element) {
        return element.getText();
    }

    public static String getElementValue(SelenideElement element) {
        return element.getValue();
    }

    public static String getPageTitle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return WebDriverRunner.getWebDriver().getTitle();
    }

    public static SelenideElement setRequiredTextIntoXpath(String element, String inputText) {
        return $(byXpath(String.format(element, inputText)));
    }
}