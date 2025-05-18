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
    private By activeTabBun = By.xpath("//div[contains(@class, 'tab_tab_type_current__')]/span[text() = 'Булки']");
    private By activeTabSause = By.xpath("//div[contains(@class, 'tab_tab_type_current__')]/span[text() = 'Соусы']");
    private By activeTabFilling = By.xpath("//div[contains(@class, 'tab_tab_type_current__')]/span[text() = 'Начинки']");
    private By placeAnOrderButton = By.xpath("//button[text() = 'Оформить заказ']");
    private By bunTabConstructor = By.xpath("//span[text() = 'Булки']/..");
    private By sauseTabConstructor = By.xpath("//span[text() = 'Соусы']/..");
    private By fillingTabConstructor = By.xpath("//span[text() = 'Начинки']/..");


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

    @Step("Кнопка Оформить заказ отображена")
    public MainPage placeAnOrderButtonVisibility(){
        driver.findElement(placeAnOrderButton).isDisplayed();
        return this;
    }

    @Step("Нажатие на вкладку Булки")
    public MainPage bunTabConstructorClick(){
        driver.findElement(bunTabConstructor).click();
        return this;
    }

    @Step("Проверка что вкладка Булки активна")
    public MainPage bunTabConstructorCheckActivity(){
        driver.findElement(activeTabBun).isDisplayed();
        return this;
    }

    @Step("Нажатие на вкладку Соусы")
    public MainPage sauseTabConstructorClick(){
        driver.findElement(sauseTabConstructor).click();
        return this;
    }

    @Step("Проверка что вкладка Соусы активна")
    public MainPage sauseTabConstructorCheckActivity(){
        driver.findElement(activeTabSause).isDisplayed();
        return this;
    }

    @Step("Нажатие на вкладку Начинки")
    public MainPage fillingTabConstructorClick(){
        driver.findElement(fillingTabConstructor).click();
        return this;
    }

    @Step("Проверка что вкладка Начинки активна")
    public MainPage fillingTabConstructorCheckActivity(){
        driver.findElement(activeTabFilling).isDisplayed();
        return this;
    }
}