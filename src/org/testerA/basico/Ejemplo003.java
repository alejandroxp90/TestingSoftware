package org.testerA.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo003 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        String xPath = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
        System.setProperty("webdriver.chrome.driver",xPath);
        String baseURL = "http://demo.guru99.com/test/radio.html";
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        for (int i=0; i<3;i++){

            WebElement miCheckBox = driver.findElement(By.id("vfb-6-"+ i));
            miCheckBox.click();
            System.out.println("El checkBox " + i + " esta seleccionado? " + miCheckBox.isSelected());
            Thread.sleep(3000);
        }

        WebElement miCheckBox = driver.findElement(By.id("vfb-6-1"));
        miCheckBox.click();
        System.out.println("El checkBox 2 esta seleccionado? " + miCheckBox.isSelected());
        Thread.sleep(3000);


    }


}
