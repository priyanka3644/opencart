package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import testBase.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void Login_dataDriven(String email, String password, String isValid)
	{
		try {
			logger.info("**** starting TC_003_Login using DataProvider **** ");
			System.out.println("------------------"+email+"---"+password+"--------------------");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLoginLink();
			
			LoginPage lp = new LoginPage(driver);
			lp.enterEmailAddress(email);
			lp.enterPassword(password);
			lp.clickLogin();
			
			MyAccountPage map = new MyAccountPage(driver);
			String message = map.getMessage();
			boolean isLoginSuccesss= false;
			
			if(message.equals("My Account"))
			{
				isLoginSuccesss=true;
			}
			else {
				isLoginSuccesss=false;
			}
			System.out.println("isLoginSuccess "+isLoginSuccesss);
			
			Thread.sleep(3000);
			
			if(isValid.equalsIgnoreCase("Valid"))
			{
				if(isLoginSuccesss){
					System.out.println("Valid - LoginSuccess");
					Assert.assertTrue(true);
					map.Logout();
				}
				
				else
				{
					System.out.println("Valid - LoginFail");
					Assert.assertTrue(false, "Login failed for valid data");
				}
			}
			
			
			if(isValid.equalsIgnoreCase("Invalid"))
			{
				if(!isLoginSuccesss)
				{
					System.out.println("InValid - LoginFail");

					Assert.assertTrue(true);
				}
				else
				{
					System.out.println("InValid - Login Success");

					Assert.assertTrue(false,"Login passed for invalid data set");
					map.Logout();
				}
			}

		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("**** TC_003_Login using dataprovider ended ****");
	}

}
