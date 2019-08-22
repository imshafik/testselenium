package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddNewUserPopUp extends PageBase {

	public AddNewUserPopUp(WebDriver driver) {
		super(driver);
	}
	// users links element 


	@FindBy(id="name")  	WebElement nametxtbox ;

	@FindBy(id="email") 	WebElement emailtxtbox ;

	@FindBy(id="password")	WebElement passwordtxtbox ;

	@FindBy(id="role_id")	WebElement companyroleselctbox ;

	@FindBy(id="company_id") 	WebElement Selectcompany  ;

	@FindBy(name="competitive_companies[]") 	WebElement competitivecompaniesbox ;

	@FindBy(name="is_active") 	WebElement activecheckbox ;

	@FindBy(xpath="//input[@class='btn green']") 	WebElement saveuserbtn ;

	

	public void addcompanyname (String Name)
	{
		nametxtbox.sendKeys(Name);
		Assert.assertEquals(nametxtbox.getAttribute("value"), Name);
	}
	
	public  void addcompanyemail (String Email)
	{
		emailtxtbox.sendKeys(Email);
		Assert.assertEquals(emailtxtbox.getAttribute("value"), Email);
	}

	public void addpassword (String Password)
	{
		passwordtxtbox.sendKeys(Password);
		Assert.assertEquals(passwordtxtbox.getAttribute("value"), Password);
	}
	public void addcompanyrole (String Companyrole)
	{
		companyroleselctbox.sendKeys(Companyrole);
		Assert.assertEquals(companyroleselctbox.getAttribute("value"), Companyrole);
	}

	public void selectcompany (String value)
	{
		Select select = new Select(Selectcompany) ;
		select.selectByValue(value);
		

	}
	public void selectcompetitivecompanies (String value)
	{
		Select select = new Select(competitivecompaniesbox) ;
		select.selectByValue(value);
		
	}
		public void checkactivebox ()
	{
		activecheckbox.click();
		
	}
		public void saveuserdata ()
		{
			saveuserbtn.click();
			
		}
	
	
}
