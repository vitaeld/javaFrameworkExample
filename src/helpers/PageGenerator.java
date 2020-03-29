package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.BasePage;

public class PageGenerator {
	
	private WebDriver driver;
	
    public PageGenerator(WebDriver driver){
        this.driver = driver;
    }
  
    public  <TPage extends BasePage> TPage GetInstance (Class<TPage> pageClass) {
        try {
            return PageFactory.initElements(this.driver,  pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }  
    }
}

