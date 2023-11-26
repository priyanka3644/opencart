package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(id = "input-firstname")
	private WebElement fname;
	
	@FindBy(id = "input-lastname")
	private WebElement lname;
	
	@FindBy(name = "email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPwd;
	
	@FindBy(name="agree")
	private WebElement acceptPolicy;
	
	@FindBy(css = "input[value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//h1[contains(text(),\"Created\")]")
	private WebElement message;
	
	
	public void setFirstName(String firstname)
	{
		fname.sendKeys(firstname);
	}
	
	public void setLastname(String lastName)
	{
		lname.sendKeys(lastName);
	}
	
	public void setEmail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void setTelephone(String number)
	{
		telephone.sendKeys(number);
	}
	
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void confirmPwd(String confirmPassword)
	{
		confirmPwd.sendKeys(confirmPassword);
	}
	
	public void clickAceptPolicy()
	{
		acceptPolicy.click();
	}
	
	public void ClickContinue()
	{
		continueBtn.click();
	}
	
	
	public String confirmationMessage()
	{
		String msg = message.getText();
		return msg;
	}
	
}

