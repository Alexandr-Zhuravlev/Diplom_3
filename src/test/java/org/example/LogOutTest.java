package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.example.config.AbstractUiBaseTest;
import org.example.generators.UserGenerator;
import org.example.models.UserDto;
import org.example.pom.HeadPage;
import org.example.pom.LoginPage;
import org.example.pom.MainPage;
import org.example.pom.ProfilePage;
import org.junit.Test;
import org.openqa.selenium.html5.WebStorage;

import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;

public class LogOutTest extends AbstractUiBaseTest {

    String accessToken;

    @Override
    public void tearDown() {
        super.tearDown();

        //Удаление созданного пользователя
        if(accessToken != null){
            userSteps.delete(accessToken, SC_ACCEPTED);
        }
    }

    @Test
    @DisplayName("Проверка выхода по кнопке Выйти в личном кабинете")
    public void transitionInProfileAccount(){
        MainPage mainPage = new MainPage(driver);
        HeadPage headPage = new HeadPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        UserDto user = UserGenerator.randomUser();
        Response response = userSteps.create(user, SC_OK);
        accessToken = new Gson().fromJson(response.body().asString(), JsonObject.class).get("accessToken").getAsString();
        final String refreshToken = new Gson().fromJson(response.body().asString(), JsonObject.class).get("refreshToken").getAsString();

        mainPage
                .open()
                .maximizeWindow();

        ((WebStorage) driver).getLocalStorage().setItem("accessToken", accessToken);
        ((WebStorage) driver).getLocalStorage().setItem("refreshToken", refreshToken);

        headPage
                .personalAccountButtonClick();
        profilePage
                .logOutButtonClick();
        loginPage
                .loginButtonVisibility();
    }
}
