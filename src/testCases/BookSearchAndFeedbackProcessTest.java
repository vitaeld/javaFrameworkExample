package testCases;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.UserData.UserData;
import helpers.DataProcessingHelper;
import pages.FirstPage;
import pages.MainPage;
import pages.SearchResultsPage;
import pages.SignInPage;
import pages.SignOutPage;

class BookSearchAndFeedbackProcessTest extends BaseTest {
	
	 @BeforeEach
	    void setUp() throws Exception {
			 startBrowser();
	         openApplication();
	   }

	 @AfterEach
	    void tearDown() { 
		    closeApplication();
	   }

	 @Test
	    void reviewBooksTest() throws Exception {
		final String partPath = "\\src\\data\\UserData\\UserData.json";	
		final String searchInput = "Best crime and mystery books";
		var validEmail = DataProcessingHelper.getData(partPath,UserData.class).getValidEmail();
		var pass = DataProcessingHelper.getData(partPath, UserData.class).getValidPassword();
	        var invalidEmail = DataProcessingHelper.getData(partPath,UserData.class).getInvalidEmail();
		    
		var firstPage = page.GetInstance(FirstPage.class);
		firstPage.logInFromFirstPage(invalidEmail, pass);
		var signInPage = page.GetInstance(SignInPage.class);
		signInPage.logInFromSignInPage(validEmail, pass);
		var mainPage = page.GetInstance(MainPage.class);
	    	mainPage.makeSearch(searchInput);
		var searchResultsPage = page.GetInstance(SearchResultsPage.class);
		searchResultsPage.markRateAndReview();
		mainPage.signOut();
		var signOutPage = page.GetInstance(SignOutPage.class);
		var signOutMessage = signOutPage.getSignOutMessage();
		final String expectedMessage = "You’ve been signed out.";
		    
	        assertEquals(expectedMessage,signOutMessage);
		
	}
}
