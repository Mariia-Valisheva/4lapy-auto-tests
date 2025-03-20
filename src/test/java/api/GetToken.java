package api;


import model.Token;

import static io.restassured.RestAssured.given;

public class GetToken {
    public Token ResponseToken() {
        return  given()
                .post("https://api.4lapy.ru/api/v1/users/customer/auth")
                .then()
                .log().all()
                .extract().as(Token.class);
    }
}