package api;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.GetCustomerCardResponse;
import specs.RequestSpec;
import specs.ResponseSpec;
import tests.api.ApiTestBase;

import static io.restassured.RestAssured.given;

public class GetCustomerCardWithoutLogin extends ApiTestBase {
    @Step("Получаем данные о корзине пользователя")
    public GetCustomerCardResponse getCustomerCardWithoutLogin(String token, String basketId, String customerId) {

        RequestSpecification requestSpecification = new RequestSpec().extendedRequestAuthSpec(token);
        ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(200);

        return given(requestSpecification)
                .queryParam("customerId", customerId)
                .when()
                .get(cartPath + basketId + miniCartPath)
                .then()
                .spec(responseSpecification)
                .extract().as(GetCustomerCardResponse.class);
    }
}
