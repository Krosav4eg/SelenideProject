package autotests.ui;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ui.data.CommonData.SEARCH_WORLD;


@Feature("Notebooks Test")
public class NotebooksPageTest extends BaseTest {

    @Test()
    @TmsLink("2")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify goods title")
    public void checkNotebooksGoodsTitles() {
        Assert.assertTrue(noteBooksPage.checkThatGoodsTileContainsSearchWord(SEARCH_WORLD.getData()),
                "Current notebooks goods title isn't equal expected:");
    }

    @Test()
    @TmsLink("3")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify goods size")
    public void checkGoodsItemsSize() {
        int expectedSize = 60;
        noteBooksPage.checkThatGoodsItemsHaveSize(expectedSize);
    }
}