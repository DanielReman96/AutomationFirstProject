import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    public static void main(String[] args) {




    }



    public void registerForNewUser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Thomas");
        driver.findElement(By.name("middlename")).sendKeys("Kirn");
        driver.findElement(By.id("lastname")).sendKeys("Fahrner");
        driver.findElement(By.name("email")).sendKeys("remandaniel058@gmail.com");
        driver.findElement(By.id("password")).sendKeys("1230456");
        driver.findElement(By.name("confirmation")).sendKeys("1230456");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();



        Thread.sleep(3000);
        driver.quit();










    }



































}
