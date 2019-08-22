package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class commentsfrommypage extends PageBase {

	public commentsfrommypage(WebDriver driver) {
		super(driver);
	}
	

	WebElement ViewAnalisys = driver.findElement(By.xpath("//a[@href='https://test.epsilonsocial.com/my-page/5d0a1c9c206627052c2f35df/show']"));
	WebElement showcomment = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
	WebElement viewpostnface = driver.findElement(By.xpath("//a[@class='btn btn-info widget-btn-blue']"));

	public void clickonviewanalisys()
	{
		clickbutton(ViewAnalisys);

	}
	public void clickonshowcomment()
	{
		showcomment.click();

	}
	public void clickonviewpostnface()
	{
		viewpostnface.click();

	}
	
}
