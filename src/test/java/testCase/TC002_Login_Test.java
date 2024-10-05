package testCase;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_Login_Test extends BaseClass{
    @Test
	public void verify_login() {
		logger.info("****** login started ******");
		try {
		HomePage hp=new HomePage(driver); //home page
		hp.clickMyAccount();
		hp.clickLoginLink();
		LoginPage lp=new LoginPage(driver); //login page
		lp.setEmail(p.getProperty("email"));
		lp.setPass(p.getProperty("password"));
		lp.setLogin();
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetPage=map.isMyAccountPageIsExist();
	    Assert.assertTrue(targetPage);
		}
	    catch(Exception e) {
			Assert.fail();
		}
	    logger.info("*****login finished ******");
		}
}
