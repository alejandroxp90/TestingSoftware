package org.scripts.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PruebaGit {

    WebDriver driver;
    private String xPathCrome = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
    private String xPathFox = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";

    @BeforeTest
    public void startTest(){
        System.setProperty("webdriver.chrome.driver", xPathCrome);
        System.setProperty("webdriver.gecko.driver", xPathFox);
        driver = new FirefoxDriver();
    }

    // Method 1: Open Brower say Firefox
    @Test(priority=1)
    public void openBrowser() {
        driver.manage().window().maximize();
    }

    // Method 2: Launch Google.com
    @Test(priority=2)
    public void launchGoogle() {
        driver.get("https://www.google.com/");
    }

    // Method 3: Perform a search using "Facebook"
    @Test(priority=3)
    public void peformSeachAndClick1stLink() throws InterruptedException {
        WebElement elementoBusqueda = driver.findElement(By.xpath(".//*[@title='Buscar']"));
        elementoBusqueda.sendKeys("Facebook");
        elementoBusqueda.submit();
        Thread.sleep(5000);
    }

    // Method 4: Verify Google search page title.
    @Test(priority=4)
    public void FaceBookPageTitleVerification() throws Exception {
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle().contains("Facebook - Buscar con Google"), true);
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
