package pages;

import io.qameta.allure.Step;
import static helpers.ActionHelper.checkThatAllElementsContainsText;


public class NoteBooksPage extends AbstractPage {

    @Step("Check that goods tiles contains search word {searchWord}")
    public boolean checkThatGoodsTileContainsSearchWord(String searchWord) {
        getGoodItemFragment().witForAllGoodsBodyItemsArePresent();
        return checkThatAllElementsContainsText(getGoodItemFragment().getGoodsTitle(),searchWord);
    }

    @Step("check that all goods items have size")
    public void checkThatGoodsItemsHaveSize(int size) {
        getGoodItemFragment().checkSizeAllGoodsBodyItems(size);
    }
}