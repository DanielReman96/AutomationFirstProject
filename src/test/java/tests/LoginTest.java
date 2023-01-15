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
import pages.LoginPage;

public class LoginTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver109.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

    }
    @Test
    public void loginWithValidData(){

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("cosmin@fasttrackit.org");
        loginPage.setPasswordField("123456");
        loginPage.clickLoginButton();
        Assert.assertEquals("Hello, Cosmin Fast!",accountPage.getWelcomeText());
    }

    @Test
    public void loginWithValidName() throws InterruptedException {

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("remandaniel058@gmail.com");
        loginPage.setPasswordField("1230456");
        loginPage.clickLoginButton();
        Assert.assertEquals("Hello, Thomas Kirn Fahrner!",accountPage.getWelcomeText());

    }

    @Test
    public void loginWithInvalidData() throws InterruptedException {

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("remandaniel058@gmail.com");
        loginPage.setPasswordField("12304567");
        loginPage.clickLoginButton();
        Assert.assertEquals("Invalid login or password.", accountPage.getErrorWelcomeText());

    }

    @After
    public void quitDriver(){
        driver.quit();

    }








}
