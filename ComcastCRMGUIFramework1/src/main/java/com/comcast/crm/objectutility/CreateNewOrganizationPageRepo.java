package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPageRepo {

	WebDriver driver;

	public CreateNewOrganizationPageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameTxtFld;
	
	public WebElement getOrgNameTxtFld() {
		return orgNameTxtFld;
	}

	@FindBy(name = "industry")
	private WebElement indusDropDown;
	
	public WebElement getIndusDropDown() {
		return indusDropDown;
	}

	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	
	@FindBy(xpath = "(//input[@accesskey='S'])[1]")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	@FindBy(id = "phone")
	private WebElement phoneTxtFld;

	public WebElement getPhoneTxtFld() {
		return phoneTxtFld;
	}
	
	//------action methods------//
	//create org with name only
	public void createOrg(String name) {
		
		orgNameTxtFld.sendKeys(name);
		saveButton.click();
	}
	
	//create org with name, indus, type
	public void createOrg(String orgName, String indus, String type) {
		orgNameTxtFld.sendKeys(orgName);
		Select select = new Select(indusDropDown);
		select.selectByVisibleText(indus);
		
		Select select1 = new Select(typeDropDown);
		select1.selectByVisibleText(type);
		
		saveButton.click();
		
	}
	
	//create org with org along with phoneno.
	public void createOrg(String orgName, String phnNo) {
		orgNameTxtFld.sendKeys(orgName);
		phoneTxtFld.sendKeys(phnNo);
		saveButton.click();
	}
}
