package org.example.pom;

import io.qameta.allure.Step;
import org.example.config.TestProperties;
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
    private By registerLink = By.xpath("//a[text() = 'Зарегистрироваться']");
    private By forgotPasswordLink = By.xpath("//a[text() = 'Восстановить пароль']");

    @Step("Открытие браузера на странице авторизации")
    public LoginPage open(){
        driver.get(TestProperties.BASE_URL + TestProperties.PATH_LOGIN);
        return this;
    }

    @Step("Разворачивание окна в максимальный размер")
    public LoginPage maximizeWindow(){
        driver.manage().window().maximize();
        return this;
    }

    public LoginPage emailInputSetText(String text){
        driver.findElement(emailInput).sendKeys(text);
        return this;
    }

    public LoginPage passwordInputSetText(String text){
        driver.findElement(passwordInput).sendKeys(text);
        return this;
    }

    public LoginPage loginButtonClick(){
        driver.findElement(loginButton).click();
        return this;
    }

    public LoginPage registerLinkClick(){
        driver.findElement(registerLink).click();
        return this;
    }

    public LoginPage forgotPasswordLinkClick(){
        driver.findElement(forgotPasswordLink).click();
        return this;
    }
}