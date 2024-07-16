package com.comcast.crm.listernerUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.basetest.BaseClass;

public class ListernerImplementation implements ITestListener, ISuiteListener{
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		ISuiteListener.super.onStart(suite);
		System.out.println("Report Config");
		
		//extentreporter
		spark = new ExtentSparkReporter("./ExtendReport/Report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("extent report");
		spark.config().setReportName("Naren");
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Platform :", " Windows - 8.");
		report.setSystemInfo("Executed By:", " Naren.");
		report.setSystemInfo("Reviewed By: ", " Aravindan.");
	}

	@Override
	public void onFinish(ISuite suite) {
		ISuiteListener.super.onFinish(suite);
		report.flush();
		System.out.println("Report Backup");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test = report.createTest(result.getMethod().getMethodName());
		System.out.println("Name of test case: " + result.getMethod().getMethodName() );
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println("Test got ended.");
		
		test.log(Status.PASS, result.getMethod().getMethodName() + " - Finished.");
		test.log(Status.PASS, result.getThrowable()	);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		String methName = result.getMethod().getMethodName();
		
		TakesScreenshot tscrn = (TakesScreenshot) BaseClass.sDriver;
		File file = tscrn.getScreenshotAs(OutputType.FILE);
		
		File scrnShot = new File("./Screenshot/"+ methName + LocalDateTime.now().toString().replace(":","_") + ".png");
	
		try {
			FileUtils.copyFile(file, scrnShot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	
	
}
