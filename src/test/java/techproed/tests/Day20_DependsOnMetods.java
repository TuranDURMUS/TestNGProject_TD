package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_DependsOnMetods {
    @Test
    public void homeTest(){
        System.out.println("Home Test");
        Assert.assertTrue(false);//FAIL
    }
    @Test(dependsOnMethods = "homeTest")
    public void searchTest(){
        System.out.println("Search Test");    }
    @Test(dependsOnMethods = "homeTest")
    public void paymentTest(){
        System.out.println("Payment Test");
    }
}
/*
TestNG de tum  @Test metotlar bitbirlerinden bagimsiz olarak calisirlat
Eger methodlari bagimli hale getirmek istersem, dependsOnMethods parametresi kullanilir
Burdaki ornekde, searchTest methodu homeTest methoduna bagimlidir
searchTest den once homeTest calisir
Eger homeTest basarili ise searchTest calisir.
Eget homeTest basarisiz ise, searchTest IGNORE edilir
 */


