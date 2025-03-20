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
            authByNumberSubTitle = $(".AuthHeader_additionalTitle__N2KJl"),
            loginWithEmailButton = $("#id_login_by_email"),
            emailInput = $("#id_login_email_input"),
            passwordInput = $("#id_login_password_input"),
            personalAcc = $("#nav__profile_personal"),
            digitsInput = $("#id_register_code_input"),
            notificationPlace = $(".uppercase-first"),
            emailField = $("#id_profile_email_value");

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
    public AuthMenuPage checkWaitForCodeText(String expectedText) {
        authByNumberSubTitle.shouldHave(exactText(expectedText));
        return this;
    }


    @Step("Вводим четырехзначный код")
    public AuthMenuPage setFourDigits(String digits) {
        digitsInput.setValue(digits).pressEnter();
        return this;
    }

    @Step("Проверяем всплывающее уведомление")
    public AuthMenuPage checkNotification(String expectedText) {
        notificationPlace.shouldHave(exactText(expectedText));
        return this;
    }

    @Step("Логинимся с электронной почтой")
    public AuthMenuPage loginWithEmail(String email, String password) {
        loginWithEmailButton.click();
        emailInput.setValue(email).pressEnter();
        passwordInput.setValue(password);
        loginContinueButton.click();
        return this;
    }

    @Step("Переходим в личный кабинет")
    public AuthMenuPage goToPersonalAcc() {
        personalAcc.click();
        return this;
    }

    @Step("Проверяем, что залогинились успешно")
    public AuthMenuPage checkSuccessLogin(String email) {
        emailField.shouldHave(exactText(email));
        return this;
    }
}
