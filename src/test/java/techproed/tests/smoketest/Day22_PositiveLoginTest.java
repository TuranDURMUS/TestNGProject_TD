package techproed.tests.smoketest;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day22_PositiveLoginTest {
                    //
                    //   Name: US100201_Admin_Login
                    //    Description:
                    //    Admin bilgileriyle giriş
                    //    Acceptance Criteria:
                    //    Admin olarak, uygulamaya giriş yapabilmeliyim
                    //    https://www.bluerentalcars.com/
                    //    Admin email: jack@gmail.com
                    //    Admin password: 12345

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    @Test
    public void US100201_Admin_Login() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("admin_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("admin_sifre"));
        blueRentalLoginPage.loginButton.click();
        Assert.assertTrue(blueRentalHomePage.userID.isDisplayed());

Driver.closeDriver();






    }
}



