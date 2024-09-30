package testCase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.Account_registration_page;
import pageObject.HomePage;

public class TC001_Account_Regristration_Test {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().window().maximize();
	}
	
	@AfterClass
    public void tearDown() {
		driver.quit();
	 
    }
	
	@Test
    public void verify_Account_Registration() {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		Account_registration_page arp=new Account_registration_page(driver);
		arp.setFirstName("walman");
		arp.setLastName("pli");
		arp.setEmail("qalmanalooi@gmail.com");
		arp.setTelephone("56455544888");
		arp.setPassword("ash@1236");
		arp.setConfermPassword("ash@1236");
		arp.setPrivacyPolicy();
		arp.setButton();
		String actualmsg = arp.getConfirmation();
		Assert.assertEquals(actualmsg, "Your Account Has Been Created!");
     }
	
}
