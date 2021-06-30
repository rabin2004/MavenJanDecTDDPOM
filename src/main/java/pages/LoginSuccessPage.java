package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class LoginSuccessPage extends Base{
	@FindBy(xpath="//table[@width='492']/tbody/tr[1]")
	WebElement loginSuccessMsg;
	
	public LoginSuccessPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLoginSuccessMsg() {
		return loginSuccessMsg.isDisplayed();
	}
	
	public String returnLoginSuccessPageTitle() {
		return driver.getTitle();
	}
	
	public String returnLoginSuccessPageURL() {
		return driver.getCurrentUrl();
	}

}
