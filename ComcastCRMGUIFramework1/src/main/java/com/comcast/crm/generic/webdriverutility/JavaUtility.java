package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNum() {
		Random random = new Random();
		int ran = random.nextInt(3000);
		return ran;
	}
	
	public String getSystemDateYYYYMMDD() {
		java.util.Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public String getReqDateFromGnDate(int days) {
		/*This method will add or subtract the given days from the current date 
		 * and give back the resultant in the form of yyyy-mm-dd 
		 */
		SimpleDateFormat simDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = simDate.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = simDate.format(cal.getTime());
		return reqDate;
	}
}
