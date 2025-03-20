package api;

import model.FavModel;

import static io.restassured.RestAssured.given;

public class AddToFav {

    public FavModel addtoFav(String token) {
        String body = "{\"skuId\": \"1063633\"}";
        return given()
                .body(body)
                .header("Authorization", "Bearer " + token)
                .log().all()
                .when()
                .post("https://api.4lapy.ru/api/v1/favourites/favourites")
                .then()
                .log().all()
                .extract().as(FavModel.class);
    }
}
