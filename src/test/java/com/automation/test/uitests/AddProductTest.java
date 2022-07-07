package com.automation.test.uitests;

import com.automation.test.pages.Login;
import com.automation.test.pages.ProductDetailsPage;
import com.automation.test.pages.ShoppingCart;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddProductTest {

    private static final String shoppingCartTextSample = "Your shopping cart contains";
    @Test
    public void addProductTest () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Login login = new Login(driver, wait);
        login.performLogin();
        ProductDetailsPage addProduct = new ProductDetailsPage(driver, wait);
        addProduct.addProductToCart();
        ShoppingCart cart = new ShoppingCart(driver, wait);
        cart.getShoppingCartText();
        Assert.assertTrue(cart.getShoppingCartText().contains(shoppingCartTextSample));
        driver.quit();

    }


}
