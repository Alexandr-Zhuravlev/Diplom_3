package org.example;

import jdk.jfr.Description;
import org.example.config.AbstractUiBaseTest;
import org.example.pom.MainPage;
import org.junit.Test;

public class ConstructorTest extends AbstractUiBaseTest {

    @Test
    @Description("Проверка что работают переходы по разделам в конструкторе")
    public void transitionsToSectionsConstructor(){
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .maximizeWindow()
                .sauseTabConstructorClickAndCheck()
                .fillingTabConstructorClickAndCheck()
                .bunTabConstructorClickAndCheck();
    }
}
