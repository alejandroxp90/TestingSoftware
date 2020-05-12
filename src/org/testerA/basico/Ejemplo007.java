package org.testerA.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo007 {

    private WebDriver driver;

    public void datosInicio(){

        String xPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        String baseURL = "https://www.facebook.com/login/identify?ctx=recover";
        System.setProperty("webdriver.chrome.driver",xPath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

    }

    public void startTest() throws InterruptedException {

        WebElement imagenSelector = driver.findElement(By.cssSelector("a[title='Ir a la página de inicio de Facebook']"));
        imagenSelector.click();
        Thread.sleep(6000);

        if(imagenSelector.equals("Ir a la página de inicio de Facebook")){
            System.out.println("Estamos de vuelta en la página de inicio de Facebook");
        }else{
            System.out.println ("NO estamos en la página de inicio de Facebook");
        }
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(5000);


        if(imagenSelector.equals("Ir a la página de inicio de Facebook")){
            System.out.println("Estamos de vuelta en la página de inicio de Facebook");
        }else{
            System.out.println ("NO estamos en la página de inicio de Facebook");
        }

        Thread.sleep(5000);
        driver.close();

    }

    public static void main(String[] args) throws InterruptedException {

        Ejemplo007 ej = new Ejemplo007();
        ej.datosInicio();
        ej.startTest();

    }


}
