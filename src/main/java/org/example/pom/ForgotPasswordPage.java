package org.example.pom;

import org.openqa.selenium.By;

public class ForgotPasswordPage {

    private By emailInput = By.xpath("//label[text() = 'Email']/..//input[@name = 'name']");
    private By recoverButton = By.xpath("//button[text() = 'Восстановить']");
    private By loginLink = By.xpath("//a[text() = 'Войти']");
}