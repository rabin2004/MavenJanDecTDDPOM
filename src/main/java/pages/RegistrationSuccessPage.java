package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class RegistrationSuccessPage extends Base{
	@FindBy(xpath="//table[@width='492']/tbody/tr[3]")
	WebElement registrationSuccessMsg;
	
	public RegistrationSuccessPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateRegistrationSuccessMsg() {
		return registrationSuccessMsg.isDisplayed();
	}
	
	public String returnRegistrationSuccessPageTitle() {
		return driver.getTitle();
	}
	
	public String returnRegistrationSuccessPageURL() {
		return driver.getCurrentUrl();
	}

}
