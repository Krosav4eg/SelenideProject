package autotests.ui;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

import static data.CommonData.NOTE_BOOK_BRAND;
import static data.CommonData.SEARCH_WORLD;


@Feature("Notebooks Test")
public class NotebooksPageTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("1")
    @Description("Verify name of selected product form filter bar")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkNameOfSelectedProductFormFilterBar() {
        mainPage.getFilterSideFragment().selectBrandFromSideBar(NOTE_BOOK_BRAND.getData());
        Assert.assertTrue(noteBooksPage.checkThatGoodsTileContainsSearchWord("ASUS"),
                "Current notebooks brand title isn't equal expected:");
    }

    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("2")
    @Description("Verify that product price matches {minPrice} and {maxPrice} range")
    @Test()
    public void checkProductPriceRangeSelectedFormFilterBar() {
        String minPrice = "30000";
        String maxPrice = "35000";
        mainPage.getFilterSideFragment().fillInMinAndMaxPrice(minPrice, maxPrice);
        Assert.assertTrue(noteBooksPage.checkThatGoodsItemsPriceRangeIsCorrect(Integer.parseInt(minPrice),
                Integer.parseInt(maxPrice)), "Current notebooks price isn't in expected range");

    }

    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("3")
    @Description("Verify goods title")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkNotebooksGoodsTitles() {
        Assert.assertTrue(noteBooksPage.checkThatGoodsTileContainsSearchWord(SEARCH_WORLD.getData()),
                "Current notebooks goods title isn't equal expected:");
    }

    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("4")
    @Description("Verify goods size")
    @Test()
    public void checkGoodsItemsSize() {
        int expectedSize = 60;
        noteBooksPage.checkThatGoodsItemsHaveSize(expectedSize);
    }
}