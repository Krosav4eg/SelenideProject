package ui.fragments;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import ui.helpers.ActionHelper;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class MenuCategoriesFragment {
    ElementsCollection noteBooksCategories = $$(byXpath("//a[contains(text(),'Ноутбуки')]"));

    @Step("Click on notebooks categories")
    public MenuCategoriesFragment clickOnNoteBooksCategories() {
        ActionHelper.clickOnButton(noteBooksCategories.get(2));
        return new MenuCategoriesFragment();
    }
}