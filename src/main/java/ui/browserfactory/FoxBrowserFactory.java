package ui.browserfactory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ui.driver.DriverCapabilities;

import static ui.browserfactory.DriverManager.setDriver;

public class FoxBrowserFactory implements BrowserFactory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(DriverCapabilities.getFireFoxOptions());
        setDriver(driver);
        return driver;
    }
}