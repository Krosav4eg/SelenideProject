package autotests.ui;

import browserfactory.BrowserFactory;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import listeners.AllureListener;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.MainPage;
import pages.NoteBooksPage;
import utils.PropsConfig;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
@Listeners({AllureListener.class})
public class BaseTest extends BaseTestUtils{

    public static final PropsConfig PROPS = ConfigFactory.create(PropsConfig.class);
    MainPage mainPage = new MainPage();
    NoteBooksPage noteBooksPage = new NoteBooksPage();

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

    @AfterSuite(alwaysRun = true)
    public void setAllureEnvironment() {
        setEnvironmentValuesForAllure();
    }
}