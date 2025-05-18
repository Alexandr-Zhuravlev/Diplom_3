package org.example.generators;

import org.example.models.UserDto;

import static org.example.utils.Utils.randomString;

public class UserGenerator {

    private static final String MAIL_DOMAIN = "@yandex.ru";

    public static UserDto randomUser() {
        return UserDto.builder()
                .email(randomString() + MAIL_DOMAIN)
                .password(randomString())
                .name(randomString()).build();
    }
}