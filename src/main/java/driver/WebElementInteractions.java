package driver;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static browserfactory.BrowserFactory.getDriver;
import static com.google.common.collect.Lists.newArrayList;
import static driver.WebDriverWaits.*;

public class WebElementInteractions {
    private static final String A_KEY = "a";
    private static final String HREF_ATTRIBUTE = "href";
    private static final String CLASS_ATTRIBUTE = "class";
    private static final String VALUE = "value";
    private static final String BACKGROUND_COLOR = "background-color";
    private static final String SCROLL_TO_PAGE_BOTTOM = "window.scrollTo(0, document.body.scrollHeight)";
    private static final String SCROLL_TO_PAGE_CENTER = "window.scrollTo(%d,%d - Math.max(document.documentElement.clientHeight, window.innerHeight || 0)/2";
    private static final String SCROLL_DOWN = "window.scrollTo(0, -document.body.scrollHeight);";
    private static final String SCROLL_UP = "window.scrollTo(0, document.body.scrollHeight);";


    private WebElementInteractions() {
    }

    /**
     * COMMON
     */
    public static boolean isVisible(WebElement element) {
        return isPresent(element) && element.isDisplayed();
    }

    public static boolean isVisible(WebElement parentElement, By by) {
        try {
            WebElement child = parentElement.findElement(by);
            return isVisible(parentElement) && isVisible(child);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public static WebElement getElementByText(List<WebElement> webElementList, final String text) {
        return webElementList.stream().filter(element -> element.getText().trim().equals(text.trim())).findFirst()
                .orElseThrow(() -> new IllegalStateException("Unable to find element with text: " + text));
    }

    public static List<WebElement> getElementsByText(List<WebElement> webElementList, final String text) {
        return webElementList.stream().filter(element -> element.getText().equals(text.trim())).collect(Collectors.toList());
    }

    /**
     * ATTRIBUTE
     */
    public static boolean isElementHasAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName) != null;
    }

    public static String getElementClass(WebElement element) {
        return element.getAttribute(CLASS_ATTRIBUTE);
    }

    public static String getInputValue(WebElement element) {
        return element.getAttribute(VALUE);
    }

