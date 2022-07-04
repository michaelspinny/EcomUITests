package org.example;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Search {

    private static final String baseURl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static final String searchURL = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
    private static final By emailAddressFieldLocator = By.xpath("//*[@id='email']");
    private static final By passwordFieldLocator = By.xpath("//*[@id='passwd']");
    private static final By signInButtonLocator = By.xpath("//*[@id='SubmitLogin']/span");
    private static final By searchBarLocator = By.xpath("//*[@id='search_query_top']");
    private static final By searchBarSubmit = By.xpath("//*[@id='searchbox']/button");
    private static final String userLoginEmail = "lamontae.julius@moondoo.org";
    private static final String userLoginPassword = "Aa111111/";
    private static final String productSearchQuery = "dress";


    public static void main(String[] args) {
        searchTest();
    }

    public static void searchTest() {

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

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchBarLocator)));
        driver.findElement(searchBarLocator).sendKeys(productSearchQuery);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchBarSubmit)));
        driver.findElement(searchBarSubmit).click();

        String url = driver.getCurrentUrl();

        if (url.equals(searchURL)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Text Failed");
        }
        driver.quit();

    }

}
