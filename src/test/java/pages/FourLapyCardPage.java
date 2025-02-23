package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FourLapyCardPage {
    private final SelenideElement
    firstProduct = $("#id_product_card_0"),
    cardTitle = $(".Cart_title__vqRph"),
    orderButton = $(".Button_theme-square-orange__0NLiJ");

    public FourLapyCardPage checkAddedProduct(String expectedText) {
        firstProduct.shouldBe(visible);
        cardTitle.shouldHave(text(expectedText));
        return this;
    }

    public FourLapyCardPage clickOnOrderButton() {
        orderButton.click();
        return this;
    }
}
