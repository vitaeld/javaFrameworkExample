package pages;

import java.text.MessageFormat;
import  java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import data.TestData.SearchResultData;
import helpers.DataProcessingHelper;
import helpers.WaitHelper;

public class SearchResultsPage extends MainPage {

	private WaitHelper wait;
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);	
		this.wait = new WaitHelper(driver);
	}
 
	//WebElements
    @FindBy(xpath="//table[@class='tableList']")
    private WebElement searchResultList;
	
	@FindBy(name="reviewForm")
    private WebElement resultReviewForm;
	    
	@FindBy(xpath="//div[@id='boxContents']//div[@class='stars']/a[5]")
    private WebElement rateStar5;
	    
	@FindBy(id="review_review_usertext")
    private WebElement reviewText;
		
	@FindBy(xpath="//span[@class='startedAtDatePickers']/div/select")
    private WebElement startedAtDatePickerYear;
	    
    @FindBy(xpath="//span[@class='startedAtDatePickers']/div[3]/select")
    private WebElement startedAtDatePickerMonth;
	    
	@FindBy(xpath="//span[@class='startedAtDatePickers']/div[5]/select")
    private WebElement startedAtDatePickerDay;
	    
	@FindBy(xpath="//span[@class='endedAtDatePickers']/span/select")
    private WebElement endedAtDatePickerYear;
	    
	@FindBy(xpath="//span[@class='endedAtDatePickers']/span[2]/select")
    private WebElement endedAtDatePickerMonth;
	    
	@FindBy(xpath="//span[@class='endedAtDatePickers']/span[3]/select")
    private WebElement endedAtDatePickerDay;
	    
	@FindBy(id="overlay")
    private WebElement overlay;
	    
    //Inside Locators
    String wantToReadButtonLocator = "div[2]/div/div";
    String arrowLocator = "div[2]/div/div[2]";
	String readOptionLocator = "//ul[@class='wtrExclusiveShelves']/li[1]";
		
	//Actions	
	public WebElement getSearchResultItem(String position) {
        var itemXpath = MessageFormat.format("//tr[{0}]/td[2]", position);
	    var searchResultItem = searchResultList.findElement(By.xpath(itemXpath));
	    return searchResultItem;
	}
		 
	public void markWantToRead(String position) {		
	    wait.waitForElementToAppear(searchResultList);		
	    var searchResultItem = getSearchResultItem(position);
	    var wantToReadButton = searchResultItem.findElement(By.xpath(wantToReadButtonLocator));
	    wait.waitForElementToAppear(wantToReadButton);
	    wantToReadButton.click();		
	}
		
	public void markRateAndReview() throws Exception {	
	    final String partPath = "\\src\\data\\TestData\\TestData.json";
		SearchResultData[] datas = DataProcessingHelper.getTestData(partPath);
			for (SearchResultData data: datas) {
				markWantToRead(data.getPosition());
				markRead(getSearchResultItem(data.getPosition()));
				var fromDate = DataProcessingHelper.getCalenderDate(data.getFrom());
				var toDate = DataProcessingHelper.getCalenderDate(data.getTo());
				rateAndReview(fromDate, toDate);
				wait.waitForElementNotVisible(overlay);
			}
		}

	public void markRead(WebElement element) {
		var arrow = element.findElement(By.xpath(arrowLocator));
		wait.waitForElementToAppear(arrow);
		arrow.click();
		var readOption = arrow.findElement(By.xpath(readOptionLocator));
		wait.waitForElementToAppear(readOption);
		readOption.click();
		}
		
	public void rateAndReview(Calendar  from, Calendar to) {
        wait.waitForElementToAppear(resultReviewForm);
		wait.waitForElementToAppear(reviewText);
		String text = "very good";
		enterText(reviewText,text);
		wait.waitForElementToAppear(rateStar5);
		rateStar5.click();
		pickDate(startedAtDatePickerYear,startedAtDatePickerMonth,startedAtDatePickerDay, 
				String.valueOf(from.get(Calendar.YEAR)), String.valueOf(from.get(Calendar.MONTH)+1), String.valueOf(from.get(Calendar.DAY_OF_MONTH)));
		pickDate(endedAtDatePickerYear, endedAtDatePickerMonth, endedAtDatePickerDay, 
				String.valueOf(to.get(Calendar.YEAR)), String.valueOf(to.get(Calendar.MONTH)+1), String.valueOf(to.get(Calendar.DAY_OF_MONTH)));
		submitForm(reviewText);
		}
		
	public void pickDate(WebElement yearEl, WebElement monthEl, WebElement dayEl, String year, String month, String day) {
		var startedDateSelectYear = new Select(yearEl);
		startedDateSelectYear.selectByVisibleText(year);
		var startedDateSelectMonth = new Select(monthEl);
	    startedDateSelectMonth.selectByValue(month);
		var startedDateSelectDay = new Select(dayEl);
		startedDateSelectDay.selectByValue(day);
		}
}
