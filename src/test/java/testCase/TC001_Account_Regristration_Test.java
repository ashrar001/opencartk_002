package testCase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Account_registration_page;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_Account_Regristration_Test extends BaseClass{
	
	@Test
    public void verify_Account_Registration() {
		logger.info("**** Starting TC001_Account_Regristration_Test ***");
		HomePage hp=new HomePage(driver);
		try {
		hp.clickMyAccount();
		logger.info("**** click my account ***");
		hp.clickRegister();
		logger.info("**** click my register ***");
		Account_registration_page arp=new Account_registration_page(driver);
		logger.info("**** providing customer details**** ");
		arp.setFirstName(randomString().toUpperCase());
		arp.setLastName(randomString().toUpperCase());
		arp.setEmail(randomString()+"@gmail.com");
		arp.setTelephone(randomNumeric());
		String alphaNum=randomAlphaNumeric();
		arp.setPassword(alphaNum);
		arp.setConfermPassword(alphaNum);
		arp.setPrivacyPolicy();
		arp.setButton();
		logger.info("**** validating expected result**** ");
		String actualmsg = arp.getConfirmation();
		if(actualmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			
		}
		else {
			logger.error("test failed_--__");
			logger.debug("Debug logs**");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** Finish TC001_Account_Regristration_Test**** ");
     }
	
}
 