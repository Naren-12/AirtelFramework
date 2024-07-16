package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public boolean checkForTagText(WebDriver driver, WebElement ele, String tagtext) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.textToBePresentInElement(ele, tagtext));
	}
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForWebElement(WebDriver driver, WebElement wbEle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(wbEle));
	}
	
	public void switchToTabUsingURL(WebDriver driver, String partialURL) {
		Set<String> wid = driver.getWindowHandles();
		Iterator<String> it = wid.iterator();
		
		while(it.hasNext()) {
			String winid = it.next();
			driver.switchTo().window(winid);
			
			String acturl = driver.getCurrentUrl();    
			if( acturl.contains(partialURL) ) 
				break;
				
		}
		
	}
//	public WebDriver switchToTabUsingURL(WebDriver driver, String partialURL) {
//		Set<String> wid = driver.getWindowHandles();
//		for (String string : wid) {
//			
//			if( driver.getCurrentUrl().contains(partialURL) ) {
//				driver.switchTo().window(string);
//				break;
//			}
//		}
//		return driver;
//	}
	
	public void switchToTabUsingTitle(WebDriver driver, String partialTitle) {
		Set<String> wid = driver.getWindowHandles();
		for (String string : wid) {
			
			if( driver.getTitle().contains(partialTitle) ) {
				driver.switchTo().window(string);
				break;
			}
		}
	}
	
	public void switchToFramUsingIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFramUsingID(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFramUsingWebElement(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}
	
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void selectByText(WebElement ele ,String text) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}
	public void selectByIndex(WebElement ele ,int index) {
		Select select = new Select(ele);
		select.selectByIndex(index);
	}
	
	public void mouseMoveOnElement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement ele){
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	public void elementToBeClickabe(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
