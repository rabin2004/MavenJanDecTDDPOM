package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public static Properties prop;
	public static WebDriver driver;
	
	public Base() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\User\\Desktop\\eclipse\\"
					+ "JanDecTDDPOMframework\\src\\properties\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void intialization() {
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromePath"));
			driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty(prop.getProperty("firefoxKey"), prop.getProperty("firefoxPath"));
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("internet explorer")) {
				System.setProperty(prop.getProperty("ieKey"), prop.getProperty("iePath"));
				driver = new InternetExplorerDriver();
			}else{
				System.out.println("Browser is not in the scope for testing.");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("QAEnvURL"));
	}
	
	public static void tearDown() {
		driver.close();
	}

}
