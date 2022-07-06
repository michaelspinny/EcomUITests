package com.automation.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyAccount {

    private static final By personalInformationButtonLocator = By.xpath("//a[@title='Information']");
    private static final By accountUpdateSuccessMessage = By.xpath("//p[@class='alert alert-success']");
    private static final String accountUpdateSuccessMessageSample = "Your personal information has been successfully updated.";
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public void navigateToPersonalInformationFlow() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(personalInformationButtonLocator)));
        driver.findElement(personalInformationButtonLocator).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(accountUpdateSuccessMessage)));
        String accountUpdateMessageValue = driver.findElement(accountUpdateSuccessMessage).getText();
        Assert.assertTrue(accountUpdateMessageValue.contains(accountUpdateSuccessMessageSample));

        driver.quit();
    }
}
