package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CityPage {
    private final SelenideElement
            yourCity = $(".SelectionCity_hide__tatPX .HeaderInfoItem_title__kcxuB"),
            cityInput = $(".Input_input__OotlP"),
            firstCity = $(".PopupCity_listEl__v_XqF", 0),
            chosenCity = $(".SelectionCity_ellipsis__6THX1");

    @Step("Кликаем на фразу Ваш город")
    public CityPage clickOnYourCity() {
        yourCity.click();
        return this;
    }

    @Step("Вводим название города в поиске и кликаем на найденный город")
    public CityPage chooseRandomCity(String randomCity) {
        cityInput.setValue(randomCity);
        firstCity.shouldHave(text(randomCity));
        firstCity.click();
        return this;
    }

    @Step("Проверяем название города на главной странице ")
    public CityPage checkChosenCity(String expectedCity) {
        chosenCity.shouldHave(exactText(expectedCity));
        return this;
    }
}
