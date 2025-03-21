package api;

import io.qameta.allure.Step;
import io.restassured.specification.ResponseSpecification;
import models.GetTokenResponse;
import specs.BaseResponseSpec;
import tests.api.ApiTestBase;

import static io.restassured.RestAssured.given;
import static specs.BaseRequestSpec.commonRequestSpec;

public class GetAuthInfo extends ApiTestBase {

   @Step("Получаем информацию для аутентификации")
    public GetTokenResponse ResponseToken() {
        ResponseSpecification responseSpecification = new BaseResponseSpec().commonResponseSpec(200);

        return given(commonRequestSpec)
                .post(authPath)
                .then()
                .spec(responseSpecification)
                .extract().as(GetTokenResponse.class);
    }
}