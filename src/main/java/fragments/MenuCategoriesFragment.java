package fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.ActionHelper.clickOnButton;

public class MenuCategoriesFragment  {
    SelenideElement allMenuCategories = $(byCssSelector("ul.menu-categories.ng-star-inserted"));
    ElementsCollection noteBooksCategories = $$(byXpath("//a[contains(text(),'Ноутбуки')]"));


    @Step("Click on notebooks categories")
    public void clickOnNoteBooksCategories(){
        clickOnButton(noteBooksCategories.get(2));
    }
}