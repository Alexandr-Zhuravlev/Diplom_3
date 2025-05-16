package org.example.pom;

import org.openqa.selenium.By;

public class RegisterPage {

    private By nameInput = By.xpath("//label[text() = 'Имя']/../input");
    private By emailInput = By.xpath("//label[text() = 'Email']/../input");
    private By passwordInput = By.xpath("//input[@name = 'Пароль']");
    private By registerButton = By.xpath("//button[text() = 'Зарегистрироваться']");
    private By loginLink = By.xpath("//a[text() = 'Войти']");
}