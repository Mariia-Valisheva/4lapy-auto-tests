package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FourLapyAuthMenuPage;
import pages.FourLapyCardPage;
import pages.FourLapySearchResultPage;
import pages.FourLapyiMainPage;

@Tag("SMOKE")
public class BasketPageTest extends FourLapyUiTestBase {
    FourLapyiMainPage mainPage = new FourLapyiMainPage();
    FourLapyCardPage cardPage = new FourLapyCardPage();
    FourLapySearchResultPage searchResultPage = new FourLapySearchResultPage();
    FourLapyAuthMenuPage authMenuPage = new FourLapyAuthMenuPage();


    @DisplayName("Тест на добавление товара в корзину")
    @Test
    void addProductToCardTest() {

        mainPage
                .searchByKeyWord("лежанка");

        searchResultPage
                .addThirdProductToCard();

        mainPage
                .clickToCardIcon();

        cardPage
                .checkAddedProduct("1 товар в корзине");
    }

    @DisplayName("Тест на возможность оформить заказ только авторизированным пользователям")
    @Test
    void setAnOrderByUnauthorizedUserTest() {
        mainPage
                .searchByKeyWord("лежанка");

        searchResultPage
                .addThirdProductToCard();

        mainPage
                .clickToCardIcon();

        cardPage
                .clickOnOrderButton();

        authMenuPage
                .openedAuthBanner("войдите или зарегистрируйтесь");
    }
}
