package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FourLapyFishPage {
    private final SelenideElement
    fishPageTitle = $(".Title_root__J7hHl");

    public FourLapyFishPage checkPageTitle (String expectedTitle) {
        fishPageTitle.shouldHave(text(expectedTitle));
        return this;
    }
}
