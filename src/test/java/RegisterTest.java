import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {


    private WebDriver driver;
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }


    @Test
    public void registerForNewUser() throws InterruptedException {

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title=Register]")).click();
        driver.findElement(By.id("firstname")).sendKeys("Thomas");
        //driver.findElement(By.name("middlename")).sendKeys("Kirn");
        driver.findElement(By.id("lastname")).sendKeys("Frank");
        driver.findElement(By.name("email")).sendKeys("ThomasFrank@gmail.com");
        driver.findElement(By.id("password")).sendKeys("1230456");
        driver.findElement(By.name("confirmation")).sendKeys("1230456");
        driver.findElement(By.cssSelector("[title=Register].button")).click();

        Thread.sleep(3000);

        WebElement welcomeMessage = driver.findElement(By.cssSelector(".success-msg"));
        String actualResult = welcomeMessage.getText();
        String expectedResult = "Thank you for registering with Madison Island.";
        Assert.assertEquals(expectedResult,actualResult);


    }

    @After
    public void quitDriver(){

        driver.quit();

    }



}
