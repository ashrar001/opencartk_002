package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account_registration_page extends BasePage{
	public Account_registration_page(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtTelephone;
    
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;
    
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtConformPass;
    
    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkBox;
    
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btn;
    
    @FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
    WebElement conformMsg;
    
    public void setFirstName(String fname) {
    	txtFirstName.sendKeys(fname);
    }
    public void setLastName(String lname){
    	txtLastName.sendKeys(lname);
    }
    public void setEmail(String email) {
    	txtEmail.sendKeys(email);
    }
    public void setTelephone(String tel) {
    	txtTelephone.sendKeys(tel);
    }
    public void setPassword(String pass) {
    	txtPassword.sendKeys(pass);
    }
    public void setConfermPassword(String pass) {
    	txtConformPass.sendKeys(pass);
    }
    public void setPrivacyPolicy() {
    	checkBox.click();
    }
    public void setButton() {
    	btn.click();
    }
    public String getConfirmation() {
    	try {
    		return (conformMsg.getText());
    	}
    	catch(Exception e) {
    		return (e.getMessage());
    	}
    }
}
