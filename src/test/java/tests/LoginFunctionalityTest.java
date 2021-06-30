package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.LoginSuccessPage;

public class LoginFunctionalityTest extends Base{
	HomePage hp;
	LoginSuccessPage lsp;
	
	@BeforeMethod
	public void loadBrowser() {
		intialization();
		new HomePage();
		new LoginSuccessPage();
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
	
	@Test(dataProvider="Positive login data")
	public void positiveLoginFunctionalityTest(String username, String password) {
		// browser->app->hompage->valid username & password -> hit submit btn -> login successful
		
		// If user is in homepage or not
		Assert.assertEquals(hp.returnHomePageTitle(), prop.getProperty("homePageTitle"));
		
		// test steps
		hp.enterUsername(username);
		hp.enterPassword(password);
		hp.clickSubmitBtn();
		
		// validation points
		Assert.assertTrue(lsp.validateLoginSuccessMsg());
		Assert.assertEquals(lsp.returnLoginSuccessPageTitle(), prop.get("loginSuccessPageTitle"));
		Assert.assertEquals(lsp.returnLoginSuccessPageURL(), prop.getProperty("loginSuccessPageURL"));	
	}
	
	@DataProvider(name = "Positive login data")
	public Object[][] getData() {
		Object[][] data = {{"test123", "123"},{"test", "123"}};
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
