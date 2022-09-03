package fragments;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static driver.WebDriverWaits.waitForElementCollectionIsVisible;

@Getter
@FindBy(css = "div.goods-tile__inner")
public class GoodItemFragment extends BaseFragment {

    @FindBy(css = "span.goods-tile__title")
    List<WebElement> godsTitle;

    public GoodItemFragment(WebDriver webDriver) {
        super(webDriver);
    }

    public void witForAllGoodsItemsArePresent() {
        waitForElementCollectionIsVisible(godsTitle);
    }

}
