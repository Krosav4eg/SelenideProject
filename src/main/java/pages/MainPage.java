package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Click on catalog menu")
    public void clickOnCatalogMenu() {
        getHeaderFragment().clickOnCatalogMenuButton();
    }
}