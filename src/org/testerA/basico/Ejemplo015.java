package org.testerA.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Ejemplo015 {

    public static void main(String[] args) throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        String baseUrl = "http://demo.guru99.com/test/social-icon.html";
        System.setProperty("webdriver.chrome.driver", chromePath);
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        String expectedTooltip = "Github";

        // Find the Github icon at the top right of the header
        WebElement github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));

        //get the value of the "title" attribute of the github icon
        String actualTooltip = github.getAttribute("title");

        //Assert the tooltip's value is as expected
        System.out.println("Actual Title of Tool Tip "+ actualTooltip);
        Assert.assertEquals(expectedTooltip,actualTooltip);

       /* if(actualTooltip.equals(expectedTooltip)) {
            System.out.println("Test Case Passed");
        }*/
        Thread.sleep(5000);
        driver.close();
    }
}
