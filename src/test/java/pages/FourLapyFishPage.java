package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FourLapyFishPage {
    private final SelenideElement
    fishPageTitle = $(".Title_root__J7hHl");

    @Step("Проверяем заголовок страницы в разделе Рыбы")
    public FourLapyFishPage checkPageTitle (String expectedTitle) {
        fishPageTitle.shouldHave(text(expectedTitle));
        return this;
    }
}
