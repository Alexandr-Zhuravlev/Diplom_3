package org.example.pom;

import io.qameta.allure.Step;
import org.example.config.TestProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    private By emailInput = By.xpath("//label[text() = 'Email']/..//input[@name = 'name']");
    private By recoverButton = By.xpath("//button[text() = 'Восстановить']");
    private By loginLink = By.xpath("//a[text() = 'Войти']");

    @Step("Открытие браузера на странице восстановления пароля")
    public ForgotPasswordPage open(){
        driver.get(TestProperties.BASE_URL + TestProperties.PATH_FORGOT_PASSWORD);
        return this;
    }

    @Step("Разворачивание окна в максимальный размер")
    public ForgotPasswordPage maximizeWindow(){
        driver.manage().window().maximize();
        return this;
    }

    public ForgotPasswordPage emailInputSetText(String text){
        driver.findElement(emailInput).sendKeys(text);
        return this;
    }

    public ForgotPasswordPage recoverButtonClick(){
        driver.findElement(recoverButton).click();
        return this;
    }

    public ForgotPasswordPage loginLinkClick(){
        driver.findElement(loginLink).click();
        return this;
    }
}