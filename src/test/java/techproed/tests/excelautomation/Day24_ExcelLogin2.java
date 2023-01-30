package techproed.tests.excelautomation;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;
import java.util.List;
import java.util.Map;
public class Day24_ExcelLogin2 {
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    //    Bu metot login sayfasina gitmek icin kullanililacak
    ExcelUtils excelUtils;
    List<Map<String, String>> excelDatalari;
    @Test
    public void customerLogin(){
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
        String sayfa = "customer_info";
        excelUtils=new ExcelUtils(path,sayfa);
        excelDatalari=excelUtils.getDataList();
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        home page logine tikla
        for (Map<String,String> data:excelDatalari) {
            //        Sayfaya git
            Driver.getDriver().get(ConfigReader.getProperty("app_url"));
            blueRentalHomePage= new BlueRentalHomePage();
            blueRentalLoginPage = new BlueRentalLoginPage();
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);// 1 saniye bekle
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.emailBox.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.loginButton.click();
            // giriş yapıldı
            ReusableMethods.waitFor(1);
            ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);//assertion
            ReusableMethods.waitFor(1);

            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.logOutLink.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.OK.click();
        }
        Driver.closeDriver();
    }
}