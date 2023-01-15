package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class CartTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private WishlistPage wishlistPage;
    private CartPage cartPage;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver109.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        wishlistPage = new WishlistPage(driver);
        cartPage = new CartPage(driver);

    }

    @Test
    public void addToCart() throws InterruptedException {

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("remandaniel058@gmail.com");
        loginPage.setPasswordField("1230456");
        loginPage.clickLoginButton();

        homePage.clickVipButton();
        homePage.clickAddToWishlistLink();
        wishlistPage.clickAddToCartButton();
        wishlistPage.clickColorOptionLink();
        wishlistPage.clickSizeOptionLink();
        wishlistPage.setQuantityField("3");
        Assert.assertEquals("Lexington Cardigan Sweater was added to your shopping cart.",cartPage.getSuccesMessage());


    }

    @Test
    public void deleteFromCart() throws InterruptedException {

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("remandaniel058@gmail.com");
        loginPage.setPasswordField("1230456");
        loginPage.clickLoginButton();
        homePage.clickAccountButton();
        homePage.clickMyCartLink();
        cartPage.clickRemoveButton();
        Assert.assertEquals("SHOPPING CART IS EMPTY",cartPage.getDeleteMessage() );

    }

    @After
    public void quitDriver(){

        driver.quit();

    }



}
