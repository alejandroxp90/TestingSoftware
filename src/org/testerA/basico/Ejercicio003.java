package org.testerA.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Ejercicio003 {

    //ENCONTRAR EL TEXTO DEL RADIO BOTON E IMPRIMIRLO EN CONSOLA

    public static void main(String[] args){

        WebDriver driver;
        String xPath = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
        String btmBotonText = "";
        String baseURL = "http://demo.guru99.com/test/ajax.html";
        System.setProperty("webdriver.chrome.driver",xPath);

        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        List <WebElement> miLista = driver.findElements(By.name("name"));

        System.out.println("El numero de elementos es: " + miLista.size());

        for (int i=0; i < miLista.size();i++){

            System.out.println("El texto del radio " + i + " es: " + miLista.get(i).getAttribute("value"));

        }

        driver.close();

    }
}
