package autotests.ui;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

import static ui.data.CommonData.NOTE_BOOK_BRAND;
import static ui.data.CommonData.SEARCH_WORLD;


@Feature("Notebooks Test")
public class NotebooksPageTest extends BaseTest {

    @Severity(SeverityLevel.MINOR)
    @TmsLink("1")
    @Description("Verify name of selected product form filter bar")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkNameOfSelectedProductFormFilterBar() {
        mainPage.getFilterSideFragment().selectBrandFromSideBar(NOTE_BOOK_BRAND.getData());
        Assert.assertTrue(noteBooksPage.checkThatGoodsTileContainsSearchWord("ASUS"),
                "Current notebooks brand title isn't equal expected:");

    }

    @Severity(SeverityLevel.MINOR)
    @TmsLink("2")
    @Description("Verify goods title")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkNotebooksGoodsTitles() {
        noteBooksPage.getExponeaBannerFragment().clickExponeaBannerCloseButton();
        Assert.assertTrue(noteBooksPage.checkThatGoodsTileContainsSearchWord(SEARCH_WORLD.getData()),
                "Current notebooks goods title isn't equal expected:");
    }

    @Severity(SeverityLevel.MINOR)
    @TmsLink("3")
    @Description("Verify goods size")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkGoodsItemsSize() {
        int expectedSize = 60;
        noteBooksPage.getExponeaBannerFragment().clickExponeaBannerCloseButton();
        noteBooksPage.checkThatGoodsItemsHaveSize(expectedSize);
    }
}