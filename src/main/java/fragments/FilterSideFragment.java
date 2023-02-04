package fragments;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static helpers.ActionHelper.*;

public class FilterSideFragment {
    SelenideElement filterBarBody = $(byCssSelector(".side-filter__body.ng-star-inserted"));
    String sidebarBrand = "//ul[@class='checkbox-filter']//a[contains(@data-id, '%s')]";
    SelenideElement minPriceInput = $(byCssSelector("input[formcontrolname='min']"));
    SelenideElement maxPriceInput = $(byCssSelector("input[formcontrolname='max']"));
    SelenideElement okButton = $(byXpath("//button[contains(text(),' Ok ')]"));

    public FilterSideFragment selectBrandFromSideBar(String brandName) {
        isElementDisplayed(filterBarBody);
        setRequiredTextIntoXpath(sidebarBrand, brandName).click();
        isElementSelected(setRequiredTextIntoXpath(sidebarBrand, brandName));
        return new FilterSideFragment();
    }

    public FilterSideFragment fillInMinAndMaxPrice(String minPrice, String maxPrice) {
        setTextInField(minPriceInput,minPrice);
        setTextInField(maxPriceInput,maxPrice);
        clickOnButton(okButton);
        return new FilterSideFragment();
    }
}