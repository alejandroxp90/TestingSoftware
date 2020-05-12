package org.testerA.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Ejemplo012 {

    private String baseURL = "http://demo.guru99.com/popup.php ";
    private String xChromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    private WebDriver driver;

    @BeforeClass
    public void before(){

        System.setProperty("webdriver.chrome.driver", xChromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

    }

    @Test
    public void runTest() throws InterruptedException {

        driver.findElement(By.linkText("Click Here")).click();
        //Se declara string para obtener informacion de ventana
        String parentWindow = driver.getWindowHandle();
        System.out.println("La ventana padre es: " + parentWindow);
        Thread.sleep(3000);

        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()){
            String newWindow = i1.next();
            System.out.println("La ventana abierta con el ID: " + newWindow);

            if(!parentWindow.equalsIgnoreCase(newWindow)){
                //Cambiamos a la nueva ventana
                driver.switchTo().window(newWindow);
                driver.findElement(By.name("emailid")).sendKeys("alexdf08@hotmail.com");
                Thread.sleep(3000);
                String s2 = driver.getWindowHandle();
                System.out.println("Ustede se encuentra en la ventana: " + s2);
                driver.findElement(By.name("btnLogin")).click();

                System.out.println("SUS CREDENCIALES SON: \n");
                System.out.println("Usuario: " + driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]")).getText());
                System.out.println("Password: " + driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]")).getText());
                Thread.sleep(5000);

            //Cerramos la ventana
            driver.close();

            }

        }
        driver.switchTo().window(parentWindow);
        System.out.println(parentWindow);
    }


    @AfterClass
    public void after() throws InterruptedException {

        Thread.sleep(5000);
        driver.close();

    }


}
