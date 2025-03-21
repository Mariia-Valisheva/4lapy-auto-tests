package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AuthMenuPage;
import pages.MainPage;
import utils.TestGeneratedData;


@Tag("SMOKE")
@DisplayName("Тестирование личного кабинета")
public class ProfilePageTests extends WebTestBase {

    MainPage mainPage = new MainPage();
    AuthMenuPage authMenuPage = new AuthMenuPage();
    TestGeneratedData generatedData = new TestGeneratedData();

    //готово
    @DisplayName("Тест на введение некорректного кода при регистрации через номер телефона")
    @Test
    void resisterWithPhoneNumberPossibilityTest() {
        mainPage
                .clickOnProfileIcon();

        authMenuPage
                .addPhoneNumber(generatedData.phoneNumberPrefix +
                        generatedData.phoneNumberThreeDigits +
                        generatedData.phoneNumberTwoDigits1 +
                        generatedData.phoneNumberTwoDigits2)
                .checkWaitForCodeText("Мы отправили код подтверждения на номер +7 (***) ***-"
                        + generatedData.phoneNumberTwoDigits1
                        + "-"
                        + generatedData.phoneNumberTwoDigits2)
                .setFourDigits(generatedData.phoneNumberTwoDigits1 +
                        generatedData.phoneNumberTwoDigits2)
                .checkNotification("Код подтверждения введён неверно, попробуйте ещё раз");
    }


    //готово
    @DisplayName("Тест на успешный логин с email")
    @Test
    void successLoginWithEmailTest() {
        mainPage
                .clickOnProfileIcon();

        authMenuPage
                .loginWithEmail("dolnish9@gmail.com", "Mashinka_4709");

        mainPage
                .clickOnProfileIcon();

        authMenuPage
                .goToPersonalAcc()
                .checkSuccessLogin("dolnish9@gmail.com");
    }
}
