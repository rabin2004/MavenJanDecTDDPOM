package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class RegisterPage extends Base{
	@FindBy(name="email")
	WebElement usernameTxtField;
	@FindBy(name="password")
	WebElement passwordTxtField;
	@FindBy(name="confirmPassword")
	WebElement confirmPasswordTxtField;
	@FindBy(name="submit")
	WebElement submitBtn;
	
	// loading all element into driver
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	// define functionality
	public void enterUsername(String username) {
		usernameTxtField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordTxtField.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordTxtField.sendKeys(confirmPassword);
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}
	
	public String returnRegisterPageTitle() {
		return driver.getTitle();
	}
	
	public String returnRegisterPageURL() {
		return driver.getCurrentUrl();
	}

}
