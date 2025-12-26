package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="input-firstname")
	WebElement txtFirstName;
	
	@FindBy(id="input-lastname")
	WebElement txtLastName;
	
	@FindBy(id="input-email")
	WebElement txtEmail;
	
	@FindBy(id="input-telephone")
	WebElement txtTelePhone;
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(id="input-confirm")
	WebElement txtConfirmPassword;
	
//	@FindBy(xpath="//label[text()='Yes']")
//	WebElement btnSubscribe;
//	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement chkAgree;
	
	@FindBy(xpath="//input[@class=\"btn btn-primary\"]")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelePhone.sendKeys(tel);
	}
	
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setcnfirmPassword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkAgree.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try
		{
			return (msgConfirmation.getText());
		}catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	
	
}
