package com.practice.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.basetest.BaseClass;

@Listeners(com.comcast.crm.listernerUtility.ListernerImplementation.class)
public class TicketBook extends BaseClass{
	
	@Test
	public void bookTicket() {
		System.out.println("Ticket booking via UPI.");
		System.out.println("Step - 1");
		System.out.println("Step - 2");
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, "Login");
		System.out.println("Step - 3");
		System.out.println("Step - 4");
	}
	
	
	@Test(retryAnalyzer = com.comcast.crm.listernerUtility.RetryListener.class)
	public void bookTicketViaCard() {
		System.out.println("Ticket booking via Credit Card.");
		Assert.assertEquals("", "Login");
	}
}
