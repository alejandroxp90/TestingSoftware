package org.testerA.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterByITestContext {

    String xChromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
    String baseURL = "https://www.google.com.mx/";
    WebDriver driver;

    @BeforeTest(groups = {"A", "B"})
    public void setProperties() {
        System.setProperty("webdriver.chrome.driver", xChromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @DataProvider(name = "searchData")
    public Object[][] getDataProviderValues(ITestContext c) {
        Object[][] groupArray = null;
        for (String group:c.getIncludedGroups()) {
            if(group.equals("A")){
                groupArray = new Object[][]{
                        {"isabel", "Google"},
                        {"Ernesto", "Yahoo"},
                        {"Gabriela", "Amazon"},
                        {"Pedro", "Gmail"}
                };
                break;
            }else if(group.equals("B")){
                groupArray = new Object[][]{
                        {"Mexico"},
                        {"Canada"},
                        {"Rusia"},
                        {"Japon"}
                };
            }
            break;

        }return groupArray;

    }




    @Test(dataProvider = "searchData", groups = {"B"})
    public void startTest(String val2) throws InterruptedException {
        WebElement elementoBusqueda2 = driver.findElement(By.name("q"));
        elementoBusqueda2.sendKeys(val2);
        String valAtributo = elementoBusqueda2.getAttribute("value");
        System.out.println("El elemento que buscaste fue: " + val2);
        Thread.sleep(3000);
        elementoBusqueda2.clear();
        Assert.assertTrue(valAtributo.equals(val2));
        elementoBusqueda2.clear();

    }
    @Test(dataProvider = "searchData", groups = {"A"})
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

    @AfterTest(groups = {"A"})
    public void tearTest(){
        driver.close();
        driver.quit();
    }
}
