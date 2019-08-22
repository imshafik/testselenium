package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PageBase {

	protected static WebDriver driver;
	//create constructor
	public PageBase (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	


	protected static void clickbutton(WebElement button) {
		button.submit();
	}

	protected static void setTextElementText (WebElement TextElement , String value) {
		TextElement.sendKeys(value);
	}

	
	protected static void clickbtn(WebElement btn) {
		btn.click();
	}

	}
	

	

