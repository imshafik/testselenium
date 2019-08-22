package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisrationPage extends PageBase 
{

	public UserRegisrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub

	}

	@FindBy(id="title")
	WebElement titletxtbox ;

	@FindBy(id="select2-source-container")
	WebElement sourcetxtbox ;

	@FindBy(id="select2-post_type-container")
	WebElement posttypetxtbox ;

	@FindBy(id="post_title")
	WebElement posttitletxtbox ;

	@FindBy(id="post_image")
	WebElement postimagetxtbox ;

	@FindBy(id="post_link")
	WebElement postlinktxtbox ;

	@FindBy(id="post_datetime")
	WebElement postdatebox ;

	@FindBy(id="post_content")
	WebElement postcontenttxtbox ;

	@FindBy(xpath="//input[@type='submit']")
	WebElement savepostbtn ;


	public void savepost(String Title , String Source , String PostType , String postTitle , String PostImage ,
			String PostLink , String PostDateTime, String PostContent) 

	{
		titletxtbox.sendKeys(Title);
		sourcetxtbox.sendKeys(Source);
		posttypetxtbox.sendKeys(PostType);
		posttitletxtbox.sendKeys(postTitle);
		postimagetxtbox.sendKeys(PostImage);
		postlinktxtbox.sendKeys(PostLink);
		postdatebox.sendKeys(PostDateTime);
		postcontenttxtbox.sendKeys(PostContent);
		clickbutton(savepostbtn);
	}



}
