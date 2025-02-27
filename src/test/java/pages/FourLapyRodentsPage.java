package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FourLapyRodentsPage {
    private final SelenideElement
            rodentsPageTitle = $(".Title_root__J7hHl");

    @Step("Проверяем заголовок страницы в разделе Грызуны")
    public FourLapyRodentsPage checkPageTitle(String expectedTitle) {
        rodentsPageTitle.shouldHave(text(expectedTitle));
        return this;
    }
}
