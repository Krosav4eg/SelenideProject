package autotests.ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ui.browserfactory.BrowserFactoryProvider;
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
import static ui.browserfactory.DriverManager.quitDriver;

@Log4j2
@Listeners({AllureListener.class})
public class BaseTest {
    public static final PropsConfig PROPS = ConfigFactory.create(PropsConfig.class);
    NoteBooksPage noteBooksPage = new NoteBooksPage();

    @BeforeSuite
    @Step("Set all detailed information about Environment")
    void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", PROPS.BASE_BROWSER())
                        .put("Browser.Version", "Версия 131.0.6778.86 (Официальная сборка), (64 бит)")
                        .put("OS", "Windows 11")
                        .put("URL_UI", PROPS.BASE_URL())
                        .put("URL_API", PROPS.BASE_API_URL())
                        .build());
    }

    @BeforeClass(alwaysRun = true)
    public void mainSteps() {
        WebDriver driver = BrowserFactoryProvider.getInstance().createDriverInstance(PROPS.BASE_BROWSER());
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();
        Configuration.timeout = Integer.parseInt(PROPS.WAITING_TIMEOUT());
        Configuration.baseUrl = PROPS.BASE_URL();
        open(Configuration.baseUrl);
        log.info("****** Browser has been started ******");
        if (noteBooksPage.getExponeaBannerFragment().getExponeaBannerBody().isDisplayed()) {
            noteBooksPage.getExponeaBannerFragment().clickExponeaBannerCloseButton();
        } else {
            log.info("banner close button hasn't displayed");
        }
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        quitDriver();
    }
}