package autotests.ui;

import ui.browserfactory.BrowserFactory;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Step;
import ui.listeners.AllureListener;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import ui.pages.MainPage;
import ui.pages.NoteBooksPage;
import utils.PropsConfig;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@Log4j2
@Listeners({AllureListener.class})
public class BaseTest {
    public static final PropsConfig PROPS = ConfigFactory.create(PropsConfig.class);
    MainPage mainPage = new MainPage();
    NoteBooksPage noteBooksPage = new NoteBooksPage();

    @BeforeSuite
    @Step("Set all detailed information about Environment")
    void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Firefox")
                        .put("Browser.Version", "121.0.1, (64 bit)")
                        .put("OS", "Windows 10")
                        .put("URL_UI", "https://rozetka.com.ua/")
                        .put("URL_API", "https://restful-booker.herokuapp.com/")
                        .build());
    }

    @BeforeMethod(alwaysRun = true)
    public void mainSteps() {
        WebDriverRunner.setWebDriver(BrowserFactory.getInstance().createDriverInstance(PROPS.BASE_BROWSER()));
        Configuration.timeout = Integer.parseInt(PROPS.WAITING_TIMEOUT());
        Configuration.baseUrl = PROPS.BASE_URL();
        open(Configuration.baseUrl);
        log.info("****** Browser has been started ******");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        closeWebDriver();
    }
}