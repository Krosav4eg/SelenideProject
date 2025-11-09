package autotests.ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ui.browserfactory.BrowserFactoryProvider;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import ui.listeners.AllureListener;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;
import ui.pages.NoteBooksPage;
import utils.PropsConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static com.codeborne.selenide.Selenide.open;
import static ui.browserfactory.DriverManager.quitDriver;

@Log4j2
@Listeners({AllureListener.class})
public class BaseTest {
    public static final PropsConfig PROPS = ConfigFactory.create(PropsConfig.class);
    NoteBooksPage noteBooksPage = new NoteBooksPage();

    @BeforeSuite
    @Step("Set all detailed information about Environment")
    public void setAllureEnvironment() {
        String env = "Browse.Name=" + PROPS.BASE_BROWSER() + "\n" +
                "Browser.Version=142.0.7444.60  (64 bit)\n" +
                "OS=Windows 11\n" +
                "BASE_UI_URL=" + PROPS.BASE_URL() + "\n" +
                "BASE_API_URL=" + PROPS.BASE_API_URL() + "\n";
        try {
            Path path = Paths.get("target/allure-results/environment.properties");
            Files.createDirectories(path.getParent());
            Files.writeString(path, env, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Allure environment.properties created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
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