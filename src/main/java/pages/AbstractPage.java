package pages;

import fragments.GoodItemFragment;
import fragments.HeaderFragment;
import fragments.MenuCategoriesFragment;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.PropsConfig;

import static browserfactory.BrowserFactory.getDriver;

@Getter
public class AbstractPage {
    public static final PropsConfig PROPS = ConfigFactory.create(PropsConfig.class);
    WebDriver webDriver;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected HeaderFragment headerFragment =
            PageFactory.initElements(getDriver(), HeaderFragment.class);

    protected MenuCategoriesFragment menuCategoriesFragment=
            PageFactory.initElements(getDriver(), MenuCategoriesFragment.class);

    protected GoodItemFragment goodItemFragment=
            PageFactory.initElements(getDriver(), GoodItemFragment.class);
}