package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {

    private WebDriver driver;


    public WishlistPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy( css = ".cart-cell [title='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(id = "swatch26")
    private WebElement colorOptionLink;


    @FindBy(id = "swatch78")
    private WebElement sizeOptionLink;

    @FindBy(id = "qty")
    private WebElement quantityField;

    @FindBy(css = ".my-wishlist li:first-child")
    private WebElement successMessage;



    public void clickAddToCartButton(){

        addToCartButton.click();
    }

    public void clickColorOptionLink(){
        colorOptionLink.click();
    }

    public void clickSizeOptionLink(){
        sizeOptionLink.click();

    }


    public void setQuantityField(String value){
        quantityField.click();
        quantityField.clear();
        quantityField.sendKeys(value + Keys.ENTER);

    }

    public String getSuccessMessage(){
        return successMessage.getText();

    }


}
