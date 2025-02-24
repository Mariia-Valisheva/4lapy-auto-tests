package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FourLapyCatsPage {
    private final SelenideElement
            catsPageTitle = $(".Title_root__J7hHl");

    public FourLapyCatsPage checkPageTitle(String expectedTitle) {
        catsPageTitle.shouldHave(text(expectedTitle));
        return this;
    }
}
