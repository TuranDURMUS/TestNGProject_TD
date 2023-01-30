package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalHomePage {

    public BlueRentalHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

@FindBy(partialLinkText = "Login")
    public WebElement loginLink;

    @FindBy(id = "dropdown-basic-button")
    public WebElement userID;
    @FindBy(linkText = "Logout")
    public WebElement logOutLink;
    @FindBy(xpath = "//button[.='OK']")
    public WebElement OK;


}
