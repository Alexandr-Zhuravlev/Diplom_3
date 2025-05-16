package org.example.pom;

import org.openqa.selenium.By;

public class HeadPage {

    private By logoStellarBurgers = By.xpath("//div[@class = 'AppHeader_header__logo__2D0X2']//a[@href = '/']");
    private By personalAccountButton = By.xpath("//p[text() = 'Личный Кабинет']/..");
    private By orderFeedButton = By.xpath("//p[text() = 'Лента Заказов']/..");
    private By constructorButton = By.xpath("//p[text() = 'Конструктор']/..");
}