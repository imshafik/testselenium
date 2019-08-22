package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name="email")
	WebElement UsernameTxtbox;

	@FindBy(name="password")
	WebElement PasswordTxtbox;

	@FindBy(id="login-form-submit")
	WebElement LoginBtn ;
	
	@FindBy (xpath="//div[@class='sb-msg']")
	WebElement errormessage ;


	public void UserLogin (String email , String password)
	{
		setTextElementText(UsernameTxtbox, email);
		setTextElementText(PasswordTxtbox, password);
		clickbutton(LoginBtn);
	
		}

	}
	