package com.pages.RLL_240Testing_FirstCry_Login;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
public class HomePage {
	WebDriver driver;
	
	By LoginButton = By.xpath("//span[@class=\"anch poplogin_main poplogin R12_61\"]");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void LaunchFirstCry() throws IOException
	{
		driver.get("https://www.firstcry.com/");
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    Files.copy(src, new File("Screenshots/shot1.png"));
	}
	
	public void loginbuttonclick()
	{
		driver.findElement(LoginButton).click();
	}
}