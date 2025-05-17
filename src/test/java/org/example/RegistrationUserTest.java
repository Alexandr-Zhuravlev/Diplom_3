package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.example.config.AbstractUiBaseTest;
import org.example.generators.UserGenerator;
import org.example.models.UserCreds;
import org.example.models.UserDto;
import org.example.pom.LoginPage;
import org.example.pom.RegisterPage;
import org.junit.Test;

import static org.apache.http.HttpStatus.*;

public class RegistrationUserTest extends AbstractUiBaseTest {


    @Test
    @Description("Проверка успешной регистрации")
    public void registration(){
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        UserDto user = UserGenerator.randomUser();

        registerPage
                .open()
                .maximizeWindow()
                .nameInputSetText(user.getName())
                .emailInputSetText(user.getEmail())
                .passwordInputSetText(user.getPassword())
                .registerButtonClick();

        loginPage
                .loginButtonVisibility();
        //Проверка, что пользователь создан
        Response response = userSteps.login(UserCreds.builder()
                .email(user.getEmail()).password(user.getPassword()).build(), SC_OK);
        //Удаление созданного пользователя
        userSteps.delete(new Gson().fromJson(response.body().asString(), JsonObject.class).get("accessToken").getAsString(), SC_ACCEPTED);
    }

    @Test
    @Description("Проверка ошибки при не корректном пароле")
    public void registrationWithIncorrectPassword(){
        RegisterPage registerPage = new RegisterPage(driver);
        UserDto user = UserGenerator.randomUser().toBuilder().password("1234").build();

        registerPage
                .open()
                .maximizeWindow()
                .nameInputSetText(user.getName())
                .emailInputSetText(user.getEmail())
                .passwordInputSetText(user.getPassword())
                .registerButtonClick()
                .errorPasswordCheckVisibility();
    }
}
