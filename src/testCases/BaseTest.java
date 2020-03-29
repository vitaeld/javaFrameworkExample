package testCases;

import helpers.BrowserFactory;
import helpers.PageGenerator;

public class BaseTest {

	private static BrowserFactory browser;
	protected PageGenerator page;
	
	protected void startBrowser() throws Exception{
		browser = new BrowserFactory();
		browser.start();
		page = new PageGenerator(browser.getDriver());
		
	}
	 
	protected void openApplication(){
        browser.goToUrl();
    }
    
	protected void closeApplication() {
		browser.exitDriver();
        }
	}