package org.example.pom;

import io.qameta.allure.Step;
import org.example.config.TestProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    private By nameInput = By.xpath("//label[text() = 'Имя']/../input");
    private By emailInput = By.xpath("//label[text() = 'Email']/../input");
    private By passwordInput = By.xpath("//input[@name = 'Пароль']");
    private By registerButton = By.xpath("//button[text() = 'Зарегистрироваться']");
    private By loginLink = By.xpath("//a[text() = 'Войти']");
    private By errorPassword = By.xpath("//p[text() = 'Некорректный пароль']");

    @Step("Открытие браузера на странице регистрации")
    public RegisterPage open(){
        driver.get(TestProperties.BASE_URL + TestProperties.PATH_REGISTER);
        return this;
    }

    @Step("Разворачивание окна в максимальный размер")
    public RegisterPage maximizeWindow(){
        driver.manage().window().maximize();
        return this;
    }

    @Step("Ввод имени в поле регистрации")
    public RegisterPage nameInputSetText(String text){
        driver.findElement(nameInput).sendKeys(text);
        return this;
    }

    @Step("Ввод почты в поле регистрации")
    public RegisterPage emailInputSetText(String text){
        driver.findElement(emailInput).sendKeys(text);
        return this;
    }

    @Step("Ввод пароля в поле регистрации")
    public RegisterPage passwordInputSetText(String text){
        driver.findElement(passwordInput).sendKeys(text);
        return this;
    }

    @Step("Нажатие на кнопку Зарегистрироваться")
    public RegisterPage registerButtonClick(){
        driver.findElement(registerButton).click();
        return this;
    }

    @Step("Нажатие на ссылку Войти")
    public RegisterPage loginLinkClick(){
        driver.findElement(loginLink).click();
        return this;
    }

    @Step("Проверка ошибки Некорректный пароль")
    public RegisterPage errorPasswordCheckVisibility(){
        driver.findElement(errorPassword).isDisplayed();
        return this;
    }
}