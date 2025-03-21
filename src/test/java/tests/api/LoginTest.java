package tests.api;

import api.GetAuthInfo;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoginTest {

    @Test
    void successfulLoginTest() {
        GetAuthInfo getToken = new GetAuthInfo();
        String accessToken = getToken.ResponseToken().getToken().getAccessToken();
        String refreshToken = getToken.ResponseToken().getToken().getRefreshToken();
        String sessionState = getToken.ResponseToken().getToken().getSessionState();
        String nextcustomertoken = "%7B%22accessToken%22%3A%22" + accessToken + "%22%2C%22refreshToken%22%3A%22" + refreshToken + "%22%2C%22tokenType%22%3A%22Bearer%22%2C%22expiresIn%22%3A43200%2C%22sessionState%22%3A%22"
                + sessionState + "%22%2C%22scope%22%3A%22profile%20email%22%2C%22refreshExpiresIn%22%3A43200%2C%22expiresAt%22%3A1742523241274%2C%22refreshExpiresAt%22%3A1742523241274%7D";


        String body = "{\"values\":{\"password\":\"Mashinka_4709\",\"email\":\"dolnish9@gmail.com\"},\"token\":\"" + accessToken + "\"}";

        given()
                .body(body)
                .cookie("NEXT_CUSTOMER_TOKEN", nextcustomertoken)
                .cookie("_userGUID", "0:m8hgoqr0:RFHglk0gvfIP0hkydAXCCtVo5K6PhBXN")
                .log().all()
                .when()
                .post("https://4lapy.ru/api/auth/authByEmail/")
                .then()
                .log().all()
                .extract().body();
    }
}