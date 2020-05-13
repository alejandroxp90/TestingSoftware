package org.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ej0002 {

    public String baseURL = "http://demo.guru99.com/test/newtours/";
    public String driverPathChrome = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
    public String driverPathMozilla = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
    public WebDriver driver;

    @BeforeTest
    public void launchBrowser(){
        System.out.println("Vamos a iniciar el Test");
        System.setProperty("webdriver.chrome.driver",driverPathChrome);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

    }

    @Test
    public void verifyHomepageTitle() throws InterruptedException {
        System.out.println("Iniciando el explorador chrome!");
        System.setProperty("webdriver.chrome.driver",driverPathChrome);
        String actualResult = driver.getTitle();
        String expectedResult = "Welcome: Mercury Tours";
        Assert.assertEquals(actualResult,expectedResult,"The titles are not equals");
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeTest(){
        System.out.println("Ahora vamos a cerrar el test!");
        driver.close();
    }


}
