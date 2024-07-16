package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageRepo {
	
	WebDriver driver;
	
	public LoginPageRepo(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement usernameTxtFld;
	
	public WebElement getUsernameTxtFld() {
		return usernameTxtFld;
	}

	@FindBy(name = "user_password")
	private WebElement passwrdTxtFld;
	
	public WebElement getPasswrdTxtFld() {
		return passwrdTxtFld;
	}
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;
	
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//action methods
	public void login(String url,String username, String passwrd) {
		driver.get(url);
		usernameTxtFld.sendKeys(username);
		passwrdTxtFld.sendKeys(passwrd);
		loginButton.submit();
	}
}
