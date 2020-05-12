package org.testerA.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Ejemplo011 {
    public static void main(String[] args) throws InterruptedException {
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get(baseUrl);
        WebElement link_Home = driver.findElement(By.linkText("Home"));
        WebElement td_Home1 = driver.findElement(By.linkText("Flights"));
        WebElement td_Home2 = driver.findElement(By.linkText("Hotels"));
        WebElement td_Home3 = driver.findElement(By.linkText("Car Rentals"));
        WebElement td_Home4 = driver.findElement(By.linkText("Cruises"));
        WebElement td_Home5 = driver.findElement(By.linkText("Destinations"));
        WebElement td_Home6 = driver.findElement(By.linkText("Vacations"));


        Thread.sleep(5000);
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(link_Home)
                .moveToElement(td_Home1)
                .moveToElement(td_Home2)
                .moveToElement(td_Home3)
                .moveToElement(td_Home4)
                .moveToElement(td_Home5)
                .moveToElement(td_Home6)
                .build();


        Thread.sleep(5000);
        mouseOverHome.perform();
        driver.close();
    }
}
