package api;

import io.qameta.allure.Step;
import io.restassured.specification.ResponseSpecification;
import models.LoginRequest;
import models.LoginResponse;
import specs.ResponseSpec;
import tests.api.ApiTestBase;

import static io.restassured.RestAssured.given;
import static specs.RequestSpec.commonRequestSpec;

public class LoginApi extends ApiTestBase {

    @Step("Логинимся")
    public LoginResponse loginApi(LoginRequest loginRequest, String nextCustomerToken) {
        ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(200);
        return given(commonRequestSpec)
                .body(loginRequest)
                .cookie("NEXT_CUSTOMER_TOKEN", nextCustomerToken)
                .when()
                .post(authEmailPath)
                .then()
                .spec(responseSpecification)
                .extract().as(LoginResponse.class);
    }
}
