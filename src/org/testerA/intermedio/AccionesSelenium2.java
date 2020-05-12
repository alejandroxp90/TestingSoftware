package org.testerA.intermedio;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AccionesSelenium2 {

    private WebDriver driver;

    public void xPath(){

        String xRuta = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        String baseURL = "https://www.facebook.com/";
        System.setProperty("webdriver.chrome.driver", xRuta);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

    }

    public void iniciarTest2() throws InterruptedException {

        WebElement txtUser = driver.findElement(By.id("email"));

        Actions builder = new Actions(driver);
        Action serieOfActions = builder
                .moveToElement(txtUser)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("alejandro")
                .keyUp(Keys.SHIFT)
                .sendKeys(" juarez")
                .doubleClick()
                .contextClick(txtUser)
                .build();
        serieOfActions.perform();
        Thread.sleep(5000);
        System.out.println("Test Paso!");


    }

    public void cerrarTest2() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();

    }



    public static void main(String[] args) throws InterruptedException {

        AccionesSelenium2 acciones2 = new AccionesSelenium2();

        try {

            acciones2.xPath();
            acciones2.iniciarTest2();

        }catch (NoSuchElementException se){
            System.err.println("Error en el elemento " + se.getMessage());
        }catch (WebDriverException we){
            System.err.println("Fallo en el WebDriver " + we.getMessage());
        }catch (Exception e){
            System.err.println("Fallo general " +e.getMessage());
        }finally {
            acciones2.cerrarTest2();
        }



    }


}
