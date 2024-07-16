package com.crm.contacttest;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.listernerUtility.ListernerImplementation;
import com.comcast.crm.objectutility.ContactInfoPage;
import com.comcast.crm.objectutility.ContactPageRepo;
import com.comcast.crm.objectutility.CreatingNewContact;
import com.comcast.crm.objectutility.HomePageRepo;
import com.crm.basetest.BaseClass;

@Listeners(com.comcast.crm.listernerUtility.ListernerImplementation.class)
public class CreateContactTest extends BaseClass {
	@Test(groups = "Smoke Testing")
	public void createContact() throws Throwable {
		// reading data from excelsheet

		String lastName = exUtil.readDataFromExcel("Contact", 1, 2)+ jUtil.getRandomNum();

		// click on contact
		ListernerImplementation.test.log(Status.INFO, "Clicking on Contact.");
		HomePageRepo homePage = new HomePageRepo(driver);
		homePage.getContactsButton().click();

		//click on plus button
		ListernerImplementation.test.log(Status.INFO, "Click on plus.");
		ContactPageRepo contactPage = new ContactPageRepo(driver);
		contactPage.getCrtContctIcon().click();
		
		// create contact
		ListernerImplementation.test.log(Status.INFO, "Create on Contact.");
		CreatingNewContact crtContactPage = new CreatingNewContact(driver);
		crtContactPage.createContact(lastName );

		// verification
		ContactInfoPage contactInfo = new ContactInfoPage(driver);
	
		// header Msg
		assertEquals( contactInfo.getContactTitleHeaderTxt().getText().contains(lastName) , true );
		
		// last name
		softAssert.assertEquals(contactInfo.getContactTitleText().getText(), lastName , "Last name is wrong.");

	}
	
	@Test(groups = "Regression Testing")
	public void createContactWithSupDate() throws Throwable {

		//reading data from excelsheet
		String lastName = exUtil.readDataFromExcel("Contact", 4, 2)+ jUtil.getRandomNum();
		
		//navigate to contact module
		HomePageRepo hmPage = new HomePageRepo(driver);
		hmPage.getContactsButton().click();
		
		//press plus icon
		ContactPageRepo contactPage = new ContactPageRepo(driver);
		contactPage.getCrtContctIcon().click();
		
		//creating contact with support date
		CreatingNewContact crtContactRepo = new CreatingNewContact(driver);
		crtContactRepo.createContact(lastName, 30);
	}
	
	@Test(groups = "Regression Testing")
	public void createContactWithOrg() throws Throwable {
		

		// reading data from excelsheet
		String orgName = exUtil.readDataFromExcel("Contact", 7, 2)+ jUtil.getRandomNum();
		String lastName = exUtil.readDataFromExcel("Contact", 7, 3)+ jUtil.getRandomNum();
		
		//creating contact with support date
		CreatingNewContact crtContactRepo = new CreatingNewContact(driver);
		crtContactRepo.createContact(lastName,orgName);
		
		
		ContactInfoPage contactInfo = new ContactInfoPage(driver);
		
		// verification
		if( contactInfo.getContactTitleHeaderTxt().getText().contains(lastName) )
			System.out.println(lastName + " info is created - PASS.");
		else
			System.out.println(lastName +" info is not created - FAIL.");
		
		System.out.println(orgName);
		
		System.out.println(contactInfo.getActualOrgName().getText());
		
		if( orgName.equals(" "+contactInfo.getActualOrgName().getText()) )
			System.out.println("Orgname verified");
		else
			System.out.println("Orgname is wrong");
	}
}
