package ui.fragments;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.helpers.ActionHelper;


import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class ExponeaBannerFragment {

    SelenideElement exponeaBannerBody = $(byXpath("//div[@class='exponea-banner exponea-survey exponea-animate']"));
    SelenideElement exponeaBannerCloseButton = $(byCssSelector("span.exponea-close-cross"));

    @Step("Click on close button in exponea banner")
    public ExponeaBannerFragment clickExponeaBannerCloseButton() {
        ActionHelper.isElementDisplayed(exponeaBannerBody);
        ActionHelper.clickOnButton(exponeaBannerCloseButton);
        return new ExponeaBannerFragment();
    }
}