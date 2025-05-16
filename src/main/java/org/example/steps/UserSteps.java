package org.example.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.models.UserDto;

import static io.restassured.RestAssured.given;

public class UserSteps {

    private static final String API_USER_CREATE = "/api/auth/register";

    @Step("Создание учетной записи пользователя")
    public Response create(UserDto userDto, int statusCode) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userDto)
                .when()
                .post(API_USER_CREATE)
                .then()
                .assertThat().statusCode(statusCode)
                .extract()
                .response();
    }
}