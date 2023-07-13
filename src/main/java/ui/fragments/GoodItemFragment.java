package ui.fragments;

import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;
import ui.helpers.ActionHelper;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$$;


@Getter
public class GoodItemFragment {
    ElementsCollection goodsBodyItem = $$(byCssSelector("a.goods-tile__picture.ng-star-inserted"));
    ElementsCollection goodsTitle = $$(byCssSelector("span.goods-tile__title"));

    public void witForAllGoodsBodyItemsArePresent() {
        ActionHelper.checkThatAllElementsAreVisible(goodsBodyItem);
    }

    public void checkSizeAllGoodsBodyItems(int elementsSize) {
        ActionHelper.checkThatElementCollectionsHasSize(goodsBodyItem, elementsSize);
    }

}
