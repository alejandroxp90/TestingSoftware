package org.testerA.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo009 {
    //Excepciones
    private WebDriver driver;

    public void pathStart(){
        String xPath = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
        System.setProperty("webdriver.chrome.driver", xPath);
        String baseURL = "http://demo.guru99.com/test/radio.html";
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    public void tryTestCheckBox() throws InterruptedException {

        try {

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

        }catch (NoSuchElementException ne){
            System.err.println("No se encontro el WebElement" + ne.getMessage());
        }catch (WebDriverException we){
            System.err.println("WebDriver Falló!!" + we.getMessage());
        }catch (Exception e){
            System.err.println("Fallo General!!!" + e.getMessage());
        }finally {
            driver.close();
            driver.quit();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Ejemplo009 e9 = new Ejemplo009();
        e9.pathStart();
        e9.tryTestCheckBox();

    }
}
