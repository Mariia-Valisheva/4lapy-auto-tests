package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FourLapySalesPage {
    private final SelenideElement
    promotionPageTitle = $(".Promotions_title__BUZwd");

    public FourLapySalesPage checkPageTitle (String expectedTitle, int expectedSize) {
        promotionPageTitle.shouldHave(text(expectedTitle));
        $$(".PromotionsList_promotionItem__YTIwh").shouldHave(CollectionCondition.sizeGreaterThanOrEqual(expectedSize));
        return this;
    }
}
