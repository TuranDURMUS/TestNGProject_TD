package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day20_Driver_ConfigTest {

    @Test
    public void firstTest(){

        // amazona git

        //Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));// driver.get(".....")

//        title in Amazon icerdigini test et
            Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));

//        close driver
            Driver.closeDriver();



    }
}
