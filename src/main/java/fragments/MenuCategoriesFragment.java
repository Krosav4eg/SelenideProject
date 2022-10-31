package fragments;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.ActionHelper.clickOnButton;

public class MenuCategoriesFragment {
    ElementsCollection noteBooksCategories = $$(byXpath("//a[contains(text(),'Ноутбуки')]"));

    @Step("Click on notebooks categories")
    public MenuCategoriesFragment clickOnNoteBooksCategories() {
        clickOnButton(noteBooksCategories.get(2));
        return new MenuCategoriesFragment();
    }
}