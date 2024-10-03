package com.stepdefinition.RLL_240Testing_FirstCry_Login;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.pages.RLL_240Testing_FirstCry_Login.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.time.Duration;

public class StepDefinition_Home {
    WebDriver driver;
    HomePage home;
    Logger log1;

    @Before
    public void init() {
        driver = new ChromeDriver();
        home = new HomePage(driver);
        log1 = Logger.getLogger(StepDefinition_Home.class);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    /***************************************************************************
	Project Name: FirstCry
	Module Name: Login
	Requirement ID: VA_REQ_01 
	Testcase ID : VA_TC_001
	Method Name :navigatetologinpage() 
	Method Description : user navigates to login page
	Author: Vaibhav Agrahari
	Date of Creation: 03/10/2024
	Script Description: user clicks on login and navigates to login page
     * @throws IOException 
	****************************************************************************/

    @Given("The user is to enter the FirstCry Home Page")
    public void the_user_is_to_enter_the_FirstCry_Home_Page() throws IOException {
        home.LaunchFirstCry();
        driver.manage().window().maximize();
        log1.info("Browser maximized");
    }

    @When("The user then clicks on login button")
    public void the_user_then_clicks_on_login_button() {
        home.loginbuttonclick();
        log1.info("Login button clicked successfully");
    }

    @Then("The user enters the login page of firstcry app")
    public void the_user_enters_the_login_page_of_firstcry_app() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement exp4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Log In/Register')]")));
        Assert.assertEquals(exp4.getText(), "Log In/Register");
        log1.info("User enters the FirstCry app successfully");
    }
}
