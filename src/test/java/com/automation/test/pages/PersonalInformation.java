package com.automation.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalInformation {
    private static final By birthMonthLocatorDropdown = By.xpath("//div[@class='selector']");
    private static final By birthMonthLocatorValue = By.xpath("//select[@id='months']//option[@value='7']");
    private static final By currentPasswordLocator = By.xpath("//input[@type='password']");
    private static final By saveButtonLocator = By.xpath("//button[@name='submitIdentity']");
    private static final String userLoginPassword = "Aa111111/";

    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public PersonalInformation(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
    }

    public void updatePersonalInformation() {
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
    }
}
