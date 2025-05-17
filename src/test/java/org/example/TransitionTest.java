package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.example.config.AbstractUiBaseTest;
import org.example.generators.UserGenerator;
import org.example.models.UserDto;
import org.example.pom.HeadPage;
import org.example.pom.MainPage;
import org.example.pom.ProfilePage;
import org.junit.Test;
import org.openqa.selenium.html5.WebStorage;

import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;

public class TransitionTest extends AbstractUiBaseTest {

    @Test
    @DisplayName("Проверка перехода по клику на Личный кабинет")
    public void transitionInProfileAccount(){
        MainPage mainPage = new MainPage(driver);
        HeadPage headPage = new HeadPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        UserDto user = UserGenerator.randomUser();
        Response response = userSteps.create(user, SC_OK);
        final String accessToken = new Gson().fromJson(response.body().asString(), JsonObject.class).get("accessToken").getAsString();

        mainPage
                .open()
                .maximizeWindow();

        ((WebStorage) driver).getLocalStorage().setItem("accessToken", accessToken);

        mainPage
                .open();
        headPage
                .personalAccountButtonClick();
        profilePage
                .textProfileTextVisibility();

        //Удаление созданного пользователя
        userSteps.delete(accessToken, SC_ACCEPTED);
    }

    @Test
    @DisplayName("Проверка перехода по клику на логотип Stellar Burgers")
    public void transitionFromProfileAccountToMainPageByClickLogo(){
        MainPage mainPage = new MainPage(driver);
        HeadPage headPage = new HeadPage(driver);

        UserDto user = UserGenerator.randomUser();
        Response response = userSteps.create(user, SC_OK);
        final String accessToken = new Gson().fromJson(response.body().asString(), JsonObject.class).get("accessToken").getAsString();

        mainPage
                .open()
                .maximizeWindow();

        ((WebStorage) driver).getLocalStorage().setItem("accessToken", accessToken);

        headPage
                .personalAccountButtonClick()
                .logoStellarBurgersClick();
        mainPage
                .placeAnOrderButtonVisibility();

        //Удаление созданного пользователя
        userSteps.delete(accessToken, SC_ACCEPTED);
    }

    @Test
    @DisplayName("Проверка перехода по клику на Конструктор")
    public void transitionFromProfileAccountToConstructor(){
        MainPage mainPage = new MainPage(driver);
        HeadPage headPage = new HeadPage(driver);

        UserDto user = UserGenerator.randomUser();
        Response response = userSteps.create(user, SC_OK);
        final String accessToken = new Gson().fromJson(response.body().asString(), JsonObject.class).get("accessToken").getAsString();

        mainPage
                .open()
                .maximizeWindow();

        ((WebStorage) driver).getLocalStorage().setItem("accessToken", accessToken);

        headPage
                .personalAccountButtonClick()
                .constructorButtonClick();
        mainPage
                .placeAnOrderButtonVisibility();

        //Удаление созданного пользователя
        userSteps.delete(accessToken, SC_ACCEPTED);
    }
}
