package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminmainPage extends PageBase
{

	public AdminmainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(linkText="Users")
	WebElement userslink;

	@FindBy (xpath = "//a[@href='http://test.epsilonsocial.com/admin/users']")
	WebElement userpagelink ;

	// add new user element 
	@FindBy (xpath = "//a[@class='btn blue btn-outline sbold']")
	WebElement adduserbtn ;
	
	@FindBy(linkText="Posts")
	WebElement postslink;

	@FindBy(xpath = "//a[@title='edit']")
	WebElement editpost;
	
	@FindBy(id="own_post")
	WebElement ownpost;
	
	@FindBy (xpath = "//input[@class='btn btn-lg green']")
	WebElement savebtn ;
	
	
	public void openpostspage()  
	{

		clickbtn(userslink);
		clickbtn(userpagelink);
		clickbtn(adduserbtn);

	}
	public void editpostspage()  
	{

		clickbtn(postslink);
	}
	public void ownpost()  
	{
    ownpost.click();
    savebtn.click();
	}
}
