package testCases;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
   
	@Test
	public void verify_login() throws IOException
	{
		logger.info("*** Starting TC002_loginTest *** ");
		HomePage hp=new HomePage(driver);
		hp.clickMyccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clkLoginBtn();
		
	}
	
}
