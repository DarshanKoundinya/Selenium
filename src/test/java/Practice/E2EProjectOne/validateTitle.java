package Practice.E2EProjectOne;


import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.BaseClass;

public class validateTitle extends BaseClass{
	public WebDriver driver;
	 public static Logger log =LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =InitializeDriver();
		 log.info("Driver is initialized");
			
		driver.get(prop.getProperty("url_second"));
		 log.info("Navigated to Home page");
	}
	@Test
	
	public void ValidatPageTitleAfterLogin() throws IOException
	{
		
		//one is inheritance
		// creating object to that class and invoke methods of it
		LoginPage l=new LoginPage(driver);
		l.getLoginButton().click();
		//compare the text from the browser with actual text.- Error..
		//Assert.assertEquals(l.getTitle().getText(), "FEATURED CO123URSES");
		Assert.assertEquals(l.getTitle().getText(), "ACME");
		 log.info("Successfully validated Text message");
		 System.out.println("Test completed");
		 
		;
	
		
		}
	@AfterTest
	public void teardown()
	{		
		driver.close();	
		
	}

	

	
}
