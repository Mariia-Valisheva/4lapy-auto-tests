package tests.api;

import io.restassured.specification.ResponseSpecification;
import models.GetTokenResponse;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import specs.BaseResponseSpec;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.BaseRequestSpec.commonRequestSpec;

public class LoginTests extends ApiTestBase {

    @Test
    void getTokenInfoTest() {

        ResponseSpecification responseSpecification = new BaseResponseSpec().commonResponseSpec(200);


        GetTokenResponse getTokenResponse = step("Запрашиваем информацию для аутентификации", () ->
                given(commonRequestSpec)
                        .post(authPath)
                        .then()
                        .spec(responseSpecification)
                        .extract().as(GetTokenResponse.class));

        step("Проверяем полученную информацию", () ->
        {
            SoftAssertions.assertSoftly(
                    softAssertions -> {
                        assertThat(getTokenResponse.getToken().getAccessToken()).isNotEmpty();
                        assertThat(getTokenResponse.getToken().getRefreshToken()).isNotEmpty();
                        assertThat(getTokenResponse.getToken().getTokenType()).isNotEmpty();
                        assertThat(getTokenResponse.getToken().getTokenType()).isEqualTo("Bearer");
                        assertThat(getTokenResponse.getToken().getExpiresIn()).isEqualTo(43200);
                        assertThat(getTokenResponse.getToken().getSessionState()).isNotEmpty();
                        assertThat(getTokenResponse.getToken().getScope()).isNotEmpty();
                        assertThat(getTokenResponse.getToken().getScope()).isEqualTo("profile email");
                        assertThat(getTokenResponse.getToken().getRefreshExpiresIn()).isEqualTo(43200);
                    });
        });
    }
}
