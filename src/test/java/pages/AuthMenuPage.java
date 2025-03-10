package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class AuthMenuPage {
    private final SelenideElement
            authBanner = $(".Auth_inner__Dv8Si"),
            authBannerTitle = $(".AuthHeader_headerTitle__C53JD"),
            phoneNumberInput = $("#id_login_phone_input"),
            loginContinueButton = $("#id_login_continue_button"),
            authByNumberSubTitle = $(".AuthHeader_additionalTitle__N2KJl");

    @Step("Открывается модальное окно регистрации/входа")
    public AuthMenuPage openedAuthBanner(String expectedTitle) {
        authBanner.should(appear);
        authBannerTitle.shouldHave(text(expectedTitle));
        return this;
    }

    @Step("Вводим номер телефона и нажимаем продолжить")
    public AuthMenuPage addPhoneNumber(String addedNumber) {
        phoneNumberInput.setValue(addedNumber);
        loginContinueButton.click();
        return this;
    }

    @Step("Проверяем текст подзаголовка модального окна")
    public AuthMenuPage checkWaitForCodePage(String expectedText) {
        authByNumberSubTitle.shouldHave(exactText(expectedText));
        return this;
    }
}
