package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	@BeforeClass(groups = {"Regression","Sanity","Master"})
	@Parameters("browser")
	public void setUp(String browserName)
	{
		logger = LogManager.getLogger(this.getClass());
		
		rb= ResourceBundle.getBundle("config");
		
		//ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		if(browserName.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else {
			System.out.println(browserName+" driver is not configured");
			throw new RuntimeException(browserName+" driver is not configured");
		}
		
		//WebDriverManager.chromedriver().setup();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(rb.getString("URL"));
		
	}
	
	
	public String randomAlphabetic(int length)
	{
		return RandomStringUtils.randomAlphabetic(length);
	}
	
	
	public String randomNumeric(int length)
	{
		return RandomStringUtils.randomNumeric(length);
	}
	
	
	public String randomAlphaNumeric()
	{
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		return str+num;
	}
	
	
	public String CaptureScreen(String tname)
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\"+tname+"_"+timeStamp+".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destination;
	}
	
	
	@AfterClass(groups = {"Regression","Sanity","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
