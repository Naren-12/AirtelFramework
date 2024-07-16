package com.crm.basetest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.excelutitlity.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectutility.HomePageRepo;
import com.comcast.crm.objectutility.LoginPageRepo;
import com.crm.generic.databaseutility.DatabaseUtility;

public class BaseClass {
	
	public DatabaseUtility dbUtil = new DatabaseUtility();
	public FileUtility fileUtil = new FileUtility();
	public ExcelUtility exUtil = new ExcelUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wbUtil = new WebDriverUtility();
	public WebDriver driver ;
	public static WebDriver sDriver ;
	public SoftAssert softAssert = new SoftAssert();
	
	@BeforeSuite(groups = {"Smoke Testing", "Regression Testing"})
	public void configBefoSuite() throws Throwable {
		dbUtil.getDbconnection();
	}
	
//	@Parameters("BrowserName")
	@org.testng.annotations.BeforeClass(groups = {"Smoke Testing", "Regression Testing"})
	public void configBefoClass() throws Throwable {
		String browserName = fileUtil.getDataFromProp("browser");
		
		if (browserName.equals("chrome"))
			driver = new ChromeDriver();
		else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge"))
			driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		sDriver = driver;
	}
	
	@BeforeMethod(groups = {"Smoke Testing", "Regression Testing"})
	public void configBefoMethod() throws Throwable {
		String url = fileUtil.getDataFromProp("url");
		String usrName =fileUtil.getDataFromProp("username");
		String pwrd =fileUtil.getDataFromProp("password");
		
		LoginPageRepo loginPage = new LoginPageRepo(driver);
		loginPage.login(url, usrName, pwrd);
	}
	
	@AfterMethod(groups = {"Smoke Testing", "Regression Testing"})
	public void configAftMethod() {
		HomePageRepo hmPage = new HomePageRepo(driver);
		hmPage.logout();
	}
	
	@AfterClass(groups = {"Smoke Testing", "Regression Testing"})
	public void configAftClass() {
		driver.manage().window().minimize();
		driver.quit();
		softAssert.assertAll();
	}
	
	
	@AfterSuite(groups = {"Smoke Testing", "Regression Testing"})
	public void configAftSuite() throws Throwable {
		dbUtil.closeDbConnection();
	}
}
