package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegistrationSuccessPage;

public class RegistrationFunctionalityTest extends Base{
	HomePage hp;
	RegisterPage rp;
	RegistrationSuccessPage rsp;
	
	@BeforeMethod
	public void loadBrowser() {
		intialization();
		hp = new HomePage();
		rp = new RegisterPage();
		rsp = new RegistrationSuccessPage();
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
	
	@Test(dataProvider = "Positive registration data")
	public void positiveRegistrationpageFunctionalityTest(String username, String password) {
		//homepage -> Register link -> registerPage -> provide details -> submit -> register successful
		hp.clickRegisterLink();
		Assert.assertEquals(rp.returnRegisterPageTitle(), prop.getProperty("registerPageTitle"));
		
		rp.enterUsername(username);
		rp.enterPassword(password);
		rp.enterConfirmPassword(password);
		rp.clickSubmitBtn();
		
		Assert.assertTrue(rsp.validateRegistrationSuccessMsg());
		Assert.assertEquals(rsp.returnRegistrationSuccessPageURL(), prop.getProperty("registerSuccessPageURL"));
	}
	
	@DataProvider(name = "Positive registration data")
	public Object[][] getData() {
		Object[][] data = {{"david123", "1234"},{"tommy123", "1234"}};
		return data;
	}

	
	
	
	
	
	
	
	
	
	
}
