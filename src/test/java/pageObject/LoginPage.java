package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
}
@FindBy(xpath = "//input[@id='input-email']")
WebElement textEmail;

@FindBy(xpath = "//input[@id='input-password']")
WebElement textPassword;

@FindBy(xpath = "//input[@value='Login']")
WebElement btnLogin;

public void setEmail(String email) {
	textEmail.sendKeys(email);
}
public void setPass(String pass) {
	textPassword.sendKeys(pass);
}
public void setLogin() {
	btnLogin.click();
}
}

