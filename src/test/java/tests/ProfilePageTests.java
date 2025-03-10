package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AuthMenuPage;
import pages.MainPage;
import utils.TestGeneratedData;


@Tag("SMOKE")
@DisplayName("Тестирование личного кабинета")
public class ProfilePageTests extends FourLapyUiTestBase {

    MainPage mainPage = new MainPage();
    AuthMenuPage authMenuPage = new AuthMenuPage();
    TestGeneratedData generatedData = new TestGeneratedData();

    @DisplayName("Тест на возможность зарегистрироваться с номером телефона")
    @Test
    void resisterWithPhoneNumberPossibilityTest() {
        mainPage
                .clickOnProfileIcon();

        authMenuPage
                .addPhoneNumber(generatedData.phoneNumberPrefix +
                        generatedData.phoneNumberThreeDigits +
                        generatedData.phoneNumberTwoDigits1 +
                        generatedData.phoneNumberTwoDigits2);

        authMenuPage
                .checkWaitForCodePage("Мы отправили код подтверждения на номер +7 (***) ***-"
                        + generatedData.phoneNumberTwoDigits1
                        + "-"
                        + generatedData.phoneNumberTwoDigits2);
    }
}
