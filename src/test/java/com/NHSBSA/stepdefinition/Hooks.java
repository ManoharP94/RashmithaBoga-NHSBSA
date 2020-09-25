package com.NHSBSA.stepdefinition;


import cucumber.api.Scenario;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import envReader.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;

public class Hooks {
	
	public static String browser;
    public static WebDriver driver;
    
    Scenario scenario;

    @Before
    public void beforeStartUp(Scenario scenario) throws IOException
    {
    		browser = EnvironmentPropertiesReader.getProperty("browser");
    	
    		if (browser.equalsIgnoreCase("chrome"))
            {
    			
    			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//" + EnvironmentPropertiesReader.getProperty("chromeDriverPath"));
    	        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    			
    			driver = new ChromeDriver();
    	        driver.manage().window().maximize();
            }
    		
    		else if (browser.equalsIgnoreCase("firefox"))
    		{
                
    			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//" + EnvironmentPropertiesReader.getProperty("drivers/chromedriver.exe"));
    			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
    			
    			driver = new FirefoxDriver();
                driver.manage().window().fullscreen();
    		}
  }


    @After
    public void after (Scenario scenario) throws IOException
    {
        // ---------- Takes screenshot if Scenario Fails  -------------------- //
        if (scenario.isFailed() )
        {
            File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                   FileUtils.copyFile(scrFile, new File("target/site/screenshots/"+scenario.getName()+".png"));
                }
                catch (IOException e)
                {
                  e.printStackTrace();
                }

            // Embend the screenshot if test failes
            try {
                  scenario.write("Current Page URL is " + driver.getCurrentUrl());
                  byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                  scenario.embed(screenshot, "image/png");
                }
             catch (WebDriverException somePlatformsDontSupportScreenshots)
             {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
             }
        }
        
       driver.quit();
     }

}
