package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FourLapySearchResultPage {
    private final SelenideElement
            pageSubTitle = $(".SearchResultPageTitle_queryInfo__CdTbs"),
            addThirdProductToCard = $(".CardProduct_footer__L7y_4", 2).$(".Button_root__pS5iJ"),
            goToCardButton = $("#go_to_cart_link"),
            pageTitle = $(".Title_root__J7hHl");


    @Step("Проверяем результаты поиска по ключевому слову")
    public FourLapySearchResultPage checkSearchResult (String expectedText, int expectedSize) {
        pageSubTitle.shouldHave(exactTextCaseSensitive(expectedText));
        $$(".CardProduct_root__7zZ3z").shouldHave(CollectionCondition.sizeGreaterThan(expectedSize));
        return this;
    }

    @Step("Добавляем третий товар в корзину")
    public FourLapySearchResultPage addThirdProductToCard() {
        addThirdProductToCard.click();
        goToCardButton.shouldBe(visible);
        return this;
    }

    @Step("Проверяем результаты поиска по каталогу")
    public FourLapySearchResultPage checkCatalogSearchResult (String expectedText) {
        pageTitle.shouldHave(text(expectedText));
        return this;
    }
}
