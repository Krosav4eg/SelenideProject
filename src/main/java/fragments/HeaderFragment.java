package fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static driver.WebElementInteractions.clickOnElement;

@FindBy(css = ".header")
public class HeaderFragment extends BaseFragment{

    @FindBy(css="#fat-menu")
    WebElement catalogMenuButton;

    @FindBy(css="use[href='#icon-menu']")
    WebElement mainFilterMenuButton;

    @FindBy(css="input[name='search']")
    WebElement inputSearchForm;

    @FindBy(css="button.button_color_green")
    WebElement findButton;

    @FindBy(css="use[href='#icon-header-basket']")
    WebElement shoppingCardButton;

    public HeaderFragment(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnCatalogMenuButton(){
        clickOnElement(catalogMenuButton);
    }
}
