package ui.browserfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.driver.DriverCapabilities;

import static ui.browserfactory.DriverManager.getDriver;
import static ui.browserfactory.DriverManager.setDriver;

public class ChromeBrowserFactory implements BrowserFactory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(DriverCapabilities.getChromeOptions());
        setDriver(driver);
        return getDriver();
    }
}