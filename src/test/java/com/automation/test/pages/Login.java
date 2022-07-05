package com.automation.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {

    private static final String baseURl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static final By emailAddressFieldLocator = By.xpath("//*[@id='email']");
    private static final By passwordFieldLocator = By.xpath("//*[@id='passwd']");
    private static final By signInButtonLocator = By.xpath("//*[@id='SubmitLogin']/span");
    private static final By loggedInTextLocator = By.xpath("//div[@id='center_column']//p[@class='info-account']");
    private static final String userLoginEmail = "lamontae.julius@moondoo.org";
    private static final String userLoginPassword = "Aa111111/";
    private static final String loggedInTextSample = "Welcome to your account.";

    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public Login(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
    }

    public static void loginSuccessFlow() {
        driver.get(baseURl);
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailAddressFieldLocator)));
        driver.findElement(emailAddressFieldLocator).sendKeys(userLoginEmail);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(passwordFieldLocator)));
        driver.findElement(passwordFieldLocator).sendKeys(userLoginPassword);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(signInButtonLocator)));
        driver.findElement(signInButtonLocator).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loggedInTextLocator)));
        String loggedInTextValue = driver.findElement(loggedInTextLocator).getText();

        Assert.assertTrue(loggedInTextValue.contains(loggedInTextSample));

        driver.quit();
    }
}
