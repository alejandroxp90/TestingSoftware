package org.testerA.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Ejercicio002 {

    private WebDriver driver;

    public void cargarDatos(){

        String xPath = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
        String baseURL = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";
        System.setProperty("webdriver.chrome.driver", xPath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void eCargaE() throws InterruptedException {
        driver.switchTo().frame("iframeResult");
        WebElement btnTry = driver.findElement(By.xpath("/html/body/button"));
        WebDriverWait waitVar = new WebDriverWait(driver,10);
        waitVar.until(ExpectedConditions.elementToBeClickable(btnTry));
        btnTry.click();
        Thread.sleep(10000);
        waitVar.until(ExpectedConditions.alertIsPresent());
        Alert alertWindow = driver.switchTo().alert();
        String alertText = alertWindow.getText();
        System.out.println(alertText);
        alertWindow.sendKeys("Alejandro Juarez");
        alertWindow.accept();
        String finalText = driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText();
        Thread.sleep(10000);
        System.out.println(finalText.contains("Alejandro") ? finalText: "Prueba Fallida! ");
    }

    public  void close() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {

        Ejercicio002 e02 = new Ejercicio002();
        //Agregar exepciones para implicitwait, alerta y para frames
        try {
            e02.cargarDatos();
            e02.eCargaE();
        }catch (NoSuchElementException se){
            System.err.println("No se encuentra el elemento...." + se.getMessage());
        }catch (NoSuchFrameException nf){
            System.err.println("No se encontro el frame!" + nf.getMessage());
        }catch (NoAlertPresentException aE){
            System.err.println("No se encontro una alerta..." + aE.getMessage());
        }catch (TimeoutException te){
            System.err.println("Tiempo fuera del limite esperado...." + te.getMessage());
        }catch (WebDriverException we){
            System.err.println("WebDriver Falló!" + we.getMessage());
        }catch (Exception e){
            System.err.println("Fallo general " + e.getMessage());
        }finally {
            e02.close();
        }
    }
}
