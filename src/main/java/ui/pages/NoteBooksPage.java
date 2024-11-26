package ui.pages;

import io.qameta.allure.Step;
import ui.helpers.ActionHelper;


public class NoteBooksPage extends AbstractPage {

    @Step("Check that goods tiles contains search word {searchWord}")
    public boolean checkThatGoodsTileContainsSearchWord(String searchWord) {
        getGoodItemFragment().witForAllGoodsBodyItemsArePresent();
        return ActionHelper.checkThatAllElementsContainsText(getGoodItemFragment().getGoodsTitle(), searchWord);
    }

    @Step("Get amount of goods")
    public int checkThatGoodsItemsHaveSize() {
        getGoodItemFragment().witForAllGoodsBodyItemsArePresent();
       return getGoodItemFragment().getSizeAllGoodsBodyItems();
    }
}