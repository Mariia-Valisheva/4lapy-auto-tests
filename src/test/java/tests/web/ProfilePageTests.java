package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AuthMenuPage;
import pages.MainPage;
import utils.TestData;


@DisplayName("Тестирование личного кабинета")
public class ProfilePageTests extends WebTestBase {

    MainPage mainPage = new MainPage();
    AuthMenuPage authMenuPage = new AuthMenuPage();
    TestData testData = new TestData();

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
