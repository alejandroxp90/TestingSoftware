package org.testerA.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class Ejemplo017 {
    public String xPathChrome = System.clearProperty("user.dir") + "\\drivers\\chromedriver.exe";
    private WebDriver driver;
    //private String baseURL = "https://www.zlti.com/";
    private String baseURL = "http://www.domylab.com/home/";
    public String URLBroken = "";
    public HttpURLConnection huc = null;
    private int responseCode = 200;

    @BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", xPathChrome);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test
    public void navigateToUrl() {
        List<WebElement> brokenList = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = brokenList.iterator();

        while (it.hasNext()){
            URLBroken = it.next().getAttribute("href");
            System.out.println(URLBroken);

            if(URLBroken==null || URLBroken.isEmpty()){
                System.out.println("La URL no esta configurada o es Nula");
                continue;
            }
            if (URLBroken.startsWith(baseURL)){
                System.out.println("La dirección URL pertenece a otro dominio");
                continue;
            }

            try {
                huc = (HttpURLConnection)(new URL(URLBroken).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                responseCode = huc.getResponseCode();

                if(responseCode>=400){
                    System.out.println(URLBroken + " este link esta roto....");
                }else{
                    System.out.println(URLBroken + " este link es valido....");
                }

            }catch (MalformedURLException me){
                me.printStackTrace();
            }catch (IOException ie){
                ie.printStackTrace();
            }

        }

    }

    @AfterClass
    public void endTest() {

        driver.quit();


    }
}
