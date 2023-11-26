package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement email;
	
	
	@FindBy(id="input-password")
	private WebElement password;
	
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBtn;

	
	public void enterEmailAddress(String emailid)
	{
		email.sendKeys(emailid);
	}
	
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginBtn.click();
	}
	
	
}
