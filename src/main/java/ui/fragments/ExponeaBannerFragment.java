package ui.fragments;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import ui.helpers.ActionHelper;


import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class ExponeaBannerFragment {

    SelenideElement exponeaBannerBody = $(byXpath("//div[@class='exponea-banner exponea-survey exponea-animate']"));
    @Getter
    SelenideElement exponeaBannerCloseButton = $(byCssSelector("span.exponea-close-cross"));
    SelenideElement acceptCookiesButton = $(byCssSelector("#onetrust-accept-btn-handler"));

    @Step("Click on close button in exponea banner")
    public void clickExponeaBannerCloseButton() {
        ActionHelper.clickOnButton(acceptCookiesButton);
        ActionHelper.isElementDisplayed(exponeaBannerBody);
        ActionHelper.clickOnButton(exponeaBannerCloseButton);
    }
}