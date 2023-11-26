package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass{
	
	
	@Test(groups= {"Sanity","Master"})
	public void login()
	{
		
		try {
			logger.info("**** starting TC_002_Login **** ");
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLoginLink();
			
			LoginPage lp = new LoginPage(driver);
			lp.enterEmailAddress("priyankasanka@gmail.com");
			lp.enterPassword("Priya@123");
			lp.clickLogin();
			
			MyAccountPage map = new MyAccountPage(driver);
			String message = map.getMessage();
			Assert.assertEquals(message,"My Account");

		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("**** TC_002_Login ended ****");
	}

}
