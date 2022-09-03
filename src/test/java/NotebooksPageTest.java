import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

import static driver.WebdriverUtils.getCurrentUrl;

@Feature("Notebooks Test")
public class NotebooksPageTest extends BaseTest {


    @Severity(SeverityLevel.MINOR)
    @TmsLink("1")
    @Description("Verify title of application")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkRedirectionToNotebooksPage()  {
        mainPage.clickOnCatalogMenu();
        mainPage.getMenuCategoriesFragment().clickOnNoteBooksCategories();
        Assert.assertEquals(getCurrentUrl(),"https://rozetka.com.ua/ua/notebooks/c80004/",
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
}