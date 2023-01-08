import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }
    @Test
    public void loginWithValidData(){


        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title~=Log]")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();

        WebElement welcomeTextElement = driver.findElement(By.cssSelector(".hello strong"));
        String expectedText = "Hello, Cosmin Fast!";
        String actualText = welcomeTextElement.getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void loginWithValidName() throws InterruptedException {

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title~=Log]")).click();
        driver.findElement(By.id("email")).sendKeys("remandaniel058@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("1230456");
        driver.findElement(By.name("send")).click();
        Thread.sleep(5000);

        WebElement welcomeText = driver.findElement(By.cssSelector(".hello strong"));
        String expectedResult = "Hello, Thomas Kirn Fahrner!";
        String actualResult = welcomeText.getText();
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void loginWithInvalidData() throws InterruptedException {

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title~=Log]")).click();
        driver.findElement(By.id("email")).sendKeys("remandaniel058@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("12304567");
        driver.findElement(By.name("send")).click();
        Thread.sleep(5000);

        WebElement errorMessage = driver.findElement(By.cssSelector(".error-msg span"));
        String expectedResult = "Invalid login or password.";
        String actualResult = errorMessage.getText();
        Assert.assertEquals(expectedResult, actualResult);

    }

    @After
    public void quitDriver(){

        driver.quit();

    }








}
