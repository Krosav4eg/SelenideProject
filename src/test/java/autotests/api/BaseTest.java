package autotests.api;

import api.helper.ConsoleLoggingFilter;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import ui.listeners.AllureListener;
import utils.PropsConfig;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Log4j2
@Listeners({AllureListener.class})
public class BaseTest {

    protected static final String PATH_TO_CREATION_BOOKING_RESPONSE_SCHEMA = "json/schemas/CreateBookingSchema.json";
    protected static final String PATH_TO_GENERAL_BOOKING_INFO_SCHEMA = "json/schemas/BookingInfoSchema.json";
    public static final ThreadLocal<String> currentTestName = new ThreadLocal<>();
    public static final PropsConfig PROPS = ConfigFactory.create(PropsConfig.class);


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

    @BeforeMethod
    public void beforeMethod(Method method) {
        currentTestName.set(method.getName());
        log.info("======////=== STARTING TEST: {} ===////======", method.getName());
        RestAssured.filters(new AllureRestAssured(),
                new ConsoleLoggingFilter());
    }

    @AfterMethod
    public void cleanup() {
        RestAssured.reset();
        currentTestName.remove();
    }
}