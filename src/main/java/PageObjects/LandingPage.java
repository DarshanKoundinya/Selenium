package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{	
	public WebDriver driver;
	
	//to avoid null pointer issue we create a constructor
	public LandingPage(WebDriver d)
	{
		this.driver = d;
	}
	
	By signIn = By.cssSelector("a.theme-btn.register-btn");	
	By signIn2 = By.linkText("Login");
	By signIn3 = By.cssSelector("a[href*='sign_in']");
	
	public WebElement getLogin()
	{
		return driver.findElement(signIn3);
	}	
	
	
}
