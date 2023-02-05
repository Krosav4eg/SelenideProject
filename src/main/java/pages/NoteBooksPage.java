package pages;

import io.qameta.allure.Step;

import static helpers.ActionHelper.checkThatAllElementsContainsText;


public class NoteBooksPage extends AbstractPage {

    @Step("Check that goods tiles contains search word {searchWord}")
    public boolean checkThatGoodsTileContainsSearchWord(String searchWord) {
        getGoodItemFragment().witForAllGoodsBodyItemsArePresent();
        return checkThatAllElementsContainsText(getGoodItemFragment().getGoodsTitle(), searchWord);
    }

    @Step("check that all goods items have size")
    public void checkThatGoodsItemsHaveSize(int size) {
        getGoodItemFragment().checkSizeAllGoodsBodyItems(size);
    }

    @Step("check that all goods price is equal min and max price")
    public boolean checkThatGoodsItemsPriceRangeIsCorrect(int min, int max) {
        getGoodItemFragment().witForAllGoodsBodyItemsArePresent();
        return getGoodItemFragment().checkThatAllElementsContainsRequiredPriceRange(min, max);
    }
}