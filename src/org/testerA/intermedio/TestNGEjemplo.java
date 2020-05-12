package org.testerA.intermedio;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestNGEjemplo {
    private WebDriver driver;
    //EJEMPLO DE UN TESTCASE CON METODO MAIN SIN PROBAR CON TESTNG
    public void cargarDatos(){
        String xPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        String baseURL = "http://demo.guru99.com/selenium/newtours/index.php";
        System.setProperty("webdriver.chrome.driver", xPath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }
     public void IniciarTest(){
        String tpActual = driver.getTitle();
        String tpExpected = "Welcome: Mercury Tours";
        System.out.println(driver.getTitle());
        System.out.println(tpActual.contentEquals(tpExpected) ? "Correcto, estas en la pagina principal" : "Incorrecto, estas en otra pagina!");
        try{
            if(tpActual.contentEquals(tpExpected)){
                WebElement lkRegister = driver.findElement(By.linkText("REGISTER"));
                lkRegister.click();
                String tRegister = driver.getTitle();
                String tRegExpected = "Register: Mercury Tours";
                if (tRegister.contentEquals(tRegExpected)){
                    System.out.println("Correcto, el titulo de la pagina REGISTER es: " + tRegExpected);
                    driver.get("http://demo.guru99.com/selenium/newtours/index.php");
                    lkSupport();
                }else{
                    System.out.println("Incorrecto, el titulo de REGISTER no es el mismo: " + tRegister);
                }
            }
        }catch (Exception e){
            System.err.println("Error principal");
        }

     }

     public void lkSupport(){
        WebElement lkSupport = driver.findElement(By.linkText("SUPPORT"));
        lkSupport.click();
        String titleSupport = driver.getTitle();
        String tiExpectedSupport = "Under Construction: Mercury Tours";

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try {
            if (titleSupport.contentEquals(tiExpectedSupport)){
                System.out.println("Correcto, el titulo del link SUPPORT es: " + tiExpectedSupport);
                Thread.sleep(6000);
                driver.get("http://demo.guru99.com/selenium/newtours/index.php");
            }else{
                System.err.println("Incorrecto, el titulo del LINK SUPPORT es: " + titleSupport);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

     }

     public void terminarTest() throws InterruptedException {
         Thread.sleep(5000);
         driver.close();
         driver.quit();
     }

    public static void main(String[] args) throws InterruptedException {

        TestNGEjemplo tNG01 = new TestNGEjemplo();

        try {

            tNG01.cargarDatos();
            tNG01.IniciarTest();

        }catch (NoSuchElementException se){
            System.out.println("No se encontro el elemento..." + se.getMessage());
        }catch (WebDriverException we){
            System.out.println("Fallo en WebDriver...." + we.getMessage());
        }catch (Exception e){
            System.out.println("Fallo general...." + e.getMessage());
        }finally {
            tNG01.terminarTest();
        }
    }

}
