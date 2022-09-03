package fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static driver.WebElementInteractions.clickOnElement;

public class MenuCategoriesFragment extends BaseFragment {

    @FindBy(css="ul.menu-categories.ng-star-inserted")
    WebElement allMenuCategories;

    @FindBy(xpath="(//a[contains(text(),'Ноутбуки')])[3]")
    WebElement noteBooksCategories;

    public MenuCategoriesFragment(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Click on notebooks categories")
    public void clickOnNoteBooksCategories(){
        clickOnElement(noteBooksCategories);
    }
}
