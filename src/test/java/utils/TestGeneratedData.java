package utils;

import com.github.javafaker.Faker;

public class TestGeneratedData {
    Faker faker = new Faker();
    public String
            keyWord = faker.options().option("лежанка", "поводок", "туалет", "корм"),
            searchWord = faker.options().option("Сухой корм", "Игрушки интерактивные", "Для лысых"),
            chooseCity = faker.options().option("Казань", "Кемерово", "Краснодар"),
            phoneNumberPrefix = faker.number().digits(3),
            phoneNumberThreeDigits = faker.number().digits(3),
            phoneNumberTwoDigits1 = faker.number().digits(2),
            phoneNumberTwoDigits2 = faker.number().digits(2);
}
