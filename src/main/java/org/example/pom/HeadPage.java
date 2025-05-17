package org.example.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeadPage {

    private WebDriver driver;

    public HeadPage(WebDriver driver){
        this.driver = driver;
    }

    private By logoStellarBurgers = By.xpath("//div[@class = 'AppHeader_header__logo__2D0X2']//a[@href = '/']");
    private By personalAccountButton = By.xpath("//p[text() = 'Личный Кабинет']/..");
    private By constructorButton = By.xpath("//p[text() = 'Конструктор']/..");

    @Step("Нажатие на кнопку Личный кабинет")
    public HeadPage personalAccountButtonClick(){
        driver.findElement(personalAccountButton).click();
        return this;
    }

    @Step("Нажатие логотип Stellar Burger")
    public HeadPage logoStellarBurgersClick(){
        driver.findElement(logoStellarBurgers).click();
        return this;
    }

    @Step("Нажатие на кнопку Конструктор")
    public HeadPage constructorButtonClick(){
        driver.findElement(constructorButton).click();
        return this;
    }
}