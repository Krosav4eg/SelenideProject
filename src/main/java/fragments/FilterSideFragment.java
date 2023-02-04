package fragments;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static helpers.ActionHelper.*;

public class FilterSideFragment {
    SelenideElement filterBarBody = $(byCssSelector(".side-filter__body.ng-star-inserted"));
    String sidebarBrand = "//ul[@class='checkbox-filter']//a[contains(@data-id, '%s')]";
    SelenideElement minPriceInput = $(byCssSelector("input[formcontrolname='min']"));
    SelenideElement maxPriceInput = $(byCssSelector("input[formcontrolname='max']"));

    public FilterSideFragment selectBrandFromSideBar(String brandName) {
        isElementDisplayed(filterBarBody);
        setRequiredTextIntoXpath(sidebarBrand, brandName).click();
        isElementSelected(setRequiredTextIntoXpath(sidebarBrand, brandName));
        return new FilterSideFragment();
    }

    public FilterSideFragment fillInMinAndMaxPrice(String minPrice, String maxPrice) {
        isElementDisplayed(filterBarBody);
        scrollIntoElement(minPriceInput);
        setTextInField(minPriceInput,minPrice);
        setTextInField(maxPriceInput,maxPrice);
        maxPriceInput.sendKeys((Keys.ENTER));
        return new FilterSideFragment();
    }
}