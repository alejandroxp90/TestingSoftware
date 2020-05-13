package org.testerA.basico;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo001 {

    public static void main(String[] args){

        //ENCONTRAR EL TITULO Y COMPARAR SI ES CORRECTA SU ENTRADA

        WebDriver driver;

        String getPath = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
        System.setProperty("webdriver.chrome.driver", getPath);


        String baseURL = "http://demo.guru99.com/test/newtours/";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";

        driver = new ChromeDriver();

        driver.get(baseURL);
        driver.manage().window().maximize();
        actualResult = driver.getTitle();
        System.out.println(actualResult);

        System.out.println(actualResult.contentEquals(expectedResult)? "Correcto, el titulo es el mismo...." : "Incorrecto, el titulo es distinto....");

        driver.close();
    }

}
