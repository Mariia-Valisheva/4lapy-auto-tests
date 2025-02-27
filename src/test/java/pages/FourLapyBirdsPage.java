package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FourLapyBirdsPage {
    private final SelenideElement
            birdsPageTitle = $(".Title_root__J7hHl");

    @Step("Проверяем заголовок страницы в разделе Птицы")
    public FourLapyBirdsPage checkPageTitle(String expectedTitle) {
        birdsPageTitle.shouldHave(text(expectedTitle));
        return this;
    }
}
