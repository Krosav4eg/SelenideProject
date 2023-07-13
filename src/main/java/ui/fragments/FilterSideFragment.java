package ui.fragments;

import com.codeborne.selenide.SelenideElement;
import ui.helpers.ActionHelper;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class FilterSideFragment {
    SelenideElement filterBarBody = $(byCssSelector(".side-filter__body.ng-star-inserted"));
    String sidebarBrand = "//ul[@class='checkbox-filter']//a[contains(@data-id, '%s')]";

    public FilterSideFragment selectBrandFromSideBar(String brandName) {
        ActionHelper.isElementDisplayed(filterBarBody);
        ActionHelper.setRequiredTextIntoXpath(sidebarBrand, brandName).click();
        ActionHelper.isElementSelected(ActionHelper.setRequiredTextIntoXpath(sidebarBrand, brandName));
        return new FilterSideFragment();
    }
}