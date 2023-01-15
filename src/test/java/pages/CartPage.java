package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public WebDriver driver;


    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);


    }

    @FindBy(css = ".messages")
    private WebElement succesMessage;

    @FindBy(css = ".first .a-center .btn-remove2")
    private WebElement removeButton;

    @FindBy(css = ".page-title")
    private WebElement deleteMessage;

    public String getSuccesMessage(){
        return succesMessage.getText();

    }
    public void clickRemoveButton(){
        removeButton.click();
    }

    public String getDeleteMessage(){
        return  deleteMessage.getText();

    }




}
