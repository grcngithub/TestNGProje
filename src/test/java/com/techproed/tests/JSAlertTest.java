package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {

    private WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void jsAlertTest() {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button.click();

        String alertMesaji = driver.switchTo().alert().getText();
        System.out.println(alertMesaji);

        driver.switchTo().alert().accept();

    }
    @Test
    public void jsConfirmTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement button = driver.findElement(By.xpath("//button[@onlick='jsConfirm()']"));
        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);
        driver.switchTo().alert().dismiss();
        System.out.println(mesaj);
        driver.switchTo().alert().sendKeys("Merhaba TestNG");
        driver.switchTo().alert().accept();

    }

}

