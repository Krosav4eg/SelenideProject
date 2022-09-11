import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

import static helpers.ActionHelper.getPageTitle;


@Feature("Notebooks Test")
public class NotebooksPageTest extends BaseTest {

    @Severity(SeverityLevel.MINOR)
    @TmsLink("1")
    @Description("Verify title of application")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkRedirectionToNotebooksPage() {
        String expectedPageTitle = "Ноутбуки - ROZETKA | Купити ноутбук в Києві: ціна, відгуки, продаж, вибір ноутбуків в Україні";
        mainPage.clickOnCatalogMenu();
        mainPage.getMenuCategoriesFragment().clickOnNoteBooksCategories();
        Assert.assertEquals(getPageTitle(), expectedPageTitle,
                "Current notebooks page url isn't equal expected: ");

    }

    @Severity(SeverityLevel.MINOR)
    @TmsLink("2")
    @Description("Verify goods title")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkNotebooksGoodsTitles() {
        String searchWord = "Ноутбук";
        mainPage.clickOnCatalogMenu();
        mainPage.getMenuCategoriesFragment().clickOnNoteBooksCategories();
        Assert.assertTrue(noteBooksPage.checkThatGoodsTileContainsSearchWord(searchWord),
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