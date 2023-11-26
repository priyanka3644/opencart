package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement MyAccountTxt;
	
	@FindBy(xpath = "//div/a[text()='Logout']")
	private WebElement logoutLink;
	
	public String getMessage()
	{
		String msg="";
		try {
			msg=MyAccountTxt.getText();
		}
		catch(Exception e)
		{
			System.out.println("My account page doesnot exist");
		}
		return msg;
	}
	
	
	public void Logout()
	{
		logoutLink.click();
	}
}
