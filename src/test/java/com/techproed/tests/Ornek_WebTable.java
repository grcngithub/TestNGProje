package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Ornek_WebTable extends TestBase {

    @Test
    public void test() {
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> satirlar = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println(satirlar.size() + " adet satir vardir.");
        List<WebElement> ucuncuSatir = driver.findElements(By.xpath("//tbody/tr[3]"));
        for (WebElement w : ucuncuSatir
        ) {
            System.out.println(w.getText());
        }
    }
}