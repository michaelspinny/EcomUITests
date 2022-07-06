package com.automation.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ShoppingCart {
    private final By shoppingCartTextLocator = By.xpath("//span[@class='heading-counter']");
    WebDriver driver;
    Wait wait;

    public String getShoppingCartText() {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(shoppingCartTextLocator)));
        String shoppingCartTextValue = driver.findElement(shoppingCartTextLocator).getText();
        return shoppingCartTextValue;
    }

}
