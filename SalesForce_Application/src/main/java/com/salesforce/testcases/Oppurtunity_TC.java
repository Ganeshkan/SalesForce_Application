package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class Oppurtunity_TC extends ProjectSpecificMethods {
	public String Oppurtunity_name = "Automation by Kumar"; //Perception Analysis In progress
	public String descr_value = "salesforce";
	@BeforeTest
	public void setValues() {
		excelFileName="Login";
		testcaseName="Salesforce Application";
		testDescription="Login page";
		authors="Ganesh";
		category="Sanity";
	}

	//TC001_Create_New_Oppurtunity
	@Test(dataProvider = "fetchData")
	public void TC001_Create_New_Oppurtunity(String uName,String passWord) {
		//Data
		String Date = "10/06/2025";
		String Stage ="Needs Analysis";
		LoginPage lp=new LoginPage();
		
		lp.enterUserName(uName)
		.enterPassword(passWord)
		.clickOnLogin().click_on_ToggleMenu().Click_on_ViewAll()
		.click_on_Sales().Click_on_OppurtunityTab()
		.click_on_NewButton().enter_OppurtunityName(Oppurtunity_name)
		.choose_CloseDate(Date).select_Stage(Stage).save_oppurtunity()
		.verify_new_oppurtunity_created_Successfully(Oppurtunity_name);
	}
	//TC002_Edit_oppurtunity
	@Test(dataProvider = "fetchData")
	public void TC002_Edit_oppurtunity(String uName,String passWord) {
		//Data
		String Date = "10/07/2025";
		String Stage ="Perception Analysis";
		String Status = "In progress";

		LoginPage lp=new LoginPage();
		lp.enterUserName(uName)
		.enterPassword(passWord)
		.clickOnLogin().click_on_ToggleMenu().Click_on_ViewAll().click_on_Sales()
		.Click_on_OppurtunityTab().search_Oppurtunity(Oppurtunity_name)
		.viewAllActions_and_Edit().choose_CloseDate(Date).select_Stage(Stage)
		.select_deliveryStatus(Status).enter_desc(descr_value).save_oppurtunity()
		.verify_Oppurtunity_Edited_sucessfully(Stage);
	}

	@Test(dataProvider = "fetchData")
	public void TC003_Delete_oppurtunity(String uName,String passWord) {
		LoginPage lp=new LoginPage();
		lp.enterUserName(uName)
		.enterPassword(passWord).clickOnLogin()
		.click_on_ToggleMenu().Click_on_ViewAll().click_on_Sales().Click_on_OppurtunityTab()
		.search_Oppurtunity(Oppurtunity_name).viewAllActions_and_Delete().verify_oppurtunity_deleted_Succesfully(Oppurtunity_name);
	}
	@Test(dataProvider = "fetchData")
	public void TC004_Create_Opportunity_without_mandatory_fields(String uName,String passWord) {
		//Data
		String Date = "10/08/2025";
		LoginPage lp=new LoginPage();
		lp.enterUserName(uName)
		.enterPassword(passWord).clickOnLogin()
		.click_on_ToggleMenu().Click_on_ViewAll().click_on_Sales().Click_on_OppurtunityTab()
		.click_on_NewButton().choose_CloseDate(Date).save_oppurtunity().verify_AlertMessage();
	}

}
