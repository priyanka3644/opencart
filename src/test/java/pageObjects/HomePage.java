package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(css = "a[title='My Account']")
	private WebElement myAccountDropdown;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerlink;
	
	
	@FindBy(linkText = "Login")
	private WebElement loginLink;
	
	
	public void clickMyAccount()
	{
		myAccountDropdown.click();
	}
	
	public void clickRegisterLink()
	{
		registerlink.click();
	}
	
	public void clickLoginLink()
	{
		loginLink.click();
	}

}
