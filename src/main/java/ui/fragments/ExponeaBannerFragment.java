package ui.fragments;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import ui.helpers.ActionHelper;


import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ExponeaBannerFragment {

    SelenideElement exponeaBannerBody = $(byCssSelector("#onetrust-group-container"));

    SelenideElement exponeaBannerCloseButton = $(byCssSelector("span.exponea-close-cross"));
    SelenideElement acceptCookiesButton = $(byCssSelector("#onetrust-accept-btn-handler"));

    @Step("Click on accept button in banner")
    public void clickExponeaBannerCloseButton() {
        ActionHelper.clickOnButton(acceptCookiesButton);
        ActionHelper.isElementDisplayed(exponeaBannerBody);
        ActionHelper.clickOnButton(exponeaBannerCloseButton);
    }
}