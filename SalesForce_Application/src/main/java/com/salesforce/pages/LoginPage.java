package com.salesforce.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.testng.api.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {
	
	
	public LoginPage enterUserName(String uName) {
		//locate the element
		WebElement locateElement = locateElement("username");
		//type userName
		type(locateElement, uName);
		//clear & Type - ClearAndType(locateElement, uName);
		reportStep("Enter the UserName as :"+uName, "pass");
		return this;
	}
	
	public LoginPage enterPassword(String pass) {
		type(locateElement("password"), pass);
		reportStep("Enter the PassWord as :"+pass, "pass");
		return this;
	}
	
	
	public HomePage clickOnLogin() {
		click(locateElement("Login"));
	    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Home']//span")));
	    reportStep("Login is Clicked, Navigated to Home Page", "pass");
	    return new HomePage();
	}

}
