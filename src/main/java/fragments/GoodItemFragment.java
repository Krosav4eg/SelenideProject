package fragments;

import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.ActionHelper.checkThatAllElementsAreVisible;
import static helpers.ActionHelper.checkThatElementCollectionsHasSize;


@Getter
public class GoodItemFragment {
    ElementsCollection goodsBodyItem = $$(byCssSelector("a.goods-tile__picture.ng-star-inserted"));
    ElementsCollection goodsTitle = $$(byCssSelector("span.goods-tile__title"));

    public void witForAllGoodsBodyItemsArePresent() {
        checkThatAllElementsAreVisible(goodsBodyItem);
    }

    public void checkSizeAllGoodsBodyItems(int elementsSize) {
        checkThatElementCollectionsHasSize(goodsBodyItem, elementsSize);
    }

}
