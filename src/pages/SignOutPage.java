package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helpers.WaitHelper;

public class SignOutPage extends MainPage {

	private WaitHelper wait;
	
	public SignOutPage(WebDriver driver) {
		super(driver);	
		this.wait = new WaitHelper(driver);
	}
	 
	//WebElements
	@FindBy(id="signed_out")
    private WebElement signOutMessage;
	
	//Actions
	public String getSignOutMessage() {
		wait.waitForElementToAppear(signOutMessage);
		return signOutMessage.getText();
	}
}
