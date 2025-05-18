package org.example.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By emailInput = By.xpath("//label[text() = 'Email']/../input");
    private By passwordInput = By.xpath("//input[@name = 'Пароль']");
    private By loginButton = By.xpath("//button[text() = 'Войти']");


    @Step("Ввод email в поле авторизации")
    public LoginPage emailInputSetText(String text){
        driver.findElement(emailInput).sendKeys(text);
        return this;
    }

    @Step("Ввод пароля в поле авторизации")
    public LoginPage passwordInputSetText(String text){
        driver.findElement(passwordInput).sendKeys(text);
        return this;
    }

    @Step("Нажатие на кнопку Войти")
    public LoginPage loginButtonClick(){
        driver.findElement(loginButton).click();
        return this;
    }

    @Step("Проверка что кнопка Войти отображается")
    public LoginPage loginButtonVisibility(){
        driver.findElement(loginButton).isDisplayed();
        return this;
    }
}