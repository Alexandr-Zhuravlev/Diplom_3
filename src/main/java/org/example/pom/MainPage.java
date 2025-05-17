package org.example.pom;

import io.qameta.allure.Step;
import org.example.config.TestProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By loginToAccountButton = By.xpath("//button[text() = 'Войти в аккаунт']");
    private By checkActiveTabConstructor = By.xpath("//div[contains(@class, 'tab_tab_type_current__')]/span");
    private By placeAnOrderButton = By.xpath("//button[text() = 'Оформить заказ']");

    @Step("Открытие браузера на главной странице")
    public MainPage open(){
        driver.get(TestProperties.BASE_URL);
        return this;
    }

    @Step("Разворачивание окна в максимальный размер")
    public MainPage maximizeWindow(){
        driver.manage().window().maximize();
        return this;
    }

    @Step("Нажатие на кнопку Войти в аккаунт")
    public MainPage loginToAccountClick(){
        driver.findElement(loginToAccountButton).click();
        return this;
    }

    @Step("Нажатие на кнопку Войти в аккаунт")
    public MainPage placeAnOrderButtonVisibility(){
        driver.findElement(placeAnOrderButton).isDisplayed();
        return this;
    }
}