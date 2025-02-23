package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class FourLapyAuthMenuPage {
    private final SelenideElement
            authBanner = $(".Auth_inner__Dv8Si"),
            authBannerTitle = $(".AuthHeader_headerTitle__C53JD"),
            phoneNumberInput = $("#id_login_phone_input"),
            loginContinueButton = $("#id_login_continue_button"),
            authByNumberSubTitle = $(".AuthHeader_additionalTitle__N2KJl");

    public FourLapyAuthMenuPage openedAuthBanner(String expectedTitle) {
        authBanner.should(appear);
        authBannerTitle.shouldHave(text(expectedTitle));
        return this;
    }

    public FourLapyAuthMenuPage addPhoneNumber(String addedNumber) {
        phoneNumberInput.setValue(addedNumber);
        loginContinueButton.click();
        return this;
    }

    public FourLapyAuthMenuPage checkWaitForCodePage(String expectedText) {
        authByNumberSubTitle.shouldHave(exactText(expectedText));
        return this;
    }
}
