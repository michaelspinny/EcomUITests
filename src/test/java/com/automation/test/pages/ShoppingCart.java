package com.automation.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ShoppingCart {
    private static final By shoppingCartTextLocator = By.xpath("//span[@class='heading-counter']");

    wait.until(ExpectedConditions.visibilityOf(driver.findElement(shoppingCartTextLocator)));
    String shoppingCartTextValue = driver.findElement(shoppingCartTextLocator).getText();
        Assert.assertTrue(shoppingCartTextValue.contains(shoppingCartTextSample));

        driver.quit();
}
