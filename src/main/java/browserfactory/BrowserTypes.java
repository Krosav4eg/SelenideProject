package browserfactory;


public enum BrowserTypes {
    CHROME("chrome"),
    FIREFOX("firefox");

    private final String browser;

    BrowserTypes(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }
}