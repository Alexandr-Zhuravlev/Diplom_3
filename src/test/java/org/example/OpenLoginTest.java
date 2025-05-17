package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.example.config.AbstractUiBaseTest;
import org.example.generators.UserGenerator;
import org.example.models.UserDto;
import org.example.pom.*;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;


public class OpenLoginTest extends AbstractUiBaseTest {

    @Test
    @Description("Проверка входа по кнопке Войти в аккаунт на главной странице")
    public void loginTheLoginToAccountButton(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        UserDto user = UserGenerator.randomUser();

        Response response = userSteps.create(user, SC_OK);

        mainPage
                .open()
                .maximizeWindow()
                .loginToAccountClick();
        loginPage
                .emailInputSetText(user.getEmail())
                .passwordInputSetText(user.getPassword())
                .loginButtonClick();
        mainPage
                .placeAnOrderButtonVisibility();

        //Удаление созданного пользователя
        userSteps.delete(new Gson().fromJson(response.body().asString(), JsonObject.class).get("accessToken").getAsString(), SC_ACCEPTED);
    }

    @Test
    @Description("Проверка входа через кнопку Личный кабинет")
    public void loginThePersonalAccountButton(){
        HeadPage headPage = new HeadPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        UserDto user = UserGenerator.randomUser();

        Response response = userSteps.create(user, SC_OK);

        mainPage
                .open()
                .maximizeWindow();
        headPage
                .personalAccountButtonClick();
        loginPage
                .emailInputSetText(user.getEmail())
                .passwordInputSetText(user.getPassword())
                .loginButtonClick();
        mainPage
                .placeAnOrderButtonVisibility();

        //Удаление созданного пользователя
        userSteps.delete(new Gson().fromJson(response.body().asString(), JsonObject.class).get("accessToken").getAsString(), SC_ACCEPTED);
    }

    @Test
    @Description("Проверка входа через кнопку в форме регистрации")
    public void loginLinkInRegistrationPage(){
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        UserDto user = UserGenerator.randomUser();

        Response response = userSteps.create(user, SC_OK);

        registerPage
                .open()
                .maximizeWindow()
                .loginLinkClick();
        loginPage
                .emailInputSetText(user.getEmail())
                .passwordInputSetText(user.getPassword())
                .loginButtonClick();
        mainPage
                .placeAnOrderButtonVisibility();

        //Удаление созданного пользователя
        userSteps.delete(new Gson().fromJson(response.body().asString(), JsonObject.class).get("accessToken").getAsString(), SC_ACCEPTED);
    }

    @Test
    @Description("Проверка входа через кнопку в форме восстановления пароля")
    public void loginLinkInForgotPasswordPage(){
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        UserDto user = UserGenerator.randomUser();

        Response response = userSteps.create(user, SC_OK);

        forgotPasswordPage
                .open()
                .maximizeWindow()
                .loginLinkClick();
        loginPage
                .emailInputSetText(user.getEmail())
                .passwordInputSetText(user.getPassword())
                .loginButtonClick();
        mainPage
                .placeAnOrderButtonVisibility();

        //Удаление созданного пользователя
        userSteps.delete(new Gson().fromJson(response.body().asString(), JsonObject.class).get("accessToken").getAsString(), SC_ACCEPTED);
    }
}
