package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CityPage {
    private final SelenideElement
            yourCity = $(".SelectionCity_hide__tatPX .HeaderInfoItem_title__kcxuB"),
            cityInput = $(".Input_input__OotlP"),
            firstCity = $(".PopupCity_listEl__v_XqF", 0),
            chosenCity = $(".SelectionCity_ellipsis__6THX1");

    public CityPage clickOnYourCity() {
        yourCity.click();
        return this;
    }

    public CityPage chooseRandomCity(String randomCity) {
        cityInput.setValue(randomCity);
        firstCity.shouldHave(text(randomCity));
        firstCity.click();
        return this;
    }

    public CityPage checkChosenCity(String expectedCity) {
        chosenCity.shouldHave(exactText(expectedCity));
        return this;
    }
}
