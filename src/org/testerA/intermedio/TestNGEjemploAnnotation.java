package org.testerA.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGEjemploAnnotation {

    String xPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    String expectedResult = "";
    String actualResult ="";
    String baseURL = "http://demo.guru99.com/selenium/newtours/index.php";
    WebDriver driver;


    @BeforeTest
    public void launchBrowser(){
        System.out.println("Inicio del navegador!!");
        System.setProperty("webdriver.chrome.driver", xPath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void verifyPageHomeTitle(){
        expectedResult = "Welcome: Mercury Tours";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"Error, los resultados no son los esperados.");
    }
    @AfterMethod
    public void goBackToHome(){
        driver.findElement(By.linkText("Home")).click();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void registerLink(){
        WebElement regLk = driver.findElement(By.linkText("REGISTER"));
        regLk.click();
        expectedResult = "Register: Mercury Tours";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"Error, no coinciden...!");
    }

    @Test
    public void supportLink(){
        WebElement suppLk = driver.findElement(By.linkText("SUPPORT"));
        suppLk.click();
        expectedResult = "Under Construction: Mercury Tours";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"Error, no coincide el titulo...!");
    }

}
