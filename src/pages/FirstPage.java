package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends BasePage{

	public FirstPage(WebDriver driver) {
		super(driver);
		
	}
	 
	//WebElements
	@FindBy(id="userSignInFormEmail")
	 private WebElement emailField;
	
	@FindBy(id="user_password")
	private WebElement passwordField;
	
	@FindBy(id="user_first_name")
	 private WebElement userName;
	
	@FindBy(id="user_email")
	 private WebElement emailAddress;
	
	@FindBy(id="user_password_signup")
	 private WebElement userPassword;
	
	//Actions 
	public void logInFromFirstPage(String email, String pass) {
		logIn(emailField, passwordField, email, pass);
	}
	
	public void signUp(String name, String email, String password ) {
		enterText(userName, name);
		enterText(emailAddress, email);
		enterText(userPassword, password);
	    submitForm(userPassword);
	}
}
