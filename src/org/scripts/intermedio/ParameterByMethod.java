package org.scripts.intermedio;

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

    private WebDriver driver;
    private String baseURL = "https://google.com";
    private String xPathCrome = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";

    @BeforeTest
    public void launchDriver() {
        System.setProperty("webdriver.chrome.driver", xPathCrome);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @Test(dataProvider = "SearchProvider2")//
    public void testMethodA(String tester, String search) throws InterruptedException {

        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(search);
        System.out.println("Welcome -> " + tester + " your search word is -> " + search);
        Thread.sleep(3000);

        String testValue = searchText.getAttribute("value");// se debe colocar el value de este TestBox
        System.out.println("Test value is -> " + testValue + " and is equals to " + search);
        searchText.clear();

        Assert.assertTrue(testValue.equals(search));

    }

    @Test(dataProvider = "SearchProvider2")
    public void testMethodB(String search) throws InterruptedException {

        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(search);
        Thread.sleep(2000);

        String testValue = searchText.getAttribute("value");// se debe colocar el value de este TestBox
        System.out.println("Test value is -> " + testValue + " and is equals to " + search);
        searchText.clear();

        Assert.assertTrue(testValue.equalsIgnoreCase(search));

    }

    @DataProvider(name = "SearchProvider2")
    public Object[][] getDataFromDataProvider(Method m) {
        if (m.getName().equals("testMethodA")) {
            return new Object[][]{
                    {"Fernando", "Google"},
                    {"Luis", "Yahoo"},
                    {"Sara", "Gmail"},
                    {"Lorena", "Amazon"}
            };
        }else{
            return new Object[][]{
                    {"Mexico"},
                    {"China"},
                    {"Canada"}
            };
        }

   }


}