package ui.pages;

import ui.fragments.*;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import utils.PropsConfig;

/**
 * AbstractPage class contains all common fragments in application
 * and general methods related to navigation and checking page condition.
 * This fragments can be using for interaction in different classes.
 */
@Getter
public class AbstractPage {
    public static final PropsConfig PROPS = ConfigFactory.create(PropsConfig.class);

    protected HeaderFragment headerFragment = new HeaderFragment();
    protected MenuCategoriesFragment menuCategoriesFragment = new MenuCategoriesFragment();
    protected GoodItemFragment goodItemFragment = new GoodItemFragment();
    protected FilterSideFragment filterSideFragment = new FilterSideFragment();
    protected ExponeaBannerFragment exponeaBannerFragment = new ExponeaBannerFragment();
}