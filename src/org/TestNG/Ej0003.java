package org.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Test
public class Ej0003 {

    public String baseURL = "http://demo.guru99.com/test/newtours/";
    public String driverPathChrome = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
    public String driverPathMozilla = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
    public WebDriver driver;

    @BeforeTest
    public void launchBrowser(){
        System.out.println("Iniciando el nevagador!....");
        System.setProperty("webdriver.chrome.driver",driverPathChrome);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @Test (priority = 0)
    public void verifyLinksRegister(){
        System.out.println("Iniciando Prueba de Registro!");
        WebElement registrar = driver.findElement(By.linkText("REGISTER"));
        registrar.click();
        String actualTitleRegister = driver.getTitle();
        String expectedTitleRegister = "Register: Mercury Tours";
        Assert.assertEquals(actualTitleRegister,expectedTitleRegister,"Error, los titulos no son los esperados...");
    }

    @Test (priority = 1)
    public void verifyLinksSoport(){
        System.out.println("Iniciando Prueba de Soporte!");
        WebElement soporte = driver.findElement(By.linkText("SUPPORT"));
        soporte.click();
        String expectedTitleSoport = "Under Construction: Mercury Tours";
        String actualTitleSoport = driver.getTitle();
        Assert.assertEquals(actualTitleSoport,expectedTitleSoport,"Error, los titulos no coinciden...");
    }

    @AfterTest
    public void tearTest() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Cerrando el Test!");
        driver.close();
    }

    @BeforeMethod
    public void verifyHomePageTitle(){
        System.out.println("Verificando el titulo de la pagina de inicio...");
        String actualTitle = "Welcome: Mercury Tours";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"No corresponde al titulo esperado...");
    }

    @AfterMethod
    public  void homePageclickTitle(){
        System.out.println("Redireccionando a home...");
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/font/a")).click();

    }



}
