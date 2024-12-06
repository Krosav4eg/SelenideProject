package autotests.ui;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ui.data.CommonData.SEARCH_WORLD;


@Feature("Notebooks Test")
public class NotebooksPageTest extends BaseTest {

    @Test(groups = {"regression", "smoke"})
    @TmsLink("2")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify goods title")
    public void checkNotebooksGoodsTitles() {
        Assert.assertTrue(noteBooksPage.checkThatGoodsTileContainsSearchWord(SEARCH_WORLD.getData()),
                String.format("Expected goods don't contain the title : -> '%s'", SEARCH_WORLD.getData()));
    }

    @Test(groups = {"regression", "smoke"})
    @TmsLink("3")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify goods size")
    public void checkGoodsItemsSize() {
        int expectedSize = 60;
        Assert.assertEquals(noteBooksPage.checkThatGoodsItemsHaveSize(), expectedSize,
                "Actual and expected size don't match: ");
    }
}