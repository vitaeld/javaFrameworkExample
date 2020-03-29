package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.PageGenerator;
import helpers.WaitHelper;

public class BasePage extends PageGenerator {
	 
	private WaitHelper wait;
	
    public BasePage(WebDriver driver) {
        super(driver);
        this.wait = new WaitHelper(driver);
    }
      
    protected static void enterText(WebElement element,String text) {
    	element.clear();
    	element.sendKeys(text); 	
    }
    
    protected static void submitForm(WebElement element) {
    	element.submit();
    }
    
    protected void logIn(WebElement element1, WebElement element2, String email, String pass) {
    	wait.waitForElementToAppear(element1);
    	enterText(element1,email);
    	enterText(element2,pass);
    	submitForm(element2);
    } 
}