package autotests.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeTest;

@Log4j2
public class BaseTest {

    @BeforeTest(alwaysRun = true)
    public void setFilter() {
        RestAssured.filters(new AllureRestAssured());
    }
}