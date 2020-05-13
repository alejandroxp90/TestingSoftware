package org.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ej0001 {

    public String baseURL = "http://demo.guru99.com/test/newtours/";
    public String driverPathChrome = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
    public String driverPathMozilla = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
    public WebDriver driver;

    @Test (priority = 0)
    public void miPrimerTest3() throws InterruptedException {
        System.out.println("Iniciando el explorador chrome!");
        System.setProperty("webdriver.chrome.driver",driverPathChrome);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        String actualResult = driver.getTitle();
        String expectedResult = "Welcome: Mercury Tours";
        Assert.assertEquals(actualResult,expectedResult,"The titles are not equals");
        Thread.sleep(5000);
        driver.close();
    }
    @Test (priority = 1, alwaysRun = false)
    public void miPrimerTest2() throws InterruptedException {
        System.out.println("Iniciando el explorador firefox!");
        System.setProperty("webdriver.gecko.driver",driverPathMozilla);
        driver = new FirefoxDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        String actualResult = driver.getTitle();
        String expectedResult = "Welcome: Mercury Tours";
        Assert.assertEquals(actualResult,expectedResult,"The titles are not equals");
        Thread.sleep(5000);
        driver.close();
    }


}
