package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPageRepo {

	WebDriver driver;

	public OrganizationPageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "img[title='Create Organization...']")
	private WebElement createOrgPlusIcon;

	public WebElement getCreateOrgPlusIcon() {
		return createOrgPlusIcon;
	}
	
	@FindBy(name = "search_text")
	private WebElement srchTxtFld;

	public WebElement getSrchTxtFld() {
		return srchTxtFld;
	}
	
	@FindBy(id = "bas_searchfield")
	private WebElement inDropDown;

	public WebElement getInDropDown() {
		return inDropDown;
	}
	
	@FindBy(xpath = "//div[@id='basicsearchcolumns_real']//option[text()='Organization Name']")
	private WebElement orgNameOptInDD;

	public WebElement getOrgNameOptInDD() {
		return orgNameOptInDD;
	}
	
	@FindBy(name = "submit")
	private WebElement srchNowButton;

	public WebElement getSrchNowButton() {
		return srchNowButton;
	}
	
	
}
