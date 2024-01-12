package ui.fragments;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ui.helpers.ActionHelper;


import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class ExponeaBannerFragment {

    SelenideElement exponeaBannerBody = $(new By.ByXPath("//div[@class='exponea-banner exponea-survey exponea-animate']"));
    SelenideElement exponeaBannerCloseButton = $(new By.ByXPath("//span[@class='exponea-close']"));

    @Step("Click on close button in exponea banner")
    public ExponeaBannerFragment clickOnNoteBooksCategories() {
        ActionHelper.isElementDisplayed(exponeaBannerBody);
        ActionHelper.clickOnButton(exponeaBannerCloseButton);
        return new ExponeaBannerFragment();
    }
}
