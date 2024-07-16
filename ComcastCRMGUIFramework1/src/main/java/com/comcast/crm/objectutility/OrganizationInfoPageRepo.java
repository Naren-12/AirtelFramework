package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPageRepo {
	
	WebDriver driver;

	public OrganizationInfoPageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsButton;
	
	public WebElement getContactsButton() {
		return contactsButton;
	}

	@FindBy(xpath = "//span[contains(.,'Organization')]")
	private WebElement orgTitleHeaderTxt;
	
	public WebElement getOrgTitleHeaderTxt() {
		return orgTitleHeaderTxt;
	}
	
	@FindBy( id = "dtlview_Organization Name" )
	private WebElement orgTitleMsg;
	
	public WebElement getOrgTitleMsg() {
		return orgTitleMsg;
	}

	
	@FindBy(id="dtlview_Industry")
	private WebElement indusTxt;
	
	public WebElement getIndusTxt() {
		return indusTxt;
	}
	
	@FindBy( id = "dtlview_Type" )
	private WebElement typeTxt;
	
	public WebElement getTypeTxt() {
		return typeTxt;
	}
	
	@FindBy( id = "dtlview_Phone" )
	private WebElement phoneNoTxt;

	public WebElement getPhoneNoTxt() {
		return phoneNoTxt;
	}
	
	@FindBy( xpath =  "//a[text()='Organizations' and not(@class) ]")
	private WebElement orgButton;

	public WebElement getOrgButton() {
		return orgButton;
	}
}
