package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static driver.WebElementInteractions.getWebElementText;

public class NoteBooksPage extends AbstractPage {

    public static final String NOTE_BOOKS_PAGE_URL = PROPS.BASE_URL();

    public NoteBooksPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Check that goods tiles contains search word {searchWord}")
    public boolean checkThatGoodsTileContainsSearchWord(String searchWord) {
        getGoodItemFragment().witForAllGoodsItemsArePresent();
        return getWebElementText(getGoodItemFragment().getGodsTitle()).stream().allMatch(e->e.contains(searchWord));
    }
}