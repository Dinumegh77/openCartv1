package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public  Properties p;
	

	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		//loading config.properties
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		switch(br.toLowerCase())
		{
		case "chrome" :driver=new ChromeDriver();break;
		case "edge" :driver=new EdgeDriver();break;
		case "firefox" :driver=new FirefoxDriver();break;
		default : System.out.println("Invalid browser");return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public String randomString() {
		String generateString= RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}
	
	public String randomNumber() {
		String generateNum= RandomStringUtils.randomNumeric(10);
		return generateNum;
	}
	
	public String randomAlphaNumberic() {
		String generateString= RandomStringUtils.randomAlphabetic(5);
		String generateNum= RandomStringUtils.randomNumeric(10);
		return (generateString+generateNum);
	}
	
	@AfterClass
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}
