package tests.web;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CardPage;
import pages.SearchResultPage;
import pages.MainPage;
import utils.TestData;



@Owner("Мария Валишева")
@Tag("WEB")
@Epic("Разработка функционала Корзины")
@DisplayName("Тестирование корзины")
public class BasketPageTest extends WebTestBase {
    MainPage mainPage = new MainPage();
    CardPage cardPage = new CardPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    TestData td = new TestData();


    @Story("Функционал добавления товара в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тест на добавление товара в корзину")
    @Test
    void addProductToCardTest() {

        mainPage
                .searchByKeyWord(td.keyWord);

        searchResultPage
                .addThirdProductToCard()
                .clickOnPlusButton();

        mainPage
                .clickToCardIcon();

        cardPage
                .checkAddedProduct("3 товара в корзине");
    }
}

