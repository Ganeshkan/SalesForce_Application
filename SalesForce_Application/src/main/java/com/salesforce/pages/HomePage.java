package com.salesforce.pages;

import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {

	public HomePage click_on_ToggleMenu() {
		WebElement toggle = locateElement(Locators.XPATH, "//button[@title='App Launcher']");
		waitForApperance(toggle);
		click(toggle);
		reportStep("Toggle is Cliked", "Pass");
		return this;
	}

	public HomePage Click_on_ViewAll() {
		click(locateElement(Locators.XPATH, "//button[text()='View All']"));
		return this;
	}
	public HomePage click_on_Sales() {
		WebElement sales = locateElement(Locators.XPATH, "//p[text()='Sales']");
		click(sales);
		return this;
	}
	public  RecentlyViewOppurtunity Click_on_OppurtunityTab() {
		pause(2000);
		WebElement OppurtunityTab = locateElement(Locators.XPATH, "//a[@title='Opportunities']//span");
		clickUsingJs(OppurtunityTab);
		reportStep("Navigate to Recently viewed|Oppurtunity", "pass");
		return new RecentlyViewOppurtunity();

	}


}
