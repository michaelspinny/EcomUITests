package com.automation.test.uitests;

import com.automation.test.pages.Login;
import com.automation.test.pages.MyAccount;
import com.automation.test.pages.PersonalInformation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccountUpdateTest {

    private static final String accountUpdateSuccessMessageSample = "Your personal information has been successfully updated.";
    @Test
    public void accountUpdateTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Login login = new Login(driver, wait);
        login.performLogin();
        MyAccount personalInformation = new MyAccount(driver, wait);
        personalInformation.openPersonalInformationPage();
        Actions action = new Actions(driver);
        PersonalInformation updateInfo = new PersonalInformation(driver, wait, action);
        updateInfo.updatePersonalInformation();
        MyAccount account = new MyAccount(driver, wait);
        Assert.assertTrue(account.getAccountUpdateText().contains(accountUpdateSuccessMessageSample));
        driver.quit();

    }

}
