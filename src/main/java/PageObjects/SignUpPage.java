package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage 
{
	public WebDriver driver;
	
	public SignUpPage(WebDriver driverSignUpPage)
	{
		this.driver = driverSignUpPage;
	}
	
	By inputFullName = By.id("user_name");
	By inputEmail = By.id("user_email");
	By inputPassword = By.id("password");
	By checkButton = By.xpath("//input[@type='checkbox']");
	By signUpButton = By.xpath("//input[@value ='Sign up']");
	
	public WebElement getFullName()
	{
		return driver.findElement(inputFullName);
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(inputEmail);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(inputPassword);
	}
	
	public WebElement getCheckButton()
	{
		return driver.findElement(checkButton);
	}
	
	public WebElement getSignupButton()
	{
		return driver.findElement(signUpButton);
	}
}
