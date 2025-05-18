package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.config.AbstractUiBaseTest;
import org.example.pom.MainPage;
import org.junit.Test;

public class ConstructorTest extends AbstractUiBaseTest {

    @Test
    @DisplayName("Проверка что работает переход во вкладку Соусы")
    public void transitionsToSectionSause(){
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .maximizeWindow()
                .sauseTabConstructorClick()
                .sauseTabConstructorCheckActivity();
    }

    @Test
    @DisplayName("Проверка что работает переход во вкладку Начинка")
    public void transitionsToSectionFilling(){
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .maximizeWindow()
                .fillingTabConstructorClick()
                .fillingTabConstructorCheckActivity();
    }

    @Test
    @DisplayName("Проверка что работает переход во вкладку Булки")
    public void transitionsToSectionBun(){
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .maximizeWindow()
                .sauseTabConstructorClick()
                .bunTabConstructorClick()
                .bunTabConstructorCheckActivity();
    }
}
