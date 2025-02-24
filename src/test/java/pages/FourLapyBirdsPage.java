package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FourLapyBirdsPage {
    private final SelenideElement
            birdsPageTitle = $(".Title_root__J7hHl");

    public FourLapyBirdsPage checkPageTitle(String expectedTitle) {
        birdsPageTitle.shouldHave(text(expectedTitle));
        return this;
    }
}
