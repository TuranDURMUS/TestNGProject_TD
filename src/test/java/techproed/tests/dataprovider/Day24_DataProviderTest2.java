package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day24_DataProviderTest2 {
    // data provider metodu
    @DataProvider
    public Object[][] customerData(){
        Object[][] musteriBilgileri = {
                {"sam.walker@bluerentalcars.com", "c!fas_art"},
                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com","v7Hg_va^" },
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}
        };
        return musteriBilgileri;
    }

    // data provider test

    @Test(dataProvider = "customerData")
    public void dataProviderTest(String email, String password) {
        System.out.println("EMAİL:"+email+"SİFRE:"+password);
    }
    // bu 4 customer dataları ile login testi yapalım

    //    BU 4 CUSTOMER DATALARI ILE LOGIN TESTI YAPALIM
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;

    @Test(dataProvider = "customerData")
    public void dataProviderLoginTest(String email, String sifre) throws IOException, IOException {
        //        Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));//HOME SAYFASINA
        blueRentalHomePage= new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        ReusableMethods.waitFor(1);// 1 saniye bekle
        blueRentalLoginPage.emailBox.sendKeys(email);
        ReusableMethods.waitFor(1);
        blueRentalLoginPage.passwordBox.sendKeys(sifre);
        ReusableMethods.waitFor(1);
        blueRentalLoginPage.loginButton.click();
        //            GIRIS YAPILDI
        ReusableMethods.waitFor(1);
        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);//ASSERTION
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("EkranGoruntusu");
        ReusableMethods.waitFor(1);
        blueRentalHomePage.userID.click();
        ReusableMethods.waitFor(1);
        blueRentalHomePage.logOutLink.click();
        ReusableMethods.waitFor(1);
        blueRentalHomePage.OK.click();
        Driver.closeDriver();
    }





}
