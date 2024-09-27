package autotests.ui;

import org.testng.annotations.*;
import ui.browserfactory.BrowserFactory;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Step;
import ui.listeners.AllureListener;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;
import ui.pages.NoteBooksPage;
import utils.PropsConfig;

import static com.codeborne.selenide.Selenide.open;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static ui.browserfactory.BrowserFactory.getDriver;

@Log4j2
@Listeners({AllureListener.class})
public class BaseTest {
    public static final PropsConfig PROPS = ConfigFactory.create(PropsConfig.class);
    public static final String ROZETKA_BASE_URL = "https://rozetka.com.ua/";
    public static final String URL_API = "https://restful-booker.herokuapp.com/";
    NoteBooksPage noteBooksPage = new NoteBooksPage();

    @BeforeSuite
    @Step("Set all detailed information about Environment")
    void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Firefox")
                        .put("Browser.Version", "121.0.1, (64 bit)")
                        .put("OS", "Windows 10")
                        .put("URL_UI", ROZETKA_BASE_URL)
                        .put("URL_API", URL_API)
                        .build());
    }

    @BeforeClass(alwaysRun = true)
    public void mainSteps() {
        WebDriverRunner.setWebDriver(BrowserFactory.getInstance().createDriverInstance(PROPS.BASE_BROWSER()));
        Configuration.timeout = Integer.parseInt(PROPS.WAITING_TIMEOUT());
        Configuration.baseUrl = PROPS.BASE_URL();
        open(Configuration.baseUrl);
        noteBooksPage.getExponeaBannerFragment().clickExponeaBannerCloseButton();
        log.info("****** Browser has been started ******");
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        if (getDriver() != null) {
            getDriver().close();
        }
    }
}