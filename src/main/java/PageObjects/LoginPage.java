package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	public WebDriver driver;
	
	//to avoid null pointer issue we create a constructor
	public LoginPage(WebDriver d)
	{
		this.driver = d;
	}
	
	By emailID = By.id("email");
	By password = By.id("password");
	By loginButton = By.xpath("//input[@type='submit']");
	By signUp = By.linkText("Sign Up");
	By rememberCheckbox = By.id("remember_me");
	
	//WebElement emailID2, passWord2, loginButton2;
	/*  //this method doesnt work as there is dependency with respect to data provider in HomePage class
	public void PerformLogin(String uN, String pW)
	{
		emailID2 = driver.findElement(By.id("username"));
		passWord2 = driver.findElement(By.id("password"));
		loginButton2 = driver.findElement(By.id("log-in"));
		
		emailID2.sendKeys(uN);
		passWord2 .sendKeys(pW);
		loginButton2.click();
	}
	*/
	
	public WebElement getEmail()
	{
		//return driver.findElement(emailID); //for first URL
		return driver.findElement(By.id("username")); //for second URL
	}
	
	public WebElement getPassword()
	{
		//return driver.findElement(password);
		return driver.findElement(By.id("password"));
	}
	
	public WebElement getLoginButton()
	{
		//return driver.findElement(loginButton);
		return driver.findElement(By.id("log-in"));
	}
	
	public WebElement getSignupButton()
	{
		return driver.findElement(signUp);
	}
	
	public WebElement getRememberPwCheckbox()
	{
		//return driver.findElement(rememberCheckbox);
		return driver.findElement(By.xpath("//input[@class='form-check-input']"));
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(By.xpath("//div[@class='logo-label']"));
	}
}