    public static String getAttributeValue(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public static List<String> getInputValues(List<WebElement> elements) {
        List<String> newList = new ArrayList<>();
        for (WebElement str : elements) {
            newList.add(getInputValue(str));
        }
        return newList;
    }

    public static String getElementAnyAttributeValue(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public static String getHrefAttribute(WebElement element) {
        return element.getAttribute(HREF_ATTRIBUTE);
    }

    public static String getElementHref(WebElement element) {
        try {
            return new URI(getHrefAttribute(element).trim()).getPath();
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String getElementColor(WebElement element) {
        return element.getCssValue(BACKGROUND_COLOR).toString();
    }

    /**
     * CHECKBOX
     */
    public static boolean isChecked(WebElement element) {
        return isVisible(element) && element.isSelected();
    }

    public static void check(WebElement checkbox) {
        if (!isChecked(checkbox))
            checkbox.click();
    }

    public static void uncheck(WebElement checkbox) {
        if (isChecked(checkbox))
            checkbox.click();
    }

    /**
     * TEXTFIELD
     */

    public static void clearAndPopulateField(WebElement element, String message) {
        elementVisibility(element).clear();
        elementVisibility(element).sendKeys(message);
    }

//    public static WebElement clearAndPopulateFieldAndPressEnter(WebElement field, String text) {
//        clearAndPopulateField(field, text).sendKeys(Keys.ENTER);
//        return field;
//    }

    public static void typeToFieldAndCopyValueToClipboard(WebElement field, String valueForCopyToClipboard) {
        field.sendKeys(valueForCopyToClipboard);
        field.sendKeys(Keys.chord(Keys.CONTROL, A_KEY));
        field.sendKeys(Keys.chord(Keys.CONTROL, Keys.INSERT));
    }

    public static void clearFieldAndPasteValueFromClipboard(WebElement field) {
        field.clear();
        field.sendKeys(Keys.chord(Keys.SHIFT, Keys.INSERT));
    }

    public static void pasteValueFromClipboard(WebElement field) {
        field.sendKeys(Keys.chord(Keys.SHIFT, Keys.INSERT));
    }

    public static void pressEscape(WebElement field) {
        field.sendKeys(Keys.ESCAPE);
    }

    /**
     * SELECT
     */

    protected static void clickOnIndexFromElementList(List<WebElement> element, int elementIndex) {
        List<String> stringElements = new ArrayList<>();
        try {
            for (int i = 0; i <= element.size(); i++) {
                element.get(elementIndex).click();
            }
        } catch (ElementNotVisibleException | ClassCastException | IndexOutOfBoundsException e) {
            e.getMessage();
        }
    }


    public static String getTextOfWebElementsList(List<WebElement> webElementList) {
        List<String> stringElements = new ArrayList<>();
        elementListVisibility(webElementList);
        webElementList.forEach(element -> stringElements.add(element.getText()));
        return stringElements.toString();
    }

    public static Select newSelect(WebElement selectElement) {
        return new Select(selectElement);
    }

    public static List<String> getSelectOptionText(WebElement element) {
        List<String> values = newArrayList();
        if (isVisible(element)) {
            List<WebElement> options = new Select(element).getOptions();
            values.addAll(options.stream().map(WebElement::getText).collect(Collectors.toList()));
        }
        return values;
    }

    public static String getSelectedOptionText(WebElement selectElement) {
        return new Select(selectElement).getFirstSelectedOption().getText();
    }

    public static List<String> getSelectOptionsText(WebElement selectElement) {
        return new Select(selectElement).getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public static void selectDropDownValueByText(WebElement dropdown, String text) {
        List<WebElement> options = new Select(dropdown).getOptions();
        for (WebElement el : options)
            if (text != null && text.equals(el.getText())) {
                el.click();
                return;
            }
    }

    public static void selectDropDownOptionByValue(WebElement dropdown, String value) {
        new Select(dropdown).getOptions().stream().filter(element -> element.getAttribute(VALUE).equals(value)).findFirst()
                .orElseThrow(() -> new IllegalStateException("Unable to find option with value: " + value)).click();
    }

    public static void selectDropDownValueByRowNumber(WebElement dropdown, int rowNumber) {
        new Select(dropdown).getOptions().get(rowNumber).click();
    }

    /**
     * ACTIONS
     */
    public static Actions newActions() {
        return new Actions(getDriver());
    }

    public static void scrollAndMouseOver(WebElement element) {
        scrollToWebElement(element);
        newActions().moveToElement(element).build().perform();
    }

    public static void mouseOverAndClick(WebElement element) {
        scrollToCenter(element);
        newActions().moveToElement(element).click().build().perform();
    }

    public static void mouseOverAndClick(WebElement element, int x, int y) {
        scrollToCenter(element);
        newActions().moveToElement(element, x, y).click().build().perform();
    }

    public static TouchActions newTouchActions() {
        return new TouchActions(getDriver());
    }

    /**
     * JS
     * for execute all browsers js scripts
     */

    public static Object executeScript(String script, Object... elements) {
        return ((JavascriptExecutor) getDriver()).executeScript(script, elements);
    }


    public static void scrollToWebElement(WebElement element) {
        int x = element.getLocation().x;
        int y = element.getLocation().y;
        scrollTo(x, y);
    }

    public static void scrollToCenter(WebElement element) {
        int x = element.getLocation().x;
        int y = element.getLocation().y;
        executeScript(String.format(SCROLL_TO_PAGE_CENTER, x, y), "");
    }

    public static void scrollUp() {
        executeScript(SCROLL_UP);
    }

    public static void scrollDown() {
        executeScript(SCROLL_DOWN);
    }

    public static void scrollTo(int x, int y) {
        executeScript(String.format("window.scrollTo(%d,%d)", x, y), "");
    }

    public static void scrollIntoView(WebElement element) {
        executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void setInputValue(WebElement element, String value) {
        String elementId = element.getAttribute("id");
        executeScript("document.getElementById(arguments[0]).value = arguments[1]", elementId, value);
    }

    public static void hoverElementByJS(WebElement element) {
        String script = "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, " + "null);"
                + "arguments[0].dispatchEvent(evObj);";
        executeScript(script, element);
    }

    public static void forceChangedForElement(WebElement element) {
        dispatchHtmlEvent(element, "change", "onchange");
    }

    public static void forceOnkeyupForElement(WebElement element) {
        dispatchHtmlEvent(element, "keyup", "keyup");
    }

    private static void dispatchHtmlEvent(WebElement element, String initEvent, String fireEvent) {
        String script = String.format(
                "var element = document.getElementById(arguments[0]);" + "if( document.createEvent ) { "
                        + "var eventObject = document.createEvent('HTMLEvents');" + "eventObject.initEvent( '%1$s', false, true );"
                        + "element.dispatchEvent(eventObject);" + "} else if( document.createEventObject ) {" + "element.fireEvent('%2$s');" + "};",
                initEvent, fireEvent);
        executeScript(script, element.getAttribute("id"));
    }

    public static void forceMouseDownEventElement(WebElement element) {
        String script = "var element = arguments[0]; " + "if( document.createEvent ) { " + "var eventObject = document.createEvent('MouseEvents');"
                + "eventObject.initEvent( 'mousedown', true, false );" + "element.dispatchEvent(eventObject);" + "} else if( document.createEventObject ) {"
                + "element.fireEvent('mousedown');" + "};";
        executeScript(script, element);
    }

    public static void clickByJavaScript(WebElement element) {
        executeScript("arguments[0].click();", element);
    }

    public static void submitByJavaScript(WebElement element, String value) {
        executeScript("$(arguments[0]).val(" + value + ");", element);
        executeScript("$(arguments[0]).trigger('change');", element);
    }

    public static String getTextByJavaScript(WebElement element) {
        return executeScript("return arguments[0].value", element).toString();
    }

    public static String getOnlyParentElementText(WebElement element) {
        return (String) executeScript("return arguments[0].childNodes[0].nodeValue.trim();", element);
    }

    public static void scrollToTheBottomOfThePage() {
        executeScript(SCROLL_TO_PAGE_BOTTOM);
    }

    public static String getRelativePath(String absolutePath) {
        try {
            return new URL(absolutePath).getPath();
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Absolute path was not formed properly" + e);
        }
    }

    public static String getElementAttribute(WebElement element, String attribute) {
        return (String) executeScript("return $(arguments[0]).attr(arguments[1]);", element, attribute);
    }

    public static boolean isFunctionDefined(String functionName) {
        return (boolean) executeScript(String.format("return typeof(%s) === 'function'", functionName));
    }

    public static void click(WebElement element) {
        scrollToCenter(element);
        element.click();
    }
}