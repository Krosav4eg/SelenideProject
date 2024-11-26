package ui.browserfactory;

import org.openqa.selenium.WebDriver;


import java.util.Map;

public class BrowserFactoryProvider {

    //Этот путь необходимо прописывать в случае использования FireFox для удалённого запуска
    public static final String DRIVER_NAME_FIREFOX = "webdriver.gecko.driver";
    public static final String FIREFOX_DRIVER_PATH = "/usr/local/bin/geckodriver";

    private static volatile BrowserFactoryProvider instance;

    public static BrowserFactoryProvider getInstance() {
        if (instance == null) {
            synchronized (BrowserFactoryProvider.class) {
                if (instance == null) {
                    instance = new BrowserFactoryProvider();
                }
            }
        }
        return instance;
    }

    private BrowserFactoryProvider() {
    }

    // Регистрация фабрик
    private static final Map<String, BrowserFactory> factories = Map.of("CHROME", new ChromeBrowserFactory(),
            "FIREFOX", new FoxBrowserFactory());

    // Создание драйвера через фабрику
    public WebDriver createDriverInstance(String browserName) {
        if (browserName == null || !factories.containsKey(browserName.toUpperCase())) {
            throw new IllegalArgumentException("Unsupported or null browser name: " + browserName);
        }
        return factories.get(browserName.toUpperCase()).createDriver();
    }
}