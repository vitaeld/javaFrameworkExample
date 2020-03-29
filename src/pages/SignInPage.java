package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

	public SignInPage(WebDriver driver) {
		super(driver);
		
	}
	  
	//WebElements
	@FindBy(xpath="//div[@id='emailForm']//input[@id='user_email']")
	private WebElement emailField;
	
	@FindBy(id="user_password")
	private WebElement passwordField;

	//Actions
	public void logInFromSignInPage(String email, String pass) throws InterruptedException {
		logIn(emailField, passwordField, email, pass );
	}
}
	