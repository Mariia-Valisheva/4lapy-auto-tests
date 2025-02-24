package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FourLapyDogsPage {
    private final SelenideElement
            dogsPageTitle = $(".Title_root__J7hHl");


    public FourLapyDogsPage checkPageTitle(String expectedTitle) {
        dogsPageTitle.shouldHave(text(expectedTitle));
        return this;
    }
}
