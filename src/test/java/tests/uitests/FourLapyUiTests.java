package tests.uitests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.FourLapyGeneratedData;

import static io.qameta.allure.Allure.step;

@Tag("SMOKE")
@DisplayName("Тесты для сайта Четыре Лапы")
public class FourLapyUiTests extends FourLapyUiTestBase {

    FourLapyiMainPage mainPage = new FourLapyiMainPage();
    FourLapySearchResultPage searchResultPage = new FourLapySearchResultPage();
    FourLapyCardPage cardPage = new FourLapyCardPage();
    FourLapySalesPage salesPage = new FourLapySalesPage();
    FourLapyAuthMenuPage authMenuPage = new FourLapyAuthMenuPage();
    FourLapyGeneratedData generatedData = new FourLapyGeneratedData();
    FourLapyCatsPage catsPage = new FourLapyCatsPage();
    FourLapyDogsPage dogsPage = new FourLapyDogsPage();
    FourLapyFishPage fishPage = new FourLapyFishPage();
    FourLapyBirdsPage birdsPage = new FourLapyBirdsPage();
    FourLapyRodentsPage rodentsPage = new FourLapyRodentsPage();

    @DisplayName("Тест на поиск по ключевому слову")
    @Order(1)
    @Test
    void searchByKeyWordsTest() {
        step("В строку поиска вводим ключевое слово", () -> {
            mainPage
                    .searchByKeyWord(generatedData.keyWord);
        });

        step("Проверяем, что поиск отработал корректно", () -> {
            searchResultPage
                    .checkSearchResult("По запросу «"
                            + generatedData.keyWord + "» мы нашли", 1);
        });
    }


    @DisplayName("Тест на добавление товара в корзину")
    @Order(4)
    @Test
    void addProductToCardTest() {
        step("В строку поиска вводим ключевое слово 'лежанка'", () -> {
            mainPage
                    .searchByKeyWord("лежанка");
        });

        step("На третьей карточке товара кликаем кнопку 'Добавить в корзину'", () -> {
            searchResultPage
                    .addThirdProductToCard();
        });

        step("Переходим в корзину через иконку корзины", () -> {
            mainPage
                    .clickToCardIcon();
        });

        step("Проверяем, что товар добаивлся в корзину", () -> {
            cardPage
                    .checkAddedProduct("1 товар в корзине");
        });
    }

    @DisplayName("Тест на поиск по каталогу")
    @Order(2)
    @Test
    void searchInCatalogTest() {
        step("В каталоге находим раздел 'Сухой корм' и переходим в него", () -> {
            mainPage
                    .closeLocationPopUp()
                    .searchInCatalog("Сухой корм");
        });

        step("Проверяем заголовок раздела", () -> {
            searchResultPage
                    .checkCatalogSearchResult("Сухой корм для кошек и котов");
        });
    }


    @DisplayName("Тест на работу табов")
    @Order(3)
    @Test
    void searchByTabsTest() {
        step("Кликаем по табу 'акции'", () -> {
            mainPage
                    .closeLocationPopUp()
                    .clickOnTab("акции");

        });

        step("Проверяем заголовок страницы", () -> {
            salesPage
                    .checkPageTitle("Акции и спецпредложения");
        });

        step("Кликаем по табу 'кошки'", () -> {
            mainPage
                    .clickOnTab("кошки");
        });

        step("Проверяем заголовок страницы", () -> {
            catsPage
                    .checkPageTitle("Товары для кошек");
        });

        step("Кликаем по табу 'собаки'", () -> {
            mainPage
                    .clickOnTab("собаки");
        });

        step("Проверяем заголовок страницы", () -> {
            dogsPage
                    .checkPageTitle("Товары для собак");
        });

        step("Кликаем по табу 'рыбы'", () -> {
            mainPage
                    .clickOnTab("рыбы");
        });

        step("Проверяем заголовок страницы", () -> {
            fishPage
                    .checkPageTitle("Товары для аквариумистики");
        });

        step("Кликаем по табу 'грызуны'", () -> {
            mainPage
                    .clickOnTab("грызуны");
        });

        step("Проверяем заголовок страницы", () -> {
            rodentsPage
                    .checkPageTitle("Товары для грызунов и хорьков");
        });

        step("Кликаем по табу 'птицы'", () -> {
            mainPage
                    .clickOnTab("птицы");
        });
        step("Проверяем заголовок страницы", () -> {
            birdsPage
                    .checkPageTitle("Товары для птиц");
        });
    }

    @DisplayName("Тест на возможность оформить заказ только авторизированным пользователям")
    @Order(6)
    @Test
    void setAnOrderByUnauthorizedUser() {
        step("В строку поиска вводим ключевое слово 'лежанка'", () -> {
            mainPage
                    .searchByKeyWord("лежанка");
        });

        step("Добавляем товар в корзину", () -> {
            searchResultPage
                    .addThirdProductToCard();
        });

        step("Переходим в корзину", () -> {
            mainPage
                    .clickToCardIcon();
        });

        step("Кликаем на кнопку 'Оформить заказ'", () -> {
            cardPage
                    .clickOnOrderButton();
        });

        step("Проверяем, что появилось модальное окно входа/регистрации", () -> {
            authMenuPage
                    .openedAuthBanner("войдите или зарегистрируйтесь");
        });
    }

    @DisplayName("Тест на возможность зарегистрироваться с номером телефона")
    @Order(5)
    @Test
    void resisterWithPhoneNumberPossibilityTest() {
        step("Кликаем на иконку профиля", () -> {
            mainPage
                    .clickOnProfileIcon();
        });

        step("Вводим номер телефона", () -> {
            authMenuPage
                    .addPhoneNumber(generatedData.phoneNumberPrefix +
                            generatedData.phoneNumberThreeDigits +
                            generatedData.phoneNumberTwoDigits1 +
                            generatedData.phoneNumberTwoDigits2);
        });

        step("Проверяем информационный текст", () -> {
            authMenuPage
                    .checkWaitForCodePage("Мы отправили код подтверждения на номер +7 (***) ***-"
                            + generatedData.phoneNumberTwoDigits1
                            + "-"
                            + generatedData.phoneNumberTwoDigits2);
        });
    }
}