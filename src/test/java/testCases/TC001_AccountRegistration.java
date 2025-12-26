package testCases;


import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass{

	
	
	
	@Test
	public void verify_account_registration()
	{
		logger.info("***  Starting TC001_AccountRegistration **** ");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyccount();
		logger.info("clicked on Accountlink");
		hp.clickRegister();
		logger.info("clicked on Registerationlink");
		
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Giving the customer information....");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String Password=randomAlphaNumberic();
		regpage.setPassword(Password);
		regpage.setcnfirmPassword(Password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("validating successful message");
		String cnfrmmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(cnfrmmsg, "Your Account Has Been Created!");
		}catch(Exception e)
		{
			logger.error("Test failed...");
			logger.debug("Debug logs");
		}
		
		logger.info("***  finished TC001_AccountRegistration ****");
	}
	
	
	
	
	

}
