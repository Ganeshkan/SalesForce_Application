package com.salesforce.pages;

import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class RecentlyViewOppurtunity extends ProjectSpecificMethods{

	public RecentlyViewOppurtunity click_on_NewButton() {
		pause(2000);
		WebElement NewButton = locateElement(Locators.XPATH, "//a[@title='New']");
		waitForApperance(NewButton);
		clickUsingJs(NewButton);
		return this;
	}
	public RecentlyViewOppurtunity search_Oppurtunity(String Oppurtunity_Name) {
		pause(2000);
		WebElement search= locateElement(Locators.XPATH, "//input[@name='Opportunity-search-input']");
		waitForApperance(search);
		typeAndEnter(search, Oppurtunity_Name);
		reportStep("oppurtunity searched", "Pass");
		return this;
	}
	public RecentlyViewOppurtunity viewAllActions_and_Edit() {
		pause(1000);
		WebElement viewAction = locateElement(Locators.XPATH, "(//table//tbody//tr//td[8])[1]");
		waitForApperance(viewAction);
		click(viewAction);
		pause(2000);
		WebElement Editbtn = locateElement(Locators.XPATH, "//a//div[@title='Edit']");
		waitForApperance(Editbtn);
		hoverAndClick(Editbtn);
		reportStep("Edit panel opened","Pass");
		return this;
	}
	public RecentlyViewOppurtunity viewAllActions_and_Delete() {
		WebElement viewAction = locateElement(Locators.XPATH, "(//table//tbody//tr//td[8])[1]");
		waitForApperance(viewAction);
		click(viewAction);
		//click(Locators.XPATH, "(//table//tbody//tr//td[8])[1])");
		WebElement Delete = locateElement(Locators.XPATH, "//a//div[@title='Delete']");
		waitForApperance(Delete);
		clickUsingJs(Delete);
		click(Locators.XPATH, "//button[@title='Delete']");
		reportStep("Click on  the Dropdown icon and Select Delete", "Pass");
		return this;
	}
	public RecentlyViewOppurtunity enter_OppurtunityName(String Oppurtunity_name) {
		WebElement OppurtunityName = locateElement(Locators.XPATH, "//input[@name='Name']");
		waitForApperance(OppurtunityName);
		type(OppurtunityName, Oppurtunity_name);
		reportStep("OppurtunityName Entered", "Pass");
		return this;
	}
	public RecentlyViewOppurtunity choose_CloseDate(String Date) {
		WebElement CloseDate = locateElement(Locators.XPATH, "//input[@name='CloseDate']");
		waitForApperance(CloseDate);
		clearAndType(CloseDate, Date);
		reportStep("close Date Selected", "Pass");
		return this;
	}
	public RecentlyViewOppurtunity select_Stage(String StageValue) {
		WebElement Stage_Dropdown = locateElement(Locators.XPATH, "//button[@aria-label='Stage']");
		clickUsingJs(Stage_Dropdown);
		WebElement Stage_Value = locateElement(Locators.XPATH, "//div[@aria-label='Stage']//span[@title='"+StageValue+"']");
		hoverAndClick(Stage_Value);
		reportStep("Stage value Selected", "Pass");
		return this;
	}
	public  RecentlyViewOppurtunity select_deliveryStatus(String StatusValue) {
		WebElement Status=locateElement(Locators.XPATH, "//button[@aria-label='Delivery/Installation Status']")	;
		clickUsingJs(Status);
		WebElement Status_value=locateElement(Locators.XPATH, "//span[@title='"+StatusValue+"']");
		clickUsingJs(Status_value);
		reportStep("Delivery Status Selected", "Pass");
		return this;
	}
	public RecentlyViewOppurtunity enter_desc(String descValue) {
		WebElement descr = locateElement(Locators.XPATH, "//textarea[@part='textarea']");
		type(descr, descValue);
		reportStep("Description entered", "Pass");
		return this;
	}

	public RecentlyViewOppurtunity save_oppurtunity() {
		WebElement savebutton = locateElement(Locators.XPATH, "//button[@name='SaveEdit']");
		clickUsingJs(savebutton);
		return this;
	}
	public  Oppurtunity verify_new_oppurtunity_created_Successfully(String Oppurtunity_name) {
		WebElement infomsg = locateElement(Locators.XPATH, "//span[@data-aura-class='forceActionsText']//a//div");
		String actuslmsg = "Oppurtunity "+getElementText(infomsg)+" was created";
		String expectedmsg = "Oppurtunity "+Oppurtunity_name+" was created";
		if(actuslmsg.contentEquals(expectedmsg)) {
			reportStep("New Oppurtunity created sucessfully", "Pass");
		}else {
			reportStep("New Oppurtunity not Created unsucessfully", "Fail");
		}
		return new Oppurtunity();
	}
	public RecentlyViewOppurtunity verify_Oppurtunity_Edited_sucessfully(String Stage) {
		WebElement stage = locateElement(Locators.XPATH, "(//table//tbody//tr//td[5])[1]");
		waitForApperance(stage);
		if(verifyExactText(stage, Stage)) {
			reportStep("stage value same as Edited", "Pass");
		}else {
			reportStep("stage value not same as Edited", "Fail");
		}
		return this;
	}
	public  RecentlyViewOppurtunity verify_oppurtunity_deleted_Succesfully(String Oppurtunity_name) {
		WebElement infoMsg = locateElement(Locators.XPATH, "//span[@data-aura-class='forceActionsText']");
		waitForApperance(infoMsg);
		getElementText(infoMsg);
		String expectedmsg = "Oppurtunity "+Oppurtunity_name+" was deleted. Undo";
		verifyPartialText(infoMsg, expectedmsg);
		reportStep("Deleted sucessfully", "pass");
		return this;
	}
	public void verify_AlertMessage() {
		WebElement alertmsg = locateElement(Locators.XPATH, "//div[@class='fieldLevelErrors']//ul");
		getElementText(alertmsg);
		verifyPartialText(alertmsg, "Close Date Opportunity Name Stage");
		reportStep("Alert Message displayed", "pass");
	}





}
