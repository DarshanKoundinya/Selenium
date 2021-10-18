package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseClass 
{
	public WebDriver driver;
	public Properties prop;
	
	//Method to invoke all properties of web driver
	public WebDriver InitializeDriver() throws IOException
	{
		//Read browser file from properties file(data) created and use it
		prop = new Properties();
		//FileInputStream fis = new FileInputStream("D:\\DARSHAN\\@@_Java&SeleniumProjects_@@\\MainProject\\E2EProjectOne\\src\\main\\java\\Resources\\data.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		//String browserName = prop.getProperty("browser"); //to load browser from the properties defined
		String browserName = System.getProperty("browser"); // to load browser from the mvn command (to test using maven commands
		//"mvn test -Dbrowser=browserName")
		
		//select chrome or firefox based on the browser called
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions(); //for headsless chrome or any other			
			//options.addArguments("headless"); //to run tests in headless chrome
			//WE CAN ALSO USE HTML UNIT DRIVER
			driver =  new ChromeDriver(options);
		}
		
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			FirefoxOptions optionsF = new FirefoxOptions();
			optionsF.addArguments("headless");
			driver =  new FirefoxDriver();
		}
		
		//create some default implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void getURL(WebDriver dr)
	{
		//dr.get(prop.getProperty("url"));
		dr.get(prop.getProperty("url_second"));
	}
	
	public String getScreenshotPath(String failedTestCaseName, WebDriver driver2) throws IOException
	{
		TakesScreenshot screenShot = (TakesScreenshot)driver2;
		File source = screenShot.getScreenshotAs(OutputType.FILE); //file is in virtual system yet, to get this into local system
		String destinationFilePath = System.getProperty("user.dir")+"\\reports\\"+failedTestCaseName+".png"; //path to store the test case screenshot
		FileUtils.copyFile(source, new File(destinationFilePath)); //will be used to copy the source file to local system
		return destinationFilePath;
	}	
}

