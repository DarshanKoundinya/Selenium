package Practice.E2EProjectOne;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.SignUpPage;
import Resources.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseClass
{
	
	/*
	@Test
	public void basePageNavigationSignup() throws IOException
	{
		driver = InitializeDriver();
		driver.get("https://www.rahulshettyacademy.com/");
		
		//Main page interactions - clicking on Sign up button
		LandingPage lp = new LandingPage(driver);		
		lp.getLogin().click();
		
		//Logging to the main page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getSignupButton().click();
		
		//Signing up to the page
		SignUpPage signUp = new SignUpPage(driver);
		signUp.getFullName().sendKeys("Darshan Koundinya");
		signUp.getEmail().sendKeys("darshankoundinya.learning@gmail.com");
		signUp.getPassword().sendKeys("dksr@1394");
		signUp.getCheckButton().click();
		signUp.getSignupButton().click();
	}
		
	*/
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	@BeforeTest
	public void BeforeTestExample() throws IOException
	{
		driver = InitializeDriver();
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigationLogin(String userName, String passWord) throws IOException, InterruptedException
	{
		
		//driver.get("https://www.rahulshettyacademy.com/#/index");
		getURL(driver);
		//Main page interactions - clicking on Login button
		//LandingPage lp = new LandingPage(driver);
		//lp.getLogin().click();
		//new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(lp.getLogin()));
		
		//Logging in using email and password
		LoginPage loginPage = new LoginPage(driver);		
		loginPage.getEmail().sendKeys(userName);
		Thread.sleep(2500);
		loginPage.getPassword().sendKeys(passWord);	
		Thread.sleep(2500);
		//System.out.println(message);		
		loginPage.getRememberPwCheckbox().click();
		Thread.sleep(2000);
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(loginPage.getLoginButton()));
		loginPage.getLoginButton().click();
		log.info("Validated logging into the page");
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//row stands for how many different data types test should run
		//column stands for how many values per each test
		Object[][] data = new Object[3][2];
		
		data[0][0] = "darshankoundinya.learning@gmail.com";
		data[0][1] = "dksr@1394";
		
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "dksr@1394";
		
		data[2][0] = "nonrestricteduser@gmail.com";
		data[2][1] = "";
		
		return data;		
	}
	
	
	@AfterTest
	public void AfterTestExecution()
	{
		driver.close();
		log.info("Driver is closed");
	}
	
	
}
