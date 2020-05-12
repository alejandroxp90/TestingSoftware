package org.testerA.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo010 {

    private static WebDriver driver;

    public static void pathStart(){
        String xPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", xPath);
        String baseURL = "http://www.popuptest.com/popuptest2.html";
        driver = new ChromeDriver();
        driver.navigate().to(baseURL);
        driver.manage().window().maximize();
    }

    public static void startPage() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        String baseURL = "http://www.popuptest.com/popuptest2.html";
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {

        pathStart();
        startPage();


    }


}
