package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.WishlistPage;

public class WishListTest {

    private WebDriver driver;
    private HomePage homePage;

    private LoginPage loginPage;
    private WishlistPage wishlistPage;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver109.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        wishlistPage = new WishlistPage(driver);


    }


        @Test
        public  void addToWishListTest () {


            homePage.clickAccountButton();
            homePage.clickLoginLink();
            loginPage.setEmailField("remandaniel058@gmail.com");
            loginPage.setPasswordField("1230456");
            loginPage.clickLoginButton();
            homePage.clickVipButton();
            homePage.clickAddToWishlistLink();
            Assert.assertEquals("Lexington Cardigan Sweater has been added to your wishlist. Click here to continue shopping.",wishlistPage.getSuccessMessage() );
        }




    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @After
    public void quitDriver(){

        driver.quit();

    }


}
