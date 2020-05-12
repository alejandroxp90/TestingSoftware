package org.testerA.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ejercicio001 {
    //Llenar el formulario en una pagina de prueba colocando diferentes locators
    private WebDriver driver;

    public void cargaDatos(){

        String xPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        String baseURL = "http://demo.guru99.com/test/newtours/";
        System.setProperty("webdriver.chrome.driver", xPath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    public void registro() throws InterruptedException {


        WebElement lkRegister = driver.findElement(By.linkText("REGISTER"));
        lkRegister.click();

        //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        WebElement fName = driver.findElement(By.name("firstName"));
        fName.sendKeys("Alejandro");
        fName.clear();
        fName.sendKeys("Adriana");
        WebElement lName = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input"));
        lName.sendKeys("Hernandez");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("5515230201");
        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("alex@hotmail.com");
        WebElement direccion = driver.findElement(By.name("address1"));
        direccion.sendKeys("direccion prolongacion 45");
        WebElement ciudad = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input"));
        ciudad.sendKeys("Bogota");
        WebElement state = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input"));
        state.sendKeys("Mexico");
        WebElement pC = driver.findElement(By.name("postalCode"));
        pC.sendKeys("06724");
        //Seleccion para pais
        WebElement country = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/select"));
        country.click();
        Select selectPais = new Select(country);
        selectPais.selectByValue("COLOMBIA");
        WebElement nombreUsuario = driver.findElement(By.id("email"));
        nombreUsuario.sendKeys("alexito999@hot.com");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("qwerty123");
        WebElement confirmPass = driver.findElement(By.name("confirmPassword"));
        confirmPass.sendKeys("qwerty123");
        driver.findElement(By.name("submit")).click();
        //WebElement enviarForm = driver.findElement(By.name("submit"));
        //enviarForm.click();
        Thread.sleep(2000);
        WebElement resultadoUsuario = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b"));
        System.out.println(resultadoUsuario.getText());
        System.out.println("Prueba exitosa! " + resultadoUsuario.getText());
    }

    public void cerrar() throws InterruptedException {

        Thread.sleep(10000);
        driver.close();
        driver.quit();

    }


    public static void main(String[] args) throws InterruptedException {

        Ejercicio001 ej1 = new Ejercicio001();

        try{
            ej1.cargaDatos();
            ej1.registro();

        }catch (NoSuchElementException se){
            System.err.println("No se encontro el WebElement" + se.getMessage());
        }catch (WebDriverException we){
            System.err.println("WebDriver falló..." + we.getMessage());
        }catch (Exception e){
            System.err.println("Error general... " + e.getMessage());
        }finally {
            ej1.cerrar();
        }


    }

}
