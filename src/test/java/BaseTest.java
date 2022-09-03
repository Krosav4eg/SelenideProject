import browserfactory.BrowserFactory;
import com.google.common.collect.ImmutableMap;
import fragments.GoodItemFragment;
import fragments.HeaderFragment;
import fragments.MenuCategoriesFragment;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.MainPage;
import pages.NoteBooksPage;
import utils.PropsConfig;

import java.util.concurrent.TimeUnit;

import static browserfactory.BrowserFactory.getDriver;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static driver.WebDriverWaits.waitForPageLoad;
import static driver.WebdriverUtils.openUrl;

@Listeners({AllureListener.class})
public class BaseTest {
    public static final PropsConfig PROPS = ConfigFactory.create(PropsConfig.class);
    MainPage mainPage;
    NoteBooksPage noteBooksPage;
    HeaderFragment headerFragment;
    MenuCategoriesFragment menuCategoriesFragment;
    GoodItemFragment goodItemFragment;

    @BeforeSuite
    @Step("Set all detailed information about Environment")
    void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "104.0.5112.102 (Official Build) (64-bit)")
                        .put("OS", "Windows 10")
                        .put("URL", "https://rozetka.com.ua/")
                        .build());
    }


    @BeforeMethod(alwaysRun = true)
    public void mainSteps() {
        BrowserFactory.getInstance().createDriverInstance(PROPS.BASE_BROWSER());
        openUrl(PROPS.BASE_URL());
        initPageElements();
        waitForPageLoad();
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    private void initPageElements() {
        mainPage = PageFactory.initElements(getDriver(), MainPage.class);
        noteBooksPage = PageFactory.initElements(getDriver(), NoteBooksPage.class);
        headerFragment = PageFactory.initElements(getDriver(), HeaderFragment.class);
        menuCategoriesFragment = PageFactory.initElements(getDriver(), MenuCategoriesFragment.class);
        goodItemFragment = PageFactory.initElements(getDriver(), GoodItemFragment.class);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        BrowserFactory.closeBrowser();
    }
}