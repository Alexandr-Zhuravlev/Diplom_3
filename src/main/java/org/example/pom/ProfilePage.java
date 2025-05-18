package org.example.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    private By textProfilePage = By.xpath("//p[text() = 'В этом разделе вы можете изменить свои персональные данные']");
    private By logOutButton = By.xpath("//button[text() = 'Выход']");

    @Step("Проверка что текст на странице профиля виден")
    public ProfilePage textProfileTextVisibility(){
        driver.findElement(textProfilePage).isDisplayed();
        return this;
    }

    @Step("Нажатие на кнопку Выход")
    public ProfilePage logOutButtonClick(){
        driver.findElement(logOutButton).click();
        return this;
    }
}
