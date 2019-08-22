package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage extends PageBase {

	public AdminLoginPage(WebDriver driver) {
		super(driver);
			  
	  }

	// login form elements

	@FindBy(name="email")
	WebElement adminnameTxtbox;

	@FindBy(name="password")
	WebElement adminPasswordTxtbox;

	@FindBy(id="login-form-submit")
	WebElement adminLoginBtn ;
	
	
// method to add username and password to login form 
	
	public void Adminlogin (String email , String password)
	{
		setTextElementText(adminnameTxtbox, email);
		setTextElementText(adminPasswordTxtbox, password);
		clickbutton(adminPasswordTxtbox);
	}
	


}