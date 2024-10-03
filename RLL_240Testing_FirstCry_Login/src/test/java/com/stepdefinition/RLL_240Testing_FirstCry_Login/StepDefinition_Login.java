package com.stepdefinition.RLL_240Testing_FirstCry_Login;

 
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException; 
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert; 
import com.pages.RLL_240Testing_FirstCry_Login.HomePage;
import com.pages.RLL_240Testing_FirstCry_Login.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class StepDefinition_Login {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	Logger log1;
	@Before
	public void init() {
		driver = new ChromeDriver();
		home = new HomePage(driver);
		login = new LoginPage(driver);
		log1= Logger.getLogger(StepDefinition_Home.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/***********************************************************************
	Project Name: FirstCry
	Module Name: Login
	Requirement ID: VA_REQ_02
	Testcase ID : VA_TC_002
	Method Name :userloginmethod() 
	Method Description : user do the login process
	Author: Vaibhav Agrahari
	Date of Creation: 03/10/2024
	Script Description: Update user login details
	 * @throws IOException 
	*************************************************************************/
	
	@Given("The user navigates to FirstCry Home Page")
    public void the_user_navigates_to_FirstCry_Home_Page() throws InterruptedException, IOException {
        home.LaunchFirstCry();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        log1.info("User successfully navigates to Home page");
    }
    @When("The user clicks on login")
    public void the_user_clicks_on_login() throws InterruptedException {
        home.loginbuttonclick();
        Thread.sleep(1000);
        log1.info("clicks on login successfully");
    }
    @When("^The user enters the (.*) or mobile no.$")
    public void the_user_enters_the_email_id_or_mobile_no(String EmailID) throws InterruptedException {
        login.enterUserName(EmailID);
        Thread.sleep(1000);
        log1.info("email id enters successfully");
    }
    @When("The user clicks on Continue")
    public void the_user_clicks_on_continue() throws InterruptedException {
        login.clickContinueButton();
        Thread.sleep(31000);
        log1.info("clicks on continue button successfully");
    }
    @When("Click on Submit")
    public void click_on_submit() {
        login.clickSubmitButton();
        log1.info("successfully submitted");
    }
    @Then("^The user gets a message (.*) that user is on home page (.*)$")
    public void the_user_gets_a_message_that_user_is_on_home_page(String actualResult, String expectedResult) {
        try {
            // Find the actual message on the page (use a more generic XPath to handle different messages)
            WebElement messageElement = driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", actualResult)));
            String actualMessage = messageElement.getText();
            // Compare the actual message from the page with the expected result
            Assert.assertEquals(actualMessage, expectedResult, "The actual message does not match the expected result.");
        } catch (NoSuchElementException e) {
            Assert.fail(String.format("Expected message '%s' was not found on the page.", expectedResult));
        }
        log1.info("Assertion successfully");
    }
}