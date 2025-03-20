package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@DisplayName("Тестирование карточки товара")
public class ProductCardPage {

    private final SelenideElement
            cardPicture = $(".CardProduct_link__Rg5M2"),
            ratingAmountLink = $(".StarRating_textRating__0ptP6");


    @Step("Кликаем на карточку товара")
    public ProductCardPage clickOnProductCard() {
        cardPicture.click();
        return this;
    }

    @Step("Переходим в отзывы")
    public ProductCardPage goToReviews() {
        ratingAmountLink.click();
        return this;
    }

    @Step("Проверяем, что отзывы отображаются")
    public ProductCardPage checkReviewsVisible(int expectedSize) {
        $$(".UserReviews_reviewsList__HJ_MZ").shouldHave(CollectionCondition.sizeGreaterThan(expectedSize));
        return this;
    }

}
