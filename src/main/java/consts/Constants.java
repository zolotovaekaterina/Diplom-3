package consts;

import com.github.javafaker.Faker;

public class Constants {

    static Faker faker = new Faker();
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    public static final String email = faker.name().firstName()+"@ya.ru";
    public static final String password = faker.name().lastName()+"password";
    public static final String wrongPassword = "12345";
    public static final String name = faker.name().username();
    public static final String staticEmail = "yayandex@yandex.ru";
    public static final String staticPassword = "Yayapass1";
}
