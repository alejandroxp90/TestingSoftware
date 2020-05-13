package org.scripts.intermedio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckLinksTest {

        WebDriver driver;
        CheckLinks page;
      //  String baseURL = "http://www.domylab.com/home/site_arq_main.php";
       // String baseURL = "http://newtours.demoaut.com/";
    String baseURL = "https://es.duolingo.com/course/en/es/Aprender-ingl%C3%A9s";

        @BeforeClass
        public void beforeClass(){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe");
            driver = new ChromeDriver();
            page = new CheckLinks(driver);
            driver.get(baseURL);

        }

        @Test
        public void checkingLinks(){
           // assertFalse(page.checkingPageLinks(),"There are broken links");
            assertTrue(page.checkingPageLinks(),"There are broken links");
        }

        @AfterClass
        public void afterClass(){
            driver.close();
        }

    }
