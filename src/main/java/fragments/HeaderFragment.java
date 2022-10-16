package fragments;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

import static helpers.ActionHelper.clickOnButton;

public class HeaderFragment {
    SelenideElement catalogMenuButton = $(byCssSelector("#fat-menu"));
    SelenideElement mainFilterMenuButton = $(byCssSelector("use[href='#icon-menu']"));
    SelenideElement inputSearchForm = $(byCssSelector("input[name='search']"));
    SelenideElement findButton = $(byCssSelector("button.button_color_green"));
    SelenideElement shoppingCardButton = $(byCssSelector("use[href='#icon-header-basket']"));

    public void clickOnCatalogMenuButton() {
        clickOnButton(catalogMenuButton);
    }
}
