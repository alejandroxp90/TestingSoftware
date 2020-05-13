package org.testerA.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEjemplo {
    String xChromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
    String baseURL = "https://www.google.com.mx/";
    WebDriver driver;

    @BeforeTest
    public void setProperties(){
        System.setProperty("webdriver.chrome.driver",xChromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }
    @DataProvider(name = "searchData")
    public Object[][] getDataProviderValues(){
        return new Object[][]{
                {"Alex", "Amazon Prime Video"},
                {"Ady", "Google"},
                {"Monty", "Yahoo"},
                {"Adrian", "Hotmail"}
        };
    }


    @Test
    public void startTest() throws InterruptedException {
        WebElement elementSearh = driver.findElement(By.name("q"));
        elementSearh.sendKeys("Amazon Prime Video");
        Thread.sleep(5000);
        System.out.println("El contenido escrito es: " + elementSearh.getAttribute("value"));
        elementSearh.clear();
        Thread.sleep(5000);

    }
    @Test(dataProvider = "searchData")
    public void startTest2(String user, String val) throws InterruptedException {
        WebElement elementoBusqueda = driver.findElement(By.name("q"));
        elementoBusqueda.sendKeys(val);
        String atributoValor = elementoBusqueda.getAttribute("value");
        System.out.println("Bienvenido " + user + " tu valor es: " + val);
        Thread.sleep(2000);
        elementoBusqueda.clear();
        Assert.assertTrue(atributoValor.equals(val));
        elementoBusqueda.clear();

    }

    @AfterTest
    public void tearTest(){
        driver.close();
        driver.quit();
    }




}
