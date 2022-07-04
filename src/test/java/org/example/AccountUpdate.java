package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccountUpdate {
    private static final String baseURl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static final By emailAddressFieldLocator = By.xpath("//*[@id='email']");
    private static final By passwordFieldLocator = By.xpath("//*[@id='passwd']");
    private static final By signInButtonLocator = By.xpath("//*[@id='SubmitLogin']/span");
    private static final By personalInformationButtonLocator = By.xpath("//a[@title='Information']");
    private static final By birthMonthLocatorDropdown = By.xpath("//div[@class='selector']");
    private static final By birthMonthLocatorValue = By.xpath("//select[@id='months']//option[@value='7']");
    private static final By currentPasswordLocator = By.xpath("//input[@type='password']");
    private static final By saveButtonLocator = By.xpath("//button[@name='submitIdentity']");
    private static final By accountUpdateSuccessMessage = By.xpath("//p[@class='alert alert-success']");
    private static final String userLoginEmail = "lamontae.julius@moondoo.org";
    private static final String userLoginPassword = "Aa111111/";
    private static final String accountUpdateSuccessMessageSample = "Your personal information has been successfully updated.";

    @Test
    public static void accountBirthMonthUpdate() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get(baseURl);
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailAddressFieldLocator)));
        driver.findElement(emailAddressFieldLocator).sendKeys(userLoginEmail);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(passwordFieldLocator)));
        driver.findElement(passwordFieldLocator).sendKeys(userLoginPassword);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(signInButtonLocator)));
        driver.findElement(signInButtonLocator).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(personalInformationButtonLocator)));
        driver.findElement(personalInformationButtonLocator).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(birthMonthLocatorDropdown)));
        driver.findElement(birthMonthLocatorDropdown).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(birthMonthLocatorValue)));
        driver.findElement(birthMonthLocatorValue).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(currentPasswordLocator)));
        driver.findElement(currentPasswordLocator).sendKeys(userLoginPassword);

        Actions scrollToSaveButton = new Actions(driver);
        scrollToSaveButton.moveToElement(driver.findElement(saveButtonLocator));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(saveButtonLocator)));
        driver.findElement(saveButtonLocator).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(accountUpdateSuccessMessage)));
        String accountUpdateMessageValue = driver.findElement(accountUpdateSuccessMessage).getText();
        Assert.assertTrue(accountUpdateMessageValue.contains(accountUpdateSuccessMessageSample));

        driver.quit();

    }
}
