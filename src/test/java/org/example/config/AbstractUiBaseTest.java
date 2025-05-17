package org.example.config;

import org.example.steps.UserSteps;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.example.driver.WebDriverCreator.createWebDriver;

public abstract class AbstractUiBaseTest {

    protected WebDriver driver;
    protected UserSteps userSteps = new UserSteps();

    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
