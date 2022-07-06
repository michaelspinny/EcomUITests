package com.automation.test.uitests;

import com.automation.test.pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginSuccessTest {

    private static final String loggedInTextSample = "Welcome to your account.";
    @Test
    public void loginSuccessTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Login login = new Login(driver, wait);
        login.performLogin();
        Assert.assertTrue(login.getLoggedInText().contains(loggedInTextSample));
        driver.quit();
    }




}
