package com.automation.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SearchResults {

    private static final By searchBarLocator = By.xpath("//*[@id='search_query_top']");
    private static final By searchBarSubmit = By.xpath("//*[@id='searchbox']/button");
    private static final By searchSuccessTextLocator = By.xpath("//h1[@class='page-heading  product-listing']//span[@class='heading-counter']");
    private static final String productSearchQuery = "dress";
    private static final String searchSuccessTextSample = "results have been found";

    public static void performProductSearchFlow() {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchBarLocator)));
        driver.findElement(searchBarLocator).sendKeys(productSearchQuery);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchBarSubmit)));
        driver.findElement(searchBarSubmit).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchSuccessTextLocator)));
        String searchSuccessTextValue = driver.findElement(searchSuccessTextLocator).getText();

        Assert.assertTrue(searchSuccessTextValue.contains(searchSuccessTextSample));

        driver.quit();
    }
}
