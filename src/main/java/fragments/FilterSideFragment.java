package fragments;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static helpers.ActionHelper.*;

public class FilterSideFragment {
    SelenideElement filterBarBody = $(byCssSelector(".side-filter__body.ng-star-inserted"));
    String sidebarBrand = "//ul[@class='checkbox-filter']//a[contains(@data-id, '%s')]";

    public FilterSideFragment selectBrandFromSideBar(String brandName) {
        isElementDisplayed(filterBarBody);
        setRequiredTextIntoXpath(sidebarBrand, brandName).click();
        isElementSelected(setRequiredTextIntoXpath(sidebarBrand, brandName));
        return new FilterSideFragment();
    }
}