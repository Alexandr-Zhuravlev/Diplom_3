package org.example.pom;

import org.openqa.selenium.By;

public class LoginPage {

    private By emailInput = By.xpath("//label[text() = 'Email']/../input");
    private By passwordInput = By.xpath("//input[@name = 'Пароль']");
    private By loginButton = By.xpath("//button[text() = 'Войти']");
    private By registerLink = By.xpath("//a[text() = 'Зарегистрироваться']");
    private By forgotPasswordLink = By.xpath("//a[text() = 'Восстановить пароль']");
}