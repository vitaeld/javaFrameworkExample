package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	 private static final int TIMEOUT = 10;
	 private static final int POLLING = 1000;
	
	 protected WebDriver driver;
	 private WebDriverWait wait;
 
	 public WaitHelper(WebDriver driver) {
	    this.driver = driver;
	    wait = new WebDriverWait(driver, TIMEOUT, POLLING);        
	 }
	    
	 public void waitForElementToAppear(WebElement element) {
	    wait.until(ExpectedConditions.visibilityOf(element));
	 }
	
	 public void waitForElementToBeClickable(WebElement element) {
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	 }
	   
	 public void waitForElementNotVisible(WebElement element) {
	    wait.until(ExpectedConditions.invisibilityOf(element));
	 }
}
