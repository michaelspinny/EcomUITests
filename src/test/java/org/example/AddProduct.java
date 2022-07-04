package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddProduct {

    private static final String baseURl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static final By emailAddressFieldLocator = By.xpath("//*[@id='email']");
    private static final By passwordFieldLocator = By.xpath("//*[@id='passwd']");
    private static final By signInButtonLocator = By.xpath("//*[@id='SubmitLogin']/span");
    private static final By womenCategoryLocator = By.xpath("//li//a[@title='Women']");
    private static final By womenSubCategoryLocator = By.xpath("//li//a[@title='T-shirts']");
    private static final By productImageLocator = By.xpath("//img[@title='Faded Short Sleeve T-shirts']");
    private static final By addToCartButtonLocator = By.xpath("//div[@class='button-container']//a[@title='Add to cart']");
    private static final By itemAddedPopUpCloseButtonLocator = By.xpath("//span[@title='Close window']");
    private static final By shoppingCartIconLocator = By.xpath("//div[@class='shopping_cart']//a[@title='View my shopping cart']");
    private static final By shoppingCartTextLocator = By.xpath("//span[@class='heading-counter']");
    private static final String shoppingCartTextSample = "Your shopping cart contains";
    private static final String userLoginEmail = "lamontae.julius@moondoo.org";
    private static final String userLoginPassword = "Aa111111/";

    @Test
    public static void addProductToCart() {

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

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(shoppingCartTextLocator)));
        String shoppingCartTextValue = driver.findElement(shoppingCartTextLocator).getText();
        Assert.assertTrue(shoppingCartTextValue.contains(shoppingCartTextSample));

        driver.quit();

    }


}
