package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.example.driver.WebDriverCreator.createWebDriver;

public class OpenLoginTest {

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = createWebDriver();
    }

    @Test
    public void test() {
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
