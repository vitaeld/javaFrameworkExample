package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import data.ConfigData.ConfigData;

public class BrowserFactory {
	
	private WebDriver driver;
	private String appUrl;
	private String geckoDriverPath;
	final String partPath = "\\src\\data\\ConfigData\\ConfigData.json";
	final String geckoDriverPropertyName = "webdriver.gecko.driver";
	
	public BrowserFactory() throws Exception {
		this.appUrl = DataProcessingHelper.getData(partPath, ConfigData.class).getAppUrl();
		this.geckoDriverPath = DataProcessingHelper.getGeckoPath();
	}
  
	public void start() {
		System.setProperty(geckoDriverPropertyName, geckoDriverPath);
        var options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        driver = new FirefoxDriver(options);
    }
	
	 public void goToUrl() {
         driver.navigate().to(appUrl);
     }

     public void exitDriver() {
    	 if(null != driver) {
             driver.quit();
         }
     }
     public WebDriver getDriver() {
    	 return driver;
     }
}
