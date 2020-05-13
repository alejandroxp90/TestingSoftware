package org.testerA.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ejemplo008 {

    private WebDriver driver;

    public void rutaInicio(){

        String xpath = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
        String baseURL = "http://demo.guru99.com/test/newtours/register.php";
        System.setProperty("webdriver.chrome.driver",xpath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

    }

    public void startTest() throws InterruptedException {

        WebElement cuadroDespl = driver.findElement(By.name("country"));
        cuadroDespl.click();
        Thread.sleep(3000);
        Select cuadritoDes = new Select(cuadroDespl);
        cuadritoDes.selectByVisibleText("ARUBA");
        Thread.sleep(5000);

        String textBox = cuadroDespl.getText();
        System.out.println(textBox);
        Thread.sleep(5000);

        driver.close();

    }

    public static void main(String[] args) throws InterruptedException {

        Ejemplo008 e8 = new Ejemplo008();
        e8.rutaInicio();
        e8.startTest();

    }

}
