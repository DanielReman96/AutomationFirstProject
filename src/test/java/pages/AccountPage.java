package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private WebDriver driver;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = ".hello strong")
    private WebElement welcomeText;

    @FindBy(css = ".error-msg span")
    private WebElement errorWelcomeText;

    @FindBy(css = "[title=Register]")
    private WebElement registerLink;


    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;


    @FindBy(name = "email")
    private WebElement emailField;


    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(name = "confirmation")
    private WebElement confirmPasswordField;

    @FindBy(css = "[title=Register].button")
    private WebElement registerButton;



    public String getWelcomeText(){
        return welcomeText.getText();

    }

    public String getErrorWelcomeText(){
        return errorWelcomeText.getText();

    }

    public void clickRegisterLink(){
        registerLink.click();

    }

    public void setFirstNameField(String value){
        firstNameField.sendKeys(value);

    }

    public void setLastNameField(String value){
        lastNameField.sendKeys(value);

    }

    public void setEmailField(String value){
        emailField.sendKeys(value);

    }

    public void setPasswordField(String value){
        passwordField.sendKeys(value);

    }

    public void setConfirmPasswordField(String value){
        confirmPasswordField.sendKeys(value);

    }

    public void clickRegisterButton(){
        registerButton.click();

    }




}
