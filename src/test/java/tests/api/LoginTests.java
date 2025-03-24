package tests.api;

import helpers.TestVariables;
import io.qameta.allure.*;
import io.restassured.specification.ResponseSpecification;
import models.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.ResponseSpec;
import utils.TestData;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.RequestSpec.commonRequestSpec;

@Owner("Мария Валишева")
@Tag("API")
@Epic("Разработка функционала Авторизации в личном кабинете")
@DisplayName("Тесты на авторизацию")
public class LoginTests extends ApiTestBase {

    ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(200);
    TestData td = new TestData();


    @Story("Функционал получения авторизационных данных")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тест на получение данных аутентификации")
    @Test
    void getTokenInfoTest() {

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

    @Story("Функционал авториизации с логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тест на успешный логин")
    @Test
    void successfulLoginTest() {
        TestVariables testVariables = new TestVariables();
        TokenDetails tokenDetails = testVariables.getAuthInfo();

        String accessToken = tokenDetails.getAccessToken();
        String sessionState = tokenDetails.getSessionState();
        String nextCustomerToken = td.accessTokenVar + accessToken + td.refreshTokenVar + tokenDetails.getRefreshToken()
                + td.tokenTypeVar + tokenDetails.getTokenType() + td.expiresVar + tokenDetails.getExpiresIn() +
                td.sessionVar + sessionState + td.scopeVar + td.refreshExpInVar +
                tokenDetails.getRefreshExpiresIn() + td.expAtVar + td.refreshExpAtVar;

        LoginValuesCollection loginValuesCollection = new LoginValuesCollection(td.getPassword(), td.getEmail());
        LoginRequest loginRequest = new LoginRequest(loginValuesCollection, accessToken);

        LoginResponse loginResponse = step("Логинимся с валидным логином и паролем", () ->
                given(commonRequestSpec)
                        .body(loginRequest)
                        .cookie("NEXT_CUSTOMER_TOKEN", nextCustomerToken)
                        .when()
                        .post(authEmailPath)
                        .then()
                        .spec(responseSpecification)
                        .extract().as(LoginResponse.class)
        );

        step("Проверяем успех логина", () -> {
            SoftAssertions.assertSoftly(
                    softAssertions -> {
                        assertThat(loginResponse.getType()).isEqualTo("email");
                        assertThat(loginResponse.getToken()).isNotNull();
                    });
        });
    }
}