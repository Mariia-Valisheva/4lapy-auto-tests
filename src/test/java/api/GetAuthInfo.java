package api;

import io.restassured.specification.ResponseSpecification;
import models.GetTokenResponse;
import specs.ResponseSpec;
import tests.api.ApiTestBase;

import static io.restassured.RestAssured.given;
import static specs.RequestSpec.commonRequestSpec;

public class GetAuthInfo extends ApiTestBase {

    public GetTokenResponse ResponseToken() {
        ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(200);

        return given(commonRequestSpec)
                .post(authPath)
                .then()
                .spec(responseSpecification)
                .extract().as(GetTokenResponse.class);
    }
}