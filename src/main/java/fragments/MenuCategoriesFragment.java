package fragments;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static helpers.ActionHelper.clickOnButton;

public class MenuCategoriesFragment  {
    SelenideElement allMenuCategories = $(byCssSelector("ul.menu-categories.ng-star-inserted"));
    SelenideElement noteBooksCategories = $(byXpath("(//a[contains(text(),'Ноутбуки')])[3]"));


    @Step("Click on notebooks categories")
    public void clickOnNoteBooksCategories(){
        clickOnButton(noteBooksCategories);
    }
}