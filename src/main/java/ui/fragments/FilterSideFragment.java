package ui.fragments;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;
import ui.helpers.ActionHelper;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static ui.helpers.ActionHelper.setRequiredTextIntoXpath;

public class FilterSideFragment {
    SelenideElement filterBarBody = $(byCssSelector(".side-filter__body.ng-star-inserted"));
    SelenideElement closeCrossPopUpButton = $(byCssSelector("span.exponea-close-cross"));
    String sidebarBrand = "//ul[@class='checkbox-filter']//a[contains(@data-id, '%s')]";

    @SneakyThrows
    public FilterSideFragment selectBrandFromSideBar(String brandName) {
        ActionHelper.isElementDisplayed(filterBarBody);
        ActionHelper.clickOnButton(closeCrossPopUpButton);
        SelenideElement element = setRequiredTextIntoXpath(sidebarBrand, brandName);
        element.shouldBe(Condition.enabled).click();
        ActionHelper.isElementSelected(setRequiredTextIntoXpath(sidebarBrand, brandName));
        return this;
    }
}