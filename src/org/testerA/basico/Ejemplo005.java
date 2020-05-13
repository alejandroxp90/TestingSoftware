package org.testerA.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo005 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        String baseURL = "http://demo.guru99.com/test/radio.html";
        String xPath = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";

        System.setProperty("webdriver.chrome.driver",xPath);
        driver = new ChromeDriver();

        driver.get(baseURL);
        driver.manage().window().maximize();

        WebElement miRadioBoton = driver.findElement(By.id("vfb-7-1"));
        miRadioBoton.click();
        Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        WebElement miRadioBoton2 = driver.findElement(By.id("vfb-7-2"));
        miRadioBoton2.click();
        Thread.sleep(5000);

        WebElement miRadioBoton3 = driver.findElement(By.id("vfb-7-3"));
        miRadioBoton3.click();
        Thread.sleep(5000);

        for (int i=0; i<3;i++){

            WebElement miCheckBox = driver.findElement(By.id("vfb-6-"+ i));
            miCheckBox.click();
            System.out.println("El checkBox " + i + " esta seleccionado? " + miCheckBox.isSelected());
            Thread.sleep(3000);
        }

        for (int k=0; k<3;k++){

            WebElement miCheckBox = driver.findElement(By.id("vfb-6-" + k));
            System.out.println("El ID del checkBox " + k +" es: " + (miCheckBox));
        }

        driver.close();
    }
}
