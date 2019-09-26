package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.DataManager;
import Pages.HomePage;
import Pages.LoginPage;

public class TestRoundTrip extends TestBase {

	LoginPage LoginPageObject ; 
	DataManager dataManagerObject ;
	HomePage HomePageObject ;
	

	@BeforeMethod
	public void beforeTest() throws InterruptedException {
		System.out.println("Open Browser");
		LoginPageObject = new LoginPage(driver); 
		driver.get("https://test.epsilonsocial.com/login");
		Thread.sleep(1000);
		//	driver.manage().window().maximize();
	}

	// Selenium-TestNG Execution Engine
	@Test(dataProvider = "Usersdata" )
	public void Login_Epsilon_Front_End(String UserNamevalue, String Passwordvalue )
					throws InterruptedException, IOException {

		// Insert Origin into Flying from text box
		LoginPageObject.UserLogin(UserNamevalue, Passwordvalue);
		HomePageObject.clickonLogout();
		
	}
		

	// Data Provider
	@DataProvider(name = "Usersdata")
	public Object[][] datasupplier() throws Exception {
		final String xlsxFile = System.getProperty("user.dir") + "\\Resources\\test_input.xlsx";
		Object[][] arrayObject = DataManager.getExcelData(xlsxFile, "Sheet1");
		return arrayObject;
	}

	// Utility Functions	
}	
