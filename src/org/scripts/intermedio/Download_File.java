package org.scripts.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.util.HashMap;
import static org.testng.Assert.assertTrue;

public class Download_File {

    private WebDriver driver;
    private String xPath = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
    private String downloadFilePath = "C:\\Users\\Odinn\\Downloads\\TEST";

  @BeforeClass
    public void beforeClass(){
      System.setProperty("webdriver.chrome.driver", xPath);
      HashMap<String,Object> chromePrefs = new HashMap<String,Object>();
      chromePrefs.put("profile.default_content_settings.popups",0);
      chromePrefs.put("download.default_directory", downloadFilePath);

      ChromeOptions options = new ChromeOptions();
      options.setExperimentalOption("prefs", chromePrefs);
      driver = new ChromeDriver(options);
  }

  @Test
    public void test() throws InterruptedException {

      driver.get("https://the-internet.herokuapp.com/download");
      driver.findElement(By.linkText("some-file.txt")).click();
      Thread.sleep(2000);
      File folder = new File(downloadFilePath);
      File[] listofFiles = folder.listFiles();
      assertTrue(listofFiles.length>0, "Files not download correctly");
      System.out.println("El numero de archivos en la carpeta es: " + listofFiles.length);

  }

  @AfterClass
    public void afterClass() throws InterruptedException {
    Thread.sleep(5000);
      driver.close();

  }

}
