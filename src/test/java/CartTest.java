import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {

    private WebDriver driver;


    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void addToCart() throws InterruptedException {




    }

    @Test
    public void deleteFromCart() throws InterruptedException {

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title~=Log]")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("remandaniel058@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("1230456");
        driver.findElement(By.cssSelector("#send2")).click();
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".top-link-cart")).click();
        driver.findElement(By.cssSelector(".first .a-center .btn-remove2")).click();

        Thread.sleep(3000);

        WebElement deleteMessage = driver.findElement(By.cssSelector(".page-title"));
        String expectedResult = "SHOPPING CART IS EMPTY";
        String actualResult = deleteMessage.getText();
        Assert.assertEquals(expectedResult,actualResult);



    }

    @After
    public void quitDriver(){

        driver.quit();

    }



}
