package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".skip-account .label")
    private WebElement accountButton;

    @FindBy(css = "[title='Log In']")
    private WebElement loginLink;

    @FindBy(css = ".nav-6")
    private WebElement vipButton;

    @FindBy(css = "li:first-child .add-to-links .link-wishlist")
    private WebElement addToWishlistLink;


    @FindBy(css = ".top-link-cart")
    private WebElement myCartLink;

    @FindBy(css = ".success-msg")
    private WebElement successRegisterMessage;
    public void clickAccountButton(){
        accountButton.click();

    }
    public void clickLoginLink(){
        loginLink.click();
    }

    public void clickVipButton(){
        vipButton.click();
    }

    public void clickAddToWishlistLink(){
        addToWishlistLink.click();

    }
    public void clickMyCartLink(){
        myCartLink.click();

    }

    public String getSuccessRegisterMessage(){
        return successRegisterMessage.getText();

    }







}
