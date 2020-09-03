package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IFrameTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }

    @Test
    public void iframeTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        //index ile iframe gecis yapabiliyoruz...
        driver.switchTo().frame(0);

        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("merhaba iframe");


    }

    @Test
    public void iframeTest2() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("merhaba iframe");

    }

    @Test
    public void iframeTest4() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        // index ile iframe'e geçiş yapabiliyoruz.
        driver.switchTo().frame(0);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");
        driver.switchTo().defaultContent();
        //iframe webelementinin bi ust elementine geciyor
        driver.switchTo().parentFrame();
        WebElement link = driver.findElement(By.partialLinkText("Elemental Selenium"));
        link.click();
    }
}
