package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AuthMenuPage;
import pages.CardPage;
import pages.SearchResultPage;
import pages.MainPage;
import utils.TestGeneratedData;

@Tag("SMOKE")
@DisplayName("Тестирование корзины")
public class BasketPageTest extends FourLapyUiTestBase {
    MainPage mainPage = new MainPage();
    CardPage cardPage = new CardPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    AuthMenuPage authMenuPage = new AuthMenuPage();
    TestGeneratedData testGeneratedData = new TestGeneratedData();

    //готово
    @DisplayName("Тест на добавление товара в корзину")
    @Test
    void addProductToCardTest() {

        mainPage
                .searchByKeyWord(testGeneratedData.keyWord);

        searchResultPage
                .addThirdProductToCard()
                .clickOnPlusButton();

        mainPage
                .clickToCardIcon();

        cardPage
                .checkAddedProduct("3 товара в корзине");
    }

    //переделать
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

