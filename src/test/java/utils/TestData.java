package utils;

import com.github.javafaker.Faker;
import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

public class TestData {
    Faker faker = new Faker();
    private final CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class, System.getProperties());
    public String
            keyWord = faker.options().option("лежанка", "поводок", "туалет", "корм"),
            searchWord = faker.options().option("Сухой корм", "Игрушки интерактивные", "Для лысых"),
            chooseCity = faker.options().option("Казань", "Кемерово", "Краснодар"),
            phoneNumberPrefix = faker.number().digits(3),
            phoneNumberThreeDigits = faker.number().digits(3),
            phoneNumberTwoDigits1 = faker.number().digits(2),
            phoneNumberTwoDigits2 = faker.number().digits(2),
            skuId = "1063633";


    public String
            accessTokenVar = "%7B%22accessToken%22%3A%22",
            refreshTokenVar = "%22%2C%22refreshToken%22%3A%22",
            tokenTypeVar = "%22%2C%22tokenType%22%3A%22",
            expiresVar = "%22%2C%22expiresIn%22%3A",
            sessionVar = "%2C%22sessionState%22%3A%22",
            scopeVar = "%22%2C%22scope%22%3A%22profile%20email",
            refreshExpInVar = "%22%2C%22refreshExpiresIn%22%3A",
            expAtVar = "%2C%22expiresAt%22%3A1742523241274",
            refreshExpAtVar = "%2C%22refreshExpiresAt%22%3A1742523241274%7D";


    public int
            offerAmount = Integer.parseInt(String.valueOf(faker.number().numberBetween(1, 9)));

    public String getEmail() {
        boolean isRemote = Boolean.parseBoolean(System.getProperty("isRemote", "false"));
        String lapyEmail;
        if(isRemote) {
            lapyEmail = System.getProperty("lapyEmail");
        }
        else {
            lapyEmail = credentialsConfig.lapyEmail();
        }
        return lapyEmail;
    }

    public String getPassword() {
        boolean isRemote = Boolean.parseBoolean(System.getProperty("isRemote", "false"));
        String lapyPass;
        if(isRemote) {
            lapyPass = System.getProperty("lapyPass");
        }
        else {
            lapyPass = credentialsConfig.lapyPass();
        }
        return lapyPass;
    }
}
