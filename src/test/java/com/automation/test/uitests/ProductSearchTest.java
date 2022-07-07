package com.automation.test.uitests;

import com.automation.test.pages.Login;
import com.automation.test.pages.SearchResults;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductSearchTest {

    private static final String searchSuccessTextSample = "results have been found";
    @Test
    public void productSearchTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Login login = new Login(driver, wait);
        login.performLogin();
        SearchResults results = new SearchResults(driver, wait);
        results.performProductSearch();
        Assert.assertTrue(results.getSearchResultsTextValue().contains(searchSuccessTextSample));
        driver.quit();
    }
}
