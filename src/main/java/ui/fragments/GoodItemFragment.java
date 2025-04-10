package ui.fragments;

import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;
import ui.helpers.ActionHelper;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$$;


@Getter
public class GoodItemFragment {
    ElementsCollection goodsBodyItem = $$(byCssSelector("rz-product-tile>div.content"));
    ElementsCollection goodsTitle = $$(byCssSelector("a.tile-title.black-link.text-base"));

    public void witForAllGoodsBodyItemsArePresent() {
        ActionHelper.checkThatAllElementsAreVisible(goodsBodyItem);
    }

    public int getSizeAllGoodsBodyItems() {
      return  ActionHelper.getSizeAllGoodsBodyItems(goodsBodyItem);
    }
}