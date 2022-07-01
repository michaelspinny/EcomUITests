package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Search {

    private static final String baseURl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static final By emailAddressFieldLocator = By.xpath("//*[@id='email']");
    private static final By passwordFieldLocator = By.xpath("//*[@id='passwd']");
    private static final By signInButtonLocator = By.xpath("//*[@id='SubmitLogin']/span");
    private static final By searchBarLocator = By.xpath("//*[@id='search_query_top']");
    private static final By searchBarSubmit = By.xpath("//*[@id='searchbox']/button");
    private static final By searchResultsLocator = By.xpath("//*[@id='center_column']/h1/span[1]");


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
        driver.findElement(emailAddressFieldLocator).sendKeys("lamontae.julius@moondoo.org");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(passwordFieldLocator)));
        driver.findElement(passwordFieldLocator).sendKeys("Aa111111/");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(signInButtonLocator)));
        driver.findElement(signInButtonLocator).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchBarLocator)));
        driver.findElement(searchBarLocator).sendKeys("dress");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchBarSubmit)));
        driver.findElement(searchBarSubmit).click();

        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(searchResultsLocator), "SEARCH \"DRESS\" "));

    }

}
