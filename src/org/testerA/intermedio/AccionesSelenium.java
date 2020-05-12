package org.testerA.intermedio;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AccionesSelenium {

    private WebDriver driver;

    public void datosInicio(){
        String xPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        String baseURL = "https://www.facebook.com/";
        System.setProperty("webdriver.chrome.driver",xPath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    public void iniciarTest() throws InterruptedException {
        WebElement email = driver.findElement(By.id("email"));
        System.out.println("La localizacion es: " + email.getLocation());

        Actions accionMouse = new Actions(driver);
        accionMouse
                .moveByOffset(email.getLocation().getX(), email.getLocation().getY())
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("alejandro")
                .keyUp(Keys.SHIFT)
                .doubleClick()
                .contextClick(email)
                .build()
                .perform();
        Thread.sleep(5000);
        System.out.println("Test Pasó!");


    }

    public void terminarTest() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }


    public static void main(String[] args) throws InterruptedException {

        AccionesSelenium acciones1 = new AccionesSelenium();

        try {

            acciones1.datosInicio();
            acciones1.iniciarTest();

        }catch (NoSuchElementException se){
            System.err.println("No se encontro el elemento" + se.getMessage());
        }catch (WebDriverException we){
            System.err.println("No se encontro el WebDriver" + we.getMessage());
        }catch (Exception e){
            System.err.println("Error, Falló" + e.getMessage());
        }finally {
            acciones1.terminarTest();
        }
    }
}
