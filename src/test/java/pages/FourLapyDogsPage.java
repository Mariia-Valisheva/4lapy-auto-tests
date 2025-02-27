package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FourLapyDogsPage {
    private final SelenideElement
            dogsPageTitle = $(".Title_root__J7hHl");

    @Step("Проверяем заголовок страницы в разделе Собаки")
    public FourLapyDogsPage checkPageTitle(String expectedTitle) {
        dogsPageTitle.shouldHave(text(expectedTitle));
        return this;
    }
}
