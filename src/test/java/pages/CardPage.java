package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CardPage {
    private final SelenideElement
    firstProduct = $("#id_product_card_0"),
    cardTitle = $(".Cart_root__QT7Cz .Title_root__J7hHl"),
    orderButton = $(".Button_theme-square-orange__0NLiJ");

    @Step("Проверяем что товар добавлен в корзину")
    public CardPage checkAddedProduct(String expectedText) {
        cardTitle.shouldHave(exactText(expectedText));
        firstProduct.shouldBe(visible);
        return this;
    }

    @Step("Жмем на кнопку Оформить заказ")
    public CardPage clickOnOrderButton() {
        orderButton.click();
        return this;
    }
}
