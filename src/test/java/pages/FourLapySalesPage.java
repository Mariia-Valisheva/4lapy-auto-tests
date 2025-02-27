package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FourLapySalesPage {
    private final SelenideElement
            promotionPageTitle = $(".Promotions_title__BUZwd");

    @Step("Проверяем заголовок страницы в разделе Акции")
    public FourLapySalesPage checkPageTitle(String expectedTitle) {
        promotionPageTitle.shouldHave(text(expectedTitle));
        return this;
    }
}
