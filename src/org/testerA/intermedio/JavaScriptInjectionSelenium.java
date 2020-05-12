package org.testerA.intermedio;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptInjectionSelenium {

    private WebDriver driver;
    String expectedResult = null;
    String actualResult = null;
    String baseURL = "http://newtours.demoaut.com/";
    private JavascriptExecutor js;
    String pageLoadStatus = "";

    private boolean highLight(WebElement element){
        js = (JavascriptExecutor) driver;
        for (int iCnt = 0;iCnt < 3; iCnt++){

            try {
                js.executeScript("arguments[0].setAttribute('style','background: red')", element);
                Thread.sleep(5000);
                js.executeScript("arguments[0].setAttribute('style','background:')", element);

            }catch (Exception e){
                System.err.println("JavaScript | Method: highLight | Exception desc: " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    private boolean scrollWindow(){
        try {
            js = (JavascriptExecutor) driver;
            //Scroll up(0,-250) / down(0,250)
            js.executeScript("window.scrollBy(0,250)");
        }catch (Exception e){
            System.err.println("JavaScript | Method: ScrollWindow | Exception desc: " + e.getMessage());
            return false;
        }
        return true;
    }

    private boolean waitForPageToLoad(){
        try {
            do{
                js = (JavascriptExecutor) driver;
                pageLoadStatus = (String) js.executeScript("return document.readyState");
            }while (!pageLoadStatus.equals("complete"));
        }catch (Exception e){
            System.err.println("JavaScript | Method: waitForPageToLoad | Exception desc: " + e.getMessage());
            return false;
        }
        return true;
    }

    @BeforeTest
    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        waitForPageToLoad();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }

    @Test(priority = 0)
    public void goToRegisterPage(){
        WebElement lnkRegister = driver.findElement(By.linkText("REGISTER"));
        Assert.assertTrue(highLight(lnkRegister));
        js.executeScript("arguments[0].click();", lnkRegister);
        expectedResult = "Register: Mercury Tours";
        actualResult = driver.getTitle();

        Assert.assertEquals(actualResult, expectedResult, "Son diferentes...");
        Assert.assertTrue(scrollWindow());

    }

    @Test(priority = 1)
    public void registerAnUser(){

        try {
            WebElement txtFirstName = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input"));
            highLight(txtFirstName);
            txtFirstName.sendKeys("Alex");
            WebElement ddlCountry = driver.findElement(By.name("country"));
            highLight(ddlCountry);
            new Select(ddlCountry).selectByVisibleText("MEXICO");

            highLight(driver.findElement(By.id("email")));
            driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("alexxp90@hot.com");
            highLight(driver.findElement(By.name("password")));
            driver.findElement(By.name("password")).sendKeys("12345678");
            highLight(driver.findElement(By.name("confirmPassword")));
            driver.findElement(By.name("confirmPassword")).sendKeys("12345678");

            WebElement btnSubmit = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[18]/td/input"));
            btnSubmit.click();

            Assert.assertTrue(waitForPageToLoad());
            highLight(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")));

        }catch (NoSuchElementException ns){
            Assert.fail("Test Failed : element was not found" + ns.getMessage());
        }catch (Exception e){
            Assert.fail("Test Failed!" + e.getMessage());
        }

    }




}
