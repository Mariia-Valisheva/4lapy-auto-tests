package tests.web;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ProductCardPage;
import utils.TestData;

@Owner("Мария Валишева")
@Tag("WEB")
@Epic("Разработка функционала Карточка товара")
@DisplayName("Тесты на проверку карточки товара")
public class ProductCardTest extends WebTestBase {

    MainPage mainPage = new MainPage();
    ProductCardPage productCardPage = new ProductCardPage();
    TestData generatedData = new TestData();

    @Story("Отзывы в карточке товара")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Тест на отображение отзывов у товара")
    @Test
    void checkReviewTest() {

        mainPage
                .searchByKeyWord(generatedData.keyWord);

        productCardPage
                .clickOnProductCard()
                .goToReviews()
                .checkReviewsVisible(0);
    }
}
