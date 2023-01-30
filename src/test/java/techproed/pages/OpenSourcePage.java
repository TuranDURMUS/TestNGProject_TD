package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {

    public OpenSourcePage(){


//    Page Objelerini bu sinifda buluruz

//    1. constructor
//        PageFactory seleniumdan gelen ve bu sayfa elementlerini baslangic degeri vermek etmek icin kullanilir
//        Bu sekilde Sayfa objeleri cagrildiginda null pointer exception alinmaz
            PageFactory.initElements(Driver.getDriver(),this);
        }

//    PAGE OBJELERINI OLUSTUR
//    GELENEKSEL  : public WebElement username = Driver.getDriver().findElement(By.name("username"));
        @FindBy(name = "username")
        public WebElement username;

        @FindBy(xpath = "//input[@name='password']")
        public WebElement password;

        @FindBy(xpath = "//button[@type='submit']")
        public WebElement submitButton;


}




