package testCase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.Account_registration_page;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_Account_Regristration_Test extends BaseClass{
	//WebDriver driver;
	@Test
    public void verify_Account_Registration() {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		Account_registration_page arp=new Account_registration_page(driver);
		arp.setFirstName(randomString().toUpperCase());
		arp.setLastName(randomString().toUpperCase());
		arp.setEmail(randomString()+"@gmail.com");
		arp.setTelephone(randomNumeric());
		String alphaNum=randomAlphaNumeric();
		arp.setPassword(alphaNum);
		arp.setConfermPassword(alphaNum);
		arp.setPrivacyPolicy();
		arp.setButton();
		String actualmsg = arp.getConfirmation();
		Assert.assertEquals(actualmsg, "Your Account Has Been Created!");
     }
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
				return generatedString;
	}
	public String randomNumeric() {
		String randomnumber = RandomStringUtils.randomNumeric(10);
		return randomnumber;
	}
	public String randomAlphaNumeric() {
		String no=RandomStringUtils.randomAlphanumeric(10);
		return no;
	}
}
 