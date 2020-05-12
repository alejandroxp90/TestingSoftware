package org.testerA.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ejemplo016 {

    String xChromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    String baseURL = "http://demo.guru99.com/test/tooltip.html";
    WebDriver driver;

    @BeforeClass
    public void beforeSetClass(){
        System.setProperty("webdriver.chrome.driver", xChromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @Test
    public void runTest(){
    //Find the "Download now" Element
        String expectedResult = "What's new in 3.2";
        WebElement btnDownload = driver.findElement(By.xpath("//*[@id=\"download_now\"]"));

        Actions builder = new Actions(driver);
        Action serieAction = builder.clickAndHold()
                .moveToElement(btnDownload)
                .build();
        serieAction.perform();

        WebElement toolTip = driver.findElement(By.xpath("//*[@class='box']/div/a"));
        System.out.println("El texto obtenido es: " + toolTip.getText());
        Assert.assertEquals(toolTip.getText(),expectedResult,"Error, no son semejantes!");
    }

    @AfterClass
    public void tearClass(){
        driver.close();
    }



}
