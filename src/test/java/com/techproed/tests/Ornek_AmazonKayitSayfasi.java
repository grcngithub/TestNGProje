package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Ornek_AmazonKayitSayfasi extends TestBase {

    @Test
    public void test01() {
        WebElement button = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
// mouse'u webelement'in üzerine götürme işlemi yapıyoruz.
        actions.moveToElement(button).perform();
        // xpath ->      //*[.='Start here.']
        WebElement startHereLink = driver.findElement(By.partialLinkText("Start here."));
        startHereLink.click();
        // 3. Adım : Sayfanın title'ı Amazon Registration ise testiniz başarılı olsun.
        // True kullanarak Assert.assertTrue(driver.getTitle().equals("Amazon Registration"));
        // Assert.assertFalse(!driver.getTitle().equals("Amazon Registration"));
        Assert.assertEquals(driver.getTitle(), "Amazon Registration");
    }



    @Test(dependsOnMethods = "test01")
    public void test02() {
        WebElement name = driver.findElement(By.id("ap_customer_name"));
        driver.findElement(By.id("Grcn")).sendKeys("ooooo@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("1234567");
        driver.findElement(By.id("ap_password_check")).sendKeys("1234567");
        driver.findElement(By.id("continue")).click();
        WebElement startHereLink = driver.findElement(By.partialLinkText("Start here."));

    }
}

