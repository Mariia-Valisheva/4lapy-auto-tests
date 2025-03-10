package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {
    private final SelenideElement
            pageSubTitle = $(".SearchResultPageTitle_queryInfo__CdTbs"),
            addThirdProductToCard = $(".CardProduct_footer__L7y_4", 2).$(".Button_root__pS5iJ"),
            goToCardButton = $("#go_to_cart_link"),
            pageTitle = $(".Title_root__J7hHl"),
            plusButton = $("[data-counter-action=plus]");


    @Step("Проверяем результаты поиска по ключевому слову")
    public SearchResultPage checkSearchResult(String expectedText, int expectedSize) {
        pageSubTitle.shouldHave(exactTextCaseSensitive(expectedText));
        $$(".CardProduct_root__7zZ3z").shouldHave(CollectionCondition.sizeGreaterThan(expectedSize));
        return this;
    }

    @Step("Добавляем третий товар в корзину")
    public SearchResultPage addThirdProductToCard() {
        addThirdProductToCard.scrollTo().click();
        goToCardButton.shouldBe(visible);
        return this;
    }

    @Step("Увеличиваем количество штук товара для добавления в корзину")
    public SearchResultPage clickOnPlusButton() {
        plusButton.doubleClick();
        return this;
    }

    @Step("Проверяем результаты поиска по каталогу")
    public SearchResultPage checkCatalogSearchResult(String expectedText) {
        $(".Breadcrumbs_list__zCs6V:last-child").shouldHave(exactText(expectedText));
        return this;
    }
}
