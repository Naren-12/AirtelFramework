package com.comcast.crm.objectutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class OrgPopUp {
	WebDriver driver;
	String orgName;
	int randNum;
	WebDriverUtility wbUtil = new WebDriverUtility();
	public OrgPopUp(WebDriver driver, String orgName) {
		
		this.driver = driver;
		this.orgName = orgName;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search")
	private WebElement srchButton;
	
	@FindBy( id = "search_txt" )
	private WebElement srchTxtFld;
	

	//search and select
	public void select(String orgName) throws Throwable {
		srchTxtFld.sendKeys( orgName );
		srchButton.click();
		System.out.println(orgName);
		WebElement crtedOrg = driver.findElement(By.xpath("//a[text()='"+orgName+"']"));
		wbUtil.waitForWebElement(driver, crtedOrg);
		crtedOrg.click();
	}
}
