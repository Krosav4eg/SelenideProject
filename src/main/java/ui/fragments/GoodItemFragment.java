package ui.fragments;

import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;
import ui.helpers.ActionHelper;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$$;


@Getter
public class GoodItemFragment {
    ElementsCollection goodsBodyItem = $$(byCssSelector("div.goods-tile__content"));
    ElementsCollection goodsTitle = $$(byCssSelector("span.goods-tile__title"));

    public void witForAllGoodsBodyItemsArePresent() {
        ActionHelper.checkThatAllElementsAreVisible(goodsBodyItem);
    }

    public int getSizeAllGoodsBodyItems() {
      return  ActionHelper.getSizeAllGoodsBodyItems(goodsBodyItem);
    }
}