package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass{

	
	@Test(groups= {"Regression","Master"})
	public void registerAccount()
	{
		logger.info("**** starting TC_001_AccountRegistrationTest ****");
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on MyAccount dropdown");
			
			hp.clickRegisterLink();
			logger.info("clicked on Rgister link");
			
			AccountRegistrationPage ap = new AccountRegistrationPage(driver);
			logger.info("Providing customer data");
			ap.setFirstName(randomAlphabetic(6));
			ap.setLastname(randomAlphabetic(4));
			ap.setEmail(randomAlphabetic(5)+"@gmail.com");
			ap.setTelephone(randomNumeric(10));
			
			String password = randomAlphaNumeric();
			ap.setPassword(password);
			ap.confirmPwd(password);
			ap.clickAceptPolicy();
			ap.ClickContinue();
			logger.info("Clicked on continue Button");
			String message = ap.confirmationMessage();
			System.out.println(message);
			
			logger.info("Validating expected message");
			Assert.assertEquals(message, "Your Account Has Been Created!","Not getting expected message");
			
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception while registering account");
			Assert.fail();
		}
		
		logger.info("**** TC_001_ ended............ ****");
		
	}
	
	
}
