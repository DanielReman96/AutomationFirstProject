import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {

    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }


        @Test
        public  void addToWishListTest () {

            driver.findElement(By.cssSelector(".skip-account .label")).click();
            driver.findElement(By.cssSelector("[title~=Log]")).click();
            driver.findElement(By.cssSelector("#email")).sendKeys("remandaniel058@gmail.com");
            driver.findElement(By.cssSelector("#pass")).sendKeys("1230456");
            driver.findElement(By.cssSelector("#send2")).click();
            driver.findElement(By.cssSelector(".nav-5 .level0")).click();
            driver.findElement(By.cssSelector("li:first-child .add-to-links .link-wishlist")).click();

            WebElement wishlistMessage = driver.findElement(By.cssSelector(".my-wishlist li:first-child"));
            String actualResult = wishlistMessage.getText();
            String expectedResult = "Slim fit Dobby Oxford Shirt has been added to your wishlist. Click here to continue shopping.";
            Assert.assertEquals(expectedResult,actualResult);
        }

//        @Test
//        public void deleteItemFromWishlist() throws InterruptedException {
//
//            driver.findElement(By.cssSelector(".skip-account .label")).click();
//            driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(2) > a")).click();
//            driver.findElement(By.cssSelector("#email")).sendKeys("remandaniel058@gmail.com");
//            driver.findElement(By.cssSelector("#pass")).sendKeys("1230456");
//            driver.findElement(By.name("send")).click();
//            driver.findElement(By.cssSelector("#item_1239 > td.wishlist-cell5.customer-wishlist-item-remove.last > a")).click();
//            driver.findElement(By.cssSelector("#item_1240 > td.wishlist-cell5.customer-wishlist-item-remove.last > a")).click();
//
//            Thread.sleep(3000);
//        }



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
