package tests.api;

import api.*;
import helpers.TestVariables;
import io.qameta.allure.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.AddToCardRequest;
import models.CardItemsCollection;
import models.GetCustomerCardResponse;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.RequestSpec;
import specs.ResponseSpec;
import utils.TestData;

import java.util.Collections;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Мария Валишева")
@Tag("API")
@Epic("Разработка функционала Избранное и Корзина")
@DisplayName("Тесты на работу с корзиной")
public class BasketTests extends ApiTestBase {

    TestData testData = new TestData();
    TestVariables testVariables = new TestVariables();
    String token = testVariables.getToken();
    RequestSpecification requestSpecification = new RequestSpec().extendedRequestAuthSpec(token);
    String customerId = testVariables.getCustomerId(token);
    String basketId = testVariables.getBasketId(token, customerId);

    @Story("Функционал работы с корзиной")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тест на добавление товара в корзину")
    @Test
    void addToCardWithoutLoginTest() {
        CardItemsCollection cardItemsCollection = new CardItemsCollection();
        cardItemsCollection.setOfferId(testData.skuId);
        cardItemsCollection.setQuantity(testData.offerAmount);

        AddToCardRequest addToCardRequest = new AddToCardRequest();
        addToCardRequest.setCartItems(Collections.singletonList(cardItemsCollection));

        ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(204);

        step("Добавляем товар в корзину пользователю без регистрации", () ->
                given(requestSpecification)
                        .queryParam("customerId", customerId)
                        .when()
                        .body(addToCardRequest)
                        .post(cartPath + basketId + itemPath)
                        .then()
                        .spec(responseSpecification)
                        .extract().body()
        );

        step("Проверяем, что товар лежит в корзине пользователя", () ->
        {
            GetCustomerCardWithoutLogin getCustomerCardWithoutLogin = new GetCustomerCardWithoutLogin();
            GetCustomerCardResponse getCustomerCardResponse = getCustomerCardWithoutLogin
                    .getCustomerCardWithoutLogin(token, basketId, customerId);

            SoftAssertions.assertSoftly(
                    softAssertions -> {
                        assertThat(getCustomerCardResponse.getItems().get(0).getOfferId())
                                .isEqualTo(testData.skuId);
                        assertThat(getCustomerCardResponse.getItems().get(0).getQuantity())
                                .isEqualTo(testData.offerAmount);
                    });
        });
    }

    @Story("Функционал работы с корзиной")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тест на получение товаров в корзине")
    @Test
    void getCustomerCardWithoutLoginTest() {
        CardItemsCollection cardItemsCollection = new CardItemsCollection();
        cardItemsCollection.setOfferId(testData.skuId);
        cardItemsCollection.setQuantity(testData.offerAmount);

        AddToCardRequest addToCardRequest = new AddToCardRequest();
        addToCardRequest.setCartItems(Collections.singletonList(cardItemsCollection));

        AddItemToCardWithoutLogin addItemToCardWithoutLogin = new AddItemToCardWithoutLogin();
        addItemToCardWithoutLogin.addItemToCardWithoutLogin(token, addToCardRequest, basketId, customerId);

        ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(200);

        GetCustomerCardResponse getCustomerCardResponse = step("Получаем данные о корзине пользователя", () ->
                given(requestSpecification)
                        .queryParam("customerId", customerId)
                        .when()
                        .get(cartPath + basketId + "/" + miniCartPath)
                        .then()
                        .spec(responseSpecification)
                        .extract().as(GetCustomerCardResponse.class));

        step("Проверяем полученные данные", () ->
        {
            SoftAssertions.assertSoftly(
                    softAssertions -> {
                        assertThat(getCustomerCardResponse.getItems().get(0).getOfferId())
                                .isEqualTo(testData.skuId);
                        assertThat(getCustomerCardResponse.getItems().get(0).getQuantity())
                                .isEqualTo(testData.offerAmount);
                    });
        });
    }

    @Story("Функционал работы с корзиной")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тест на удаление товаров из корзины")
    @Test
    void deleteFromCardWithoutLoginTest() {
        CardItemsCollection cardItemsCollection = new CardItemsCollection();
        cardItemsCollection.setOfferId(testData.skuId);
        cardItemsCollection.setQuantity(1);

        AddToCardRequest addToCardRequest = new AddToCardRequest();
        addToCardRequest.setCartItems(Collections.singletonList(cardItemsCollection));

        AddItemToCardWithoutLogin addItemToCardWithoutLogin = new AddItemToCardWithoutLogin();
        addItemToCardWithoutLogin.addItemToCardWithoutLogin(token, addToCardRequest, basketId, customerId);

        ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(204);

        step("Удаляем товар из корзины", () ->
                given(requestSpecification)
                        .queryParam("customerId", customerId)
                        .when()
                        .delete(cartPath + basketId + itemPath + "/" + testData.skuId)
                        .then()
                        .spec(responseSpecification)
                        .extract().body());


        step("Проверяем, что товар удалился", () ->
        {
            SoftAssertions.assertSoftly(
                    softAssertions -> {
                        GetCustomerCardWithoutLogin getCustomerCardWithoutLogin = new GetCustomerCardWithoutLogin();
                        assertThat(getCustomerCardWithoutLogin.getCustomerCardWithoutLogin(token, basketId, customerId)
                                .getItems()).isEmpty();
                        assertThat(getCustomerCardWithoutLogin.getCustomerCardWithoutLogin(token, basketId, customerId)
                                .getTotal().getQuantity()).isEqualTo(0);
                    });
        });
    }
}
