package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatePickerPage extends PageBase{

    public DatePickerPage() {
		super(driver);
	}

	

    @FindBy(id = "datepicker")
    private WebElement dateField;

    @FindBy(id = "ui-datepicker-div")
    private DatePickerPage datePicker;
    
  @FindBy (xpath = "//a[@class='ui-state-default ui-state-highlight']")
  WebElement today ;

    public void goTo() {
        driver.get("https://jqueryui.com/datepicker/");
        DatePickerPage.driver.switchTo().frame(0);
        this.datePicker = new DatePickerPage();
    }

    public DatePickerPage getDatePicker() {
        dateField.click();
        return datePicker;
    }

    public String getSelectedDate() {
        return this.dateField.getAttribute("value");
    }

	public  String setDate(String ipDate) {

		dateField.click();
		return ipDate;
	}
		public void clickselecteddate ()
	{
		today.click();
	}
    
}