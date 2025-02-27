package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FourLapyAuthMenuPage;
import pages.FourLapyiMainPage;
import utils.FourLapyGeneratedData;


@Tag("SMOKE")
public class ProfilePageTests extends FourLapyUiTestBase {

    FourLapyiMainPage mainPage = new FourLapyiMainPage();
    FourLapyAuthMenuPage authMenuPage = new FourLapyAuthMenuPage();
    FourLapyGeneratedData generatedData = new FourLapyGeneratedData();

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
