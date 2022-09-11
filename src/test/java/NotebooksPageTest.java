import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

import static data.CommonData.NOTE_BOOK_PAGE_TITLE;
import static data.CommonData.SEARCH_WORLD;
import static helpers.ActionHelper.getPageTitle;


@Feature("Notebooks Test")
public class NotebooksPageTest extends BaseTest {

    @Severity(SeverityLevel.MINOR)
    @TmsLink("1")
    @Description("Verify title of application")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkRedirectionToNotebooksPage() {
        mainPage.clickOnCatalogMenu();
        mainPage.getMenuCategoriesFragment().clickOnNoteBooksCategories();
        Assert.assertEquals(getPageTitle(), NOTE_BOOK_PAGE_TITLE.getData(),
                "Current notebooks page url isn't equal expected: ");

    }

    @Severity(SeverityLevel.MINOR)
    @TmsLink("2")
    @Description("Verify goods title")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkNotebooksGoodsTitles() {
        mainPage.clickOnCatalogMenu();
        mainPage.getMenuCategoriesFragment().clickOnNoteBooksCategories();
        Assert.assertTrue(noteBooksPage.checkThatGoodsTileContainsSearchWord(SEARCH_WORLD.getData()),
                "Current notebooks goods title isn't equal expected:");
    }

    @Severity(SeverityLevel.MINOR)
    @TmsLink("3")
    @Description("Verify goods size")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkGoodsItemsSize() {
        int expectedSize = 60;
        mainPage.clickOnCatalogMenu();
        mainPage.getMenuCategoriesFragment().clickOnNoteBooksCategories();
        noteBooksPage.checkThatGoodsItemsHaveSize(expectedSize);
    }
}