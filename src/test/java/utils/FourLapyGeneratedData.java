package utils;

import com.github.javafaker.Faker;

public class FourLapyGeneratedData {
    Faker faker = new Faker();
    public String
            keyWord = faker.options().option("лежанка", "поводок", "туалет", "корм"),
            phoneNumberPrefix = faker.number().digits(3),
            phoneNumberThreeDigits = faker.number().digits(3),
            phoneNumberTwoDigits1 = faker.number().digits(2),
            phoneNumberTwoDigits2 = faker.number().digits(2);
}
