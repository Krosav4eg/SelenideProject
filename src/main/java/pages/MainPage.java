package pages;

import io.qameta.allure.Step;

public class MainPage extends AbstractPage {

    @Step("Click on catalog menu")
    public void clickOnCatalogMenu() {
        getHeaderFragment().clickOnCatalogMenuButton();
    }
}