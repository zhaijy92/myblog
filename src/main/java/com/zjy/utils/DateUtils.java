package com.zjy.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author JH  2015
 */
public class DateUtils {
	public static Date getTodayDate() {
		Date today = Calendar.getInstance().getTime();
		return today;
	}

	public static String getToday() {
		Date today = Calendar.getInstance().getTime();
		java.text.Format format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		return format.format(today);
	}

	public static String getToday(String dspType) {
		if (dspType == null)
			dspType = "yyyy-MM-dd";

		Date today = Calendar.getInstance().getTime();
		try {
			java.text.Format format = new java.text.SimpleDateFormat(dspType);
			return format.format(today);
		} catch (IllegalArgumentException e) {
			return getToday();
		}
	}

	public static Date string2Date(String date) {
		if (date == null || date.length() < 8)
			return null;

		if (date.length() < 12)
			date += " 00:00:00";

		String[] parts = date.split(" ");
		if (parts != null) {
			String dateStr = parts[0];
			String timeStr = parts[1];
			
			String[] dateParts = dateStr.split("-");
			String[] timeParts = timeStr.split(":");
			
			int year = 0, month = 0, day = 0, hour = 0, min = 0, second = 0;
			if(dateParts.length >= 3) { 
				year = Integer.parseInt(dateParts[0]); 
				month = Integer.parseInt(dateParts[1]) - 1; 
				day = Integer.parseInt(dateParts[2]);
			}
			
			if(timeParts.length >= 3) { 
				hour = Integer.parseInt(timeParts[0]); 
				min = Integer.parseInt(timeParts[1]); 
				second = Integer.parseInt(timeParts[2]);
			}
			
			GregorianCalendar gc = new GregorianCalendar(year, month,
                    day, hour, min, second);
			
			return gc.getTime();
		}
        
		return null;
         
        /*
         * 以下这种方式在linux中不可用
		DateFormat df = DateFormat.getDateTimeInstance();
		try {
			return df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		*/
	}

	public static String date2String(Date date) {
		Calendar myCal = Calendar.getInstance();
		myCal.setTime(date);
		int tmpInt;

		StringBuffer myString = new StringBuffer();

		myString.append(myCal.get(Calendar.YEAR));
		myString.append("-");

		tmpInt = myCal.get(Calendar.MONTH) + 1;
		myString.append(StringUtils.intToString(tmpInt, 2));
		myString.append("-");

		tmpInt = myCal.get(Calendar.DAY_OF_MONTH);
		myString.append(StringUtils.intToString(tmpInt, 2));
		myString.append(" ");

		tmpInt = myCal.get(Calendar.HOUR_OF_DAY);
		myString.append(StringUtils.intToString(tmpInt, 2));
		myString.append(":");

		tmpInt = myCal.get(Calendar.MINUTE);
		myString.append(StringUtils.intToString(tmpInt, 2));
		myString.append(":");

		tmpInt = myCal.get(Calendar.SECOND);
		myString.append(StringUtils.intToString(tmpInt, 2));

		return myString.toString();
	}

	public static boolean isWeekend(String date) {
		int week = getWeekAsNumber(date);
		if (week == 6 || week == 7)
			return true;
		else
			return false;
	}

	public static int getWeekAsNumber(String date) {
		int year;
		int month;
		int day;

		year = Integer.parseInt(date.substring(0, 4));
		month = Integer.parseInt(date.substring(5, 7)) - 1;
		day = Integer.parseInt(date.substring(8, 10));

		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		int countWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (countWeek == 1)
			return 7;
		else
			return countWeek - 1;
	}

	public static String getCurrentYear() {
		return getToday().substring(0, 4);
	}

	public static String getCurrentMonth() {
		return getToday().substring(5, 7);
	}

	public static String getCurrentDay() {
		return getToday().substring(8);
	}

	public static List<Integer> getYearAreaList() {
		List<Integer> years = new ArrayList<Integer>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = 3; i >= 0; i--) {
			years.add(new Integer(year - i));
		}

		for (int i = 1; i <= 3; i++) {
			years.add(new Integer(year + i));
		}

		return years;
	}
	
    public static String getNearMonth(int num){
    	java.text.Format format = new java.text.SimpleDateFormat("yyyy-MM-dd");
    	Date today=DateUtils.getTodayDate();
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(today);
    	cal.add(Calendar.MONTH, -num);
    	
    	return format.format(cal.getTime());
    }
    
    /**
	 * 比较两个日期的大小
	 * @param date1：日期1
	 * @param date2：日期2
	 * @return 1：date1 > date2  -1：date1 < date2   0:date1 = date2
	 */
	public static int compareDate(Date date1, Date date2) {
		if (date1.getTime() > date2.getTime())
			return 1;
		else if (date1.getTime() < date2.getTime())
			return -1;
		else
			return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtils.string2Date("2013-09-09"));
	}
}
