# javaFrameworkExample
This is only a demonstration Selenium test in Java!
For a real project all functionality (login with valid credentials, login with invalid credential, search etc.)
in the test should be tested by separate test cases. All test cases should have clean-ups to be fully independent from each other so that 
failure in one test would not cause the failure of other ones. 
When using different input data to create several test cases from 1 test @ParameterizedTest JUnit attribute should be used

Tools used: Selenium Webdriver +JUnit + Maven

To do:
 Move remained test data to Json file (such as search input data, expected message, paths etc.). Only test steps should be left in the test itself for better code reading.

