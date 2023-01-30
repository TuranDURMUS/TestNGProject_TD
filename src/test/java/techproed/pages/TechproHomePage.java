package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;
public class TechproHomePage {
    public TechproHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement homeHeader;
    @FindBy(xpath = "//*[contains(text(),'Logout')]")
    public WebElement homeLogoutButton;

}
