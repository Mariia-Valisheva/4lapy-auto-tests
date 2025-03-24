package tests.web;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AuthMenuPage;
import pages.MainPage;
import utils.TestData;


@Owner("Мария Валишева")
@Tag("WEB")
@Epic("Разработка функционала авторизации")
@DisplayName("Тестирование личного кабинета")
public class ProfilePageTests extends WebTestBase {

    MainPage mainPage = new MainPage();
    AuthMenuPage authMenuPage = new AuthMenuPage();
    TestData testData = new TestData();

    @Story("Авторизация с номером телефона")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тест на уведомление при введении некорректного кода подтверждения")
    @Test
    void resisterWithPhoneNumberPossibilityTest() {
        mainPage
                .clickOnProfileIcon();

        authMenuPage
                .addPhoneNumber(testData.phoneNumberPrefix +
                        testData.phoneNumberThreeDigits +
                        testData.phoneNumberTwoDigits1 +
                        testData.phoneNumberTwoDigits2)
                .checkWaitForCodeText("Мы отправили код подтверждения на номер +7 (***) ***-"
                        + testData.phoneNumberTwoDigits1
                        + "-"
                        + testData.phoneNumberTwoDigits2)
                .setFourDigits(testData.phoneNumberTwoDigits1 +
                        testData.phoneNumberTwoDigits2)
                .checkNotification("Код подтверждения введён неверно, попробуйте ещё раз");
    }


    @Story("Авторизация с email")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тест на успешный логин с валидным email")
    @Test
    void successLoginWithEmailTest() {
        mainPage
                .clickOnProfileIcon();

        authMenuPage
                .loginWithEmail(testData.getEmail(), testData.getPassword());

        mainPage
                .clickOnProfileIcon();

        authMenuPage
                .goToPersonalAcc()
                .checkSuccessLogin(testData.getEmail());
    }
}
