package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewContact {
	
	WebDriver driver;
	String orgName;
	int randNum;
	JavaUtility jUtil = new JavaUtility();
	WebDriverUtility wbUtil = new WebDriverUtility();
	
	
	OrgPopUp popUp;

	public CreatingNewContact(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public CreatingNewContact(WebDriver driver,String orgName,int randNum) {
		
		this.driver = driver;
		this.orgName = orgName;
		this.randNum = randNum;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(name = "lastname")
	private WebElement lstNameTxtFld;
	
	public WebElement getLstNameTxtFld() {
		return lstNameTxtFld;
	}

	@FindBy(xpath = "//td[contains(.,'Organization Name')and @align='right']//following-sibling::td//img")
	private WebElement addOrgNameIcon;
	
	public WebElement getAddOrgNameIcon() {
		return addOrgNameIcon;
	}

	@FindBy(id = "jscal_field_support_end_date")
	private WebElement endDateTxtFld;
	
	public WebElement getEndDateTxtFld() {
		return endDateTxtFld;
	}

	
	@FindBy( id = "jscal_field_support_start_date")
	private WebElement strtDateTxtFld;
	
	public WebElement getStrtDateTxtFld() {
		return strtDateTxtFld;
	}

	
	@FindBy( xpath = "(//input[@accesskey='S'])[1]" )
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}
	//---Actions---//
	//create contact with only lastname
	public void createContact(String lastName) {
		lstNameTxtFld.sendKeys(lastName);
		saveButton.click();
	}
	
	//create contact with start and end date
	public void createContact(String lastName, int days) {
		lstNameTxtFld.sendKeys(lastName);
		String currentDate = jUtil.getSystemDateYYYYMMDD();
		String endDate = jUtil.getReqDateFromGnDate(days);
		
		strtDateTxtFld.sendKeys(currentDate);
		endDateTxtFld.sendKeys(endDate);
		
		saveButton.click();
	}
	
	
	//create contact with org
	public void createContact(String lastName, String orgName) throws Throwable {
		
		HomePageRepo hmPage = new HomePageRepo(driver);
		hmPage.getOrganizationButton().click();
		
		OrganizationPageRepo orgPage = new OrganizationPageRepo(driver);
		orgPage.getCreateOrgPlusIcon().click();
		
		CreateNewOrganizationPageRepo crtOrgRepo = new CreateNewOrganizationPageRepo(driver);
		crtOrgRepo.createOrg(orgName);
		
		Thread.sleep(5000);
		
		OrganizationInfoPageRepo orgInfoRepo = new OrganizationInfoPageRepo(driver);
		orgInfoRepo.getContactsButton().click();
		
		ContactPageRepo contactRepo = new ContactPageRepo(driver);
		contactRepo.getCrtContctIcon().click();
		
		lstNameTxtFld.sendKeys(lastName);
		addOrgNameIcon.click();
		wbUtil.switchToTabUsingURL(driver, "module=Accounts");
		popUp = new OrgPopUp(driver, orgName) ;
		popUp.select(orgName);
		wbUtil.switchToTabUsingURL(driver, "module=Contacts");
		saveButton.click();
	}
	
}
