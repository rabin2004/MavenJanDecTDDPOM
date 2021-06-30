package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class HomePage extends Base{
	// Creating Page Factory:
	
	// creating webElement
	@FindBy(name="userName")
	WebElement usernameTxtField;
	@FindBy(name="password")
	WebElement passwordTxtField;
	@FindBy(name="submit")
	WebElement submitBtn;
	@FindBy(linkText="REGISTER")
	WebElement registerLink;
	
	// loading all element into driver
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// define functionality
	public void enterUsername(String username) {
		usernameTxtField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordTxtField.sendKeys(password);
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}
	
	public void clickRegisterLink() {
		registerLink.click();
	}
	
	public String returnHomePageTitle() {
		return driver.getTitle();
	}
	
	public String returnHomePageURL() {
		return driver.getCurrentUrl();
	}
	
}
