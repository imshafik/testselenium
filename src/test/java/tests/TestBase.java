package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import utilities.Helper;

public class TestBase {


	
	public static WebDriver driver ;
	@BeforeSuite
	public void startdriver ()
	
	{
		System.setProperty("webdriver.chrome.driver" ,System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("http://demo.epsilonsocial.com/login");
	}
	

	@AfterSuite
	public void stopdriver()

	{
	}
	// take screenshot when test case failed
	@AfterMethod
	public void screenshotonfailure (ITestResult result)
	{

		if (result.getStatus() == ITestResult.FAILURE )
		{
			System.out.println("Faild .....");
			System.out.println("Taking ScreenShot .....");
			Helper.capturescreenshot(driver, result.getName());
		}
	}


}
