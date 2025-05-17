package org.example.pom;

import io.qameta.allure.Step;
import org.example.config.TestProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    private By textProfilePage = By.xpath("//p[text() = 'В этом разделе вы можете изменить свои персональные данные']");

    @Step("Проверка что текст на странице профиля виден")
    public ProfilePage textProfileTextVisibility(){
        driver.findElement(textProfilePage).isDisplayed();
        return this;
    }

    @Step("Открытие браузера в личном кабинете")
    public ProfilePage open(){
        driver.get(TestProperties.BASE_URL + TestProperties.PATH_ACCOUNT_PROFILE);
        return this;
    }

    @Step("Разворачивание окна в максимальный размер")
    public ProfilePage maximizeWindow(){
        driver.manage().window().maximize();
        return this;
    }
}
