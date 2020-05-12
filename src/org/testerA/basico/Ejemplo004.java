package org.testerA.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo004 {

    public static void main(String[] args) throws InterruptedException {
        // TEST PARA UBICAR EL CAMPO DE TEXTO POR ID Y EL CAMPO CONTRASEÑA POR NOMBRES
        WebDriver driver;
        String baseURL = "http://demo.guru99.com/test/login.html";
        String xpath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver",xpath);

        driver = new ChromeDriver();

        driver.get(baseURL);
        driver.manage().window().maximize();

        WebElement emaili = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.name("passwd"));

        emaili.sendKeys("Alejandro");
        Thread.sleep(2000);
        emaili.clear();
        pass.sendKeys("123456789a");
        Thread.sleep(2000);
        pass.clear();
        emaili.sendKeys("Alejandro");
        Thread.sleep(2000);
        pass.sendKeys("123456789a");
        Thread.sleep(2000);

        WebElement enviarInfo = driver.findElement(By.id("SubmitLogin"));
        enviarInfo.click();

        Thread.sleep(5000);
        driver.close();
    }
}
