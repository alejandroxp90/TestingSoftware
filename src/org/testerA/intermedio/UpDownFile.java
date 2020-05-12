package org.testerA.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpDownFile {

    private WebDriver driver;
    private String baseURL = "http://demo.guru99.com/test/yahoo.html";
    private String xChromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", xChromePath);
        driver =new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

    }

    @Test
    public void startClass() throws InterruptedException {

        WebElement downloadButton = driver.findElement(By.id("messenger-download"));
        String sourceLocation = downloadButton.getAttribute("href");
        String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;

        try {
            Process exec = Runtime.getRuntime().exec(wget_command);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
        driver.close();
    }



    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();

    }


}
