package org.example.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.config.TestProperties;
import org.example.models.UserCreds;
import org.example.models.UserDto;

import static io.restassured.RestAssured.given;

public class UserSteps {


    private static final String API_USER_CREATE = "/api/auth/register";
    private static final String API_USER_LOGIN = "/api/auth/login";
    private static final String API_USER_PATCH_OR_DELETE = "/api/auth/user";

    @Step("Создание учетной записи пользователя")
    public Response create(UserDto userDto, int statusCode) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .baseUri(TestProperties.BASE_URL)
                .body(userDto)
                .when()
                .post(API_USER_CREATE)
                .then()
                .assertThat().statusCode(statusCode)
                .extract()
                .response();
    }

    @Step("Авторизация пользователя с логином и паролем")
    public Response login(UserCreds userCreds, int statusCode) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .baseUri(TestProperties.BASE_URL)
                .body(userCreds)
                .when()
                .post(API_USER_LOGIN)
                .then()
                .assertThat().statusCode(statusCode)
                .extract()
                .response();
    }

    @Step("Удаление учетной записи пользователя")
    public Response delete(String accessToken, int statusCode) {
        return given()
                .headers(
                        "Content-type", "application/json",
                        "Authorization", accessToken)
                .baseUri(TestProperties.BASE_URL)
                .when()
                .delete(API_USER_PATCH_OR_DELETE)
                .then()
                .assertThat().statusCode(statusCode)
                .extract()
                .response();
    }
}