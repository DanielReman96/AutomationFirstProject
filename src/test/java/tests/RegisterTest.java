package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.HomePage;

import java.sql.Driver;

public class RegisterTest {



    private WebDriver driver;

    private HomePage homePage;

    private AccountPage accountPage;
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver109.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);

    }


    @Test
    public void registerForNewUser() throws InterruptedException {

        homePage.clickAccountButton();
        accountPage.clickRegisterLink();
        accountPage.setFirstNameField("Thomass");
        accountPage.setLastNameField("Franko");
        accountPage.setEmailField("ThomasFranku@gmail.com");
        accountPage.setPasswordField("1230456");
        accountPage.setConfirmPasswordField("1230456");
        accountPage.clickRegisterButton();
        Assert.assertEquals("Thank you for registering with Madison Island.",homePage.getSuccessRegisterMessage() );

    }

    @After
    public void quitDriver(){

        driver.quit();

    }



}
