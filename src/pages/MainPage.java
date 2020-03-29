package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helpers.WaitHelper;

public class MainPage extends BasePage {

	private WaitHelper wait;
	
	public MainPage(WebDriver driver) {
		super(driver);
		this.wait = new WaitHelper(driver);
	}
 
	//WebElements
	@FindBy(css="span.headerPersonalNav__icon>img")
	 private WebElement mainMenuIcon;
	
	@FindBy(xpath="//ul[@class='personalNav']/li[5]//ul/li[13]")
	 private WebElement signOutLink;
	
	@FindBy(xpath="//form[@class='searchBox__form']/input")
	 private WebElement searchField;
	
	//Actions
	public void expandUserMenu() {
		wait.waitForElementToAppear(mainMenuIcon);
		mainMenuIcon.click();
	}
	
	public void signOut() {
		expandUserMenu();
		signOutLink.click();
	}
	
	public void makeSearch(String text) {
		wait.waitForElementToAppear(searchField);
		enterText(searchField, text);
		submitForm(searchField);
	}
}

