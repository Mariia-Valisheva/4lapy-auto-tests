package api;


import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.AddToCardRequest;
import specs.RequestSpec;
import specs.ResponseSpec;
import tests.api.ApiTestBase;

import static io.restassured.RestAssured.given;

public class AddItemToCardWithoutLogin extends ApiTestBase {

    @Step("Добавляем товар в корзину пользователю")
    public void addItemToCardWithoutLogin(String token, AddToCardRequest addToCardRequest, String basketId, String customerId) {

        RequestSpecification requestSpecification = new RequestSpec().extendedRequestAuthSpec(token);
        ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(204);

        given(requestSpecification)
                .queryParam("customerId", customerId)
                .when()
                .body(addToCardRequest)
                .post(cartPath + basketId + itemPath)
                .then()
                .spec(responseSpecification)
                .extract().body();
    }
}
