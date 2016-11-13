package com.test.AUTReporting;


import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;

//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })


public class ReporterTest {

    {
        System.setProperty("atu.properties", "E:/Automation workspace/AdvanceReporting/atu.properties");
    }

     WebDriver driver;
    
     String baseUrl;
    

    @BeforeClass
    public void setUp() throws Exception {
        
    	 System.setProperty("webdriver.chrome.driver", "E:/Selenium/chromedriver.exe");
    	 
    	 driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
    
        baseUrl = "http://newtours.demoaut.com/";
        
        driver.get(baseUrl);

        // ATU Reports
        ATUReports.setWebDriver(driver);
        
        ATUReports.indexPageDescription = "Test Project";
    }

    @Test
    public void Mercurylogin() throws Exception, SQLException {
        
    	

      	WebElement utext = driver.findElement(By.xpath("//input[@name='userName']")) ; 
      	WebElement ptext = driver.findElement(By.xpath("//input[@name='password']")) ; 
          

    	try {
    		
    	if (utext.isEnabled()) { 
    		utext .sendKeys("tutorial"); 
    		  }
    	
    	if (ptext.isEnabled()) { ptext .sendKeys("tutorial");  }
    	
    	} catch(NoSuchElementException nsee)
    	
    	{
    	
    		System.out.println(nsee.toString()); 
    		
    	
    	}
    	
    	
    	
    	driver.findElement(By.name("login")).click();
    	
    	driver.close();
    	
    	
    	
    }

    
    
 /*   // ATU Reports Method
    @Test
    public void testNewLogs() throws AWTException, IOException {

        ATUReports.add("INfo Step", LogAs.INFO, new CaptureScreen(
                ScreenshotOf.BROWSER_PAGE));
        ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
                ScreenshotOf.DESKTOP));
        WebElement element = driver
                .findElement(By.xpath("/html/body/div/h1/a"));
        ATUReports.add("Warning Step", LogAs.WARNING,
                new CaptureScreen(element));
        ATUReports.add("Fail step", LogAs.FAILED, new CaptureScreen(
                ScreenshotOf.DESKTOP));
    }*/

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}
