package org.testerA.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.List;

public class Ejemplo013 {
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
    String baseURL = " http://demo.guru99.com/test/web-table-element.php";
    WebDriver driver;
    String max;
    double m = 0, r = 0;

    @BeforeClass
    public void setClass() {
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @Test
    public void runTest() throws ParseException {

        List<WebElement> columnas = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        System.out.println("El numero de columnas es: " + columnas.size());

        List<WebElement> filas = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
        System.out.println("El numero de filas es: " + filas.size());

        WebElement miTabla = driver.findElement(By.tagName("table"));
        //Imprimir la tercera fila completa
        WebElement fila3Tabla = miTabla.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
        System.out.println("Fila 3: " + fila3Tabla.getText());
        //para obtener los datos de la 2a columna de la 3a fila
        WebElement dato2Fila3 = fila3Tabla.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
        System.out.println("Dato segunda columna: " + dato2Fila3.getText());

        System.out.println(miTabla.getText());
/*
        for (int i = 1; i < filas.size(); i++) {
            max = driver.findElement(By.xpath("html/body/div[1]/div[5]/table/tbody/tr[" + (i + 1) + "]/td[4]")).getText();
            NumberFormat f = NumberFormat.getNumberInstance();
            Number num = f.parse(max);
            max = num.toString();
            m = Double.parseDouble(max);
            if (m > r) {
                r = m;
            }
        }
        System.out.println("Maximum current price is : " + r);*/

    }





    @AfterClass
    public void cerrarTest() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();


    }




}
