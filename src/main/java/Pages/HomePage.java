package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	//main tabs in home page 

	WebElement TimeLineBtn = driver.findElement(By.linkText("Time Line"));
	WebElement MyPagetab = driver.findElement(By.linkText("My Page"));
	WebElement competitionstab = driver.findElement(By.linkText("Competitions"));
	WebElement Globaltab = driver.findElement(By.linkText("Global"));



	public void clickontimeline()
	{
		TimeLineBtn.click();

	}public void clickonmypage()
	{
		MyPagetab.click();

	}public void clickoncompetitionstab()
	{
		competitionstab.click();

	}
	public void clickonglobaltab()
	{
		Globaltab.click();

	}


}
