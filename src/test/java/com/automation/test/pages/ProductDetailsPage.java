package com.automation.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {

    private static final By womenCategoryLocator = By.xpath("//li//a[@title='Women']");
    private static final By womenSubCategoryLocator = By.xpath("//li//a[@title='T-shirts']");
    private static final By productImageLocator = By.xpath("//img[@title='Faded Short Sleeve T-shirts']");
    private static final By addToCartButtonLocator = By.xpath("//div[@class='button-container']//a[@title='Add to cart']");
    private static final By itemAddedPopUpCloseButtonLocator = By.xpath("//span[@title='Close window']");
    private static final By shoppingCartIconLocator = By.xpath("//div[@class='shopping_cart']//a[@title='View my shopping cart']");

    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public ProductDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void addProductToCart() {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(womenCategoryLocator)));
        Actions hoverOverCategory = new Actions(driver);
        hoverOverCategory.moveToElement(driver.findElement(womenCategoryLocator)).perform();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(womenSubCategoryLocator)));
        Actions hoverOverSubcategory = new Actions(driver);
        hoverOverSubcategory.moveToElement(driver.findElement(womenSubCategoryLocator)).perform();
        driver.findElement(womenSubCategoryLocator).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(productImageLocator)));
        Actions hoverOverProductImage = new Actions(driver);
        hoverOverProductImage.moveToElement(driver.findElement(productImageLocator)).perform();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(addToCartButtonLocator)));
        Actions scrollToAddCartButton = new Actions(driver);
        scrollToAddCartButton.scrollToElement(driver.findElement(addToCartButtonLocator)).perform();
        driver.findElement(addToCartButtonLocator).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(itemAddedPopUpCloseButtonLocator)));
        driver.findElement(itemAddedPopUpCloseButtonLocator).click();

        Actions scrollUpToShoppingCart = new Actions(driver);
        scrollUpToShoppingCart.scrollToElement(driver.findElement(shoppingCartIconLocator)).perform();

        driver.findElement(shoppingCartIconLocator).click();
    }
}