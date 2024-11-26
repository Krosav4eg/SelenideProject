package ui.browserfactory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BrowserTypes {

    CHROME("chrome"),
    FIREFOX("firefox");

    private final String browser;
}