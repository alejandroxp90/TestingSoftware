package org.testerA.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo002 {

    public static void main(String[] args) throws InterruptedException {

        // ENCONTRAR EL RADIO BOTON EN NO Y HACER CLICK EN EL CHECK
        WebDriver driver;

        String baseURL = "http://demo.guru99.com/test/ajax.html";
        String elementoX = "";
        String xPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver",xPath);

        driver = new ChromeDriver();

        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.findElement(By.id("no")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("buttoncheck")).click();
        Thread.sleep(5000);
        driver.close();

    }

}
