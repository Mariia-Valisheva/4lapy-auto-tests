package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FourLapyCardPage {
    private final SelenideElement
    firstProduct = $("#id_product_card_0"),
    cardTitle = $(".Cart_title__vqRph"),
    orderButton = $(".Button_theme-square-orange__0NLiJ");

    @Step("Проверяем что товар добавлен в корзину")
    public FourLapyCardPage checkAddedProduct(String expectedText) {
        firstProduct.shouldBe(visible);
        cardTitle.shouldHave(text(expectedText));
        return this;
    }

    @Step("Жмем на кнопку Оформить заказ")
    public FourLapyCardPage clickOnOrderButton() {
        orderButton.click();
        return this;
    }
}
