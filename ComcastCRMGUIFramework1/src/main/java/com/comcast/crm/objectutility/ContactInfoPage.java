package com.comcast.crm.objectutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
	
	public ContactInfoPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(css = "span[class='dvHeaderText']")
	private WebElement contactTitleHeaderTxt;
	
	public WebElement getContactTitleHeaderTxt() {
		return contactTitleHeaderTxt;
	}

	@FindBy(id = "dtlview_Last Name")
	private WebElement contactTitleText;
	
	public WebElement getContactTitleText() {
		return contactTitleText;
	}
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement supStrtDate;
	
	public WebElement getSupStrtDate() {
		return supStrtDate;
	}
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement supEndDate;

	public WebElement getSupEndDate() {
		return supEndDate;
	}
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement actualOrgName;

	public WebElement getActualOrgName() {
		return actualOrgName;
	}
	
	
	//actions
	//clicking on crted Org
	
	
	
	
}
