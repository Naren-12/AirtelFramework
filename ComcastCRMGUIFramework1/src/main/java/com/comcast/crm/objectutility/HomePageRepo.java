package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageRepo {
	
	WebDriver driver;
	
	public HomePageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationButton;

	public WebElement getOrganizationButton() {
		return organizationButton;
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsButton;

	public WebElement getContactsButton() {
		return contactsButton;
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement personIcon;

	public WebElement getPersonIcon() {
		return personIcon;
	}
	
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	
	//action
	public void logout() {
		personIcon.click();
		signOutLink.click();
	}
	
}
