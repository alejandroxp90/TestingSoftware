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

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class ParameterByMethod {
    WebDriver driver;
    String xChromePathDriver = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    String baseURL = "https://www.google.com.mx/";

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", xChromePathDriver);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DataProvider(name = "SearchProvider")
    public Object[][] getDataFromPrivider(Method m) {

        if (m.getName().equals("testMethodA")) {
            return new Object[][]{
                    {"Alex", "Amazon Prime Video"},
                    {"Ady", "Google"},
                    {"Monty", "Yahoo"},
                    {"Adrian", "Hotmail"}
            };
        } else {
            return new Object[][]{
                    {"Mexico"},
                    {"China"},
                    {"Peru"}
            };
        }
    }


    @Test(dataProvider = "SearchProvider")
    public void testMethodA(String user, String val) throws InterruptedException {
        WebElement elementoBusqueda = driver.findElement(By.name("q"));
        elementoBusqueda.sendKeys(val);
        String atributoValor = elementoBusqueda.getAttribute("value");
        System.out.println("Bienvenido " + user + " tu valor es: " + val);
        Thread.sleep(2000);
        elementoBusqueda.clear();
        Assert.assertTrue(atributoValor.equals(val));
        elementoBusqueda.clear();
    }

    @Test(dataProvider = "SearchProvider")
    public void testMethodB(String val2) throws InterruptedException{
        WebElement elementoBusqueda2 = driver.findElement(By.name("q"));
        elementoBusqueda2.sendKeys(val2);
        String valAtributo = elementoBusqueda2.getAttribute("value");
        System.out.println("El elemento que buscaste fue: " + val2);
        Thread.sleep(3000);
        elementoBusqueda2.clear();
        Assert.assertTrue(valAtributo.equals(val2));
        elementoBusqueda2.clear();


    }



    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
