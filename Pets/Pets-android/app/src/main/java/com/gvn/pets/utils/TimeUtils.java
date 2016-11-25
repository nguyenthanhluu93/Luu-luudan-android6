package com.gvn.pets.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
//import java.util.concurrent.TimeUnit;
import java.util.TimeZone;

/**
 * @author Created by Robert Hoang on 22 Nov 2016
 * TimeUtil is a utility class with static methods to convert times in various
 * formats into other formats
 */

public class TimeUtils {
	public static final int MINS_PER_DAY = 60 * 24;
	public static final long MS_PER_DAY = 1000 * 60 * MINS_PER_DAY;

	private static final int SEC = 1000;
	private static final int MIN = SEC * 60;
	private static final int HOUR = MIN * 60;
	private static final int DAY = HOUR * 24;
	private static final long WEEK = DAY * 7;
	private static final long YEAR = WEEK * 52;

	public static final long[] buckets = { YEAR, WEEK, DAY, HOUR, MIN, SEC };
	public static final String[] bucketNames = { "year", "week", "day",
			"hour", "minute", "second" };

	public static GregorianCalendar statFmtCal = new GregorianCalendar();

	public static final String ts24Pat = "H:mm:ss yy-MM-dd";

	// convert a minute-of-week time to time of day as dd:dd (24 hour format)
	public static String string24Format(short time) {
		// test for uninitialized time
		if (time == -1) {
			return "??";
		}
		StringBuffer sBuf = new StringBuffer(5);

		// int hour, min;
		int hour = (time % MINS_PER_DAY) / 60;

		if (hour == 0) {
			hour = 24;
		}

		if (hour < 10)
			sBuf.append(" ");

		sBuf.append(Integer.toString(hour));
		sBuf.append(":");

		int min = (time % 1440) % 60;
		if (min < 10)
			sBuf.append("0");

		sBuf.append(Integer.toString(min));

		return (sBuf.toString());
	}
	
	public static String convertHourTodayWeek(int numHour) {
		try {
			/**
			 * 1day = 24 hours
			 * 1week = 7days = 7 * 24 hour
			 * 8days = 1week + 1
			 * 27hours = 1day + 3
			 */
			if (numHour < 24) return numHour + "hours";
			if (numHour == 24) return "1days";
			int modHours = Math.round(numHour % 24);
			
			int daysLeft = 0;
			int weeks = Math.abs(numHour / (24 * 7));
			if (weeks > 0) daysLeft = (numHour - weeks * (24 * 7)) / 24;
			else daysLeft = numHour / 24;
			
			System.out.println(numHour + "numHour==>" + "weeks=" + weeks + "|days=" + daysLeft + "|modHours=" + modHours);
			String result = "";
			if (weeks == 1) result = "1week";
			else if (weeks > 1) result = weeks + "weeks";
			
			if (daysLeft == 1) {
				if (StringUtils.isEmptyOrNull(result)) result = "1day";
				else result += " 1days";
			} else if (daysLeft > 1) {
				if (StringUtils.isEmptyOrNull(result)) result = daysLeft + "days";
				else result += " " + daysLeft + "days";
			}
			if (modHours == 1) {
				if (StringUtils.isEmptyOrNull(result)) result = "1hour";
				else result += " 1hour";
			} else if (modHours > 1) {
				if (StringUtils.isEmptyOrNull(result)) result = modHours + "hours";
				else result += " " + modHours + "hours";
			}
			return result;
		} catch (Exception e) {
		}
		return "";
	}
	
	public static String convertHourTodayWeekOfOkazu(int numHour) {
		try {
			/**
			 * 1day = 24 hours
			 * 1week = 7days = 7 * 24 hour
			 * 8days = 1week + 1
			 * 27hours = 1day + 3
			 */
			if (numHour < 24) return numHour + "hours";
			if (numHour == 24) return "1days";
			int modHours = Math.round(numHour % 24);
			
			int daysLeft = 0;
			int weeks = Math.abs(numHour / (24 * 7));
			if (weeks > 0) daysLeft = (numHour - weeks * (24 * 7)) / 24;
			else daysLeft = numHour / 24;
			
			System.out.println(numHour + "numHour==>" + "weeks=" + weeks + "|days=" + daysLeft + "|modHours=" + modHours);
			String result = "";
			if (weeks == 1) result = "1week";
			else if (weeks > 1) result = weeks + "weeks";
			
			if (daysLeft > 0) {
				if (daysLeft == 1) {
					if (StringUtils.isEmptyOrNull(result)) result = "1day";
					else result += "+";
				} else if (StringUtils.isEmptyOrNull(result)) result = daysLeft + "days";
				else result += "+";
			}
			if (modHours > 0 && (daysLeft < 1 || weeks == 0)) {
				if (modHours == 1) {
					if (StringUtils.isEmptyOrNull(result)) result = "1hour";
					else result += "+";
				} else if (StringUtils.isEmptyOrNull(result)) result = modHours + "hours";
				else result += "+";
			}
			return result;
		} catch (Exception e) {
		}
		return "";
	}
	
	public static String convertMillisecondsToTimeString(long millis) {
		if (millis < 0) return "";
		try {
			// with java.util.Date/Calendar api
			final Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(millis);
			// here's how to get the minutes
			final int minutes = cal.get(Calendar.MINUTE);
			// and here's how to get the String representation
			final String timeString = new SimpleDateFormat("HH:mm:ss:SSS").format(cal.getTime());
			System.out.println(minutes);
			System.out.println(timeString);
			return timeString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
    }
	
	public static String convertMillis2TimeString(long milliseconds) {
		long seconds = 0, minutes = 0, hours = 0;
		try {
			seconds = milliseconds / 1000;
			hours = seconds / 3600;
			seconds = seconds % 3600;
			seconds = seconds / 60;
			minutes = minutes % 60;
		} catch (Exception e) {
		}
		return ((hours < 10 ? "0" + hours : hours) + ":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (seconds < 10 ? "0" + seconds : seconds));
	}
	
	/*@SuppressLint("NewApi")
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)*/
	public static String convertMillisToTimeString(long millis) {
		try {
			String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
		            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
		            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
			return hms;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * Convert milliseconds to HHMM. Example: 3660000ms --> 01:01 <-> 01h01m
	 * @param millis
	 * @return String HH:MM
	 */
	public static String convertMillisToHourMinuteString(long millis) {
		try {
			String hms = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
		            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)));
			return hms;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * Convert string Time HHMM to seconds
	 * @param hhmmString
	 */
    public static long convertStringHourMinuteToSeconds(String hhmmString) {
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));//GMT
            //String inputString = "336:00:00"; //--> 1209600000 milliseconds --> 1209600 seconds

            Date date = sdf.parse("1970-01-01 " + hhmmString);
            long seconds = date.getTime()/1000;
            System.out.println("To seconds=" + seconds);
            
            return seconds;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return -1;
    }
	
	/**
	 * Convert string Time HHMM to milliseconds
	 * @param hhmmString
	 */
    public static long convertStringHourMinuteToMilliseconds(String hhmmString) {
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));//GMT
            //String inputString = "336:00:00"; //--> 1209600000 milliseconds --> 1209600 seconds

            Date date = sdf.parse("1970-01-01 " + hhmmString);
            long milliseconds = date.getTime();
            System.out.println("To milliseconds=" + milliseconds);
            
            return milliseconds;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return -1;
    }
    
	/**
	 * Convert string Time HHMM to milliseconds
	 * @param hhmmString. Example: 336:00:00
	 * @param dateFormatString. Example: yyyy-MM-dd HH:mm:ss
	 * @param timeZoneId. Example: GMT, UTC
	 * @return
	 */
    public static long convertStringHourMinuteToMilliseconds(String hhmmString, String dateFormatString, String timeZoneId) {
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat(dateFormatString);
            sdf.setTimeZone(TimeZone.getTimeZone(timeZoneId));//GMT, UTC
            //String inputString = "336:00:00"; //--> 1209600000 milliseconds --> 1209600 seconds

            Date date = sdf.parse("1970-01-01 " + hhmmString);
            long milliseconds = date.getTime();
            System.out.println("To milliseconds=" + milliseconds);
            
            return milliseconds;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return -1;
    }
	
	public static void main(String[] args) {
		//short day = (1000 * 60 * 60 * 24); // 24 hours in milliseconds
		//short time = day * 39; // for example, 39 days
		//System.out.println(string24Format((short)(1000 * 60 * 60 * 24)));
		System.out.println(convertHourTodayWeek(27));//27Hours = 1day + 3
		System.out.println("---------------------------------------");
		System.out.println(convertHourTodayWeek(169));//169Hours = 1week + 1Hour
		System.out.println("---------------------------------------");
		System.out.println(convertHourTodayWeek(195));//195Hours = 1week + 1day + 3Hours
		System.out.println("---------------------------------------");
		System.out.println(convertHourTodayWeek(315));//312Hours = 1week + 6day + 3Hours
		System.out.println("---------------------------------------");
		System.out.println(convertHourTodayWeek(336));//336Hours = 2weeks
		System.out.println("---------------------------------------");
		System.out.println(convertHourTodayWeek(360));//360Hours = 2weeks + 1days
		System.out.println("---------------------------------------");
		System.out.println(convertHourTodayWeek(365));//360Hours = 2weeks + 1days + 5Hours
		
		System.out.println(convertHourTodayWeekOfOkazu(27));//27Hours = 1day +
		System.out.println("---------------------------------------");
		System.out.println(convertHourTodayWeekOfOkazu(169));//169Hours = 1week +
		System.out.println("---------------------------------------");
		System.out.println(convertHourTodayWeekOfOkazu(195));//195Hours = 1week +
		System.out.println("---------------------------------------");
		System.out.println(convertHourTodayWeekOfOkazu(315));//312Hours = 1week +
		System.out.println("---------------------------------------");
		System.out.println(convertHourTodayWeekOfOkazu(336));//336Hours = 2weeks
		System.out.println("---------------------------------------");
		System.out.println(convertHourTodayWeekOfOkazu(360));//360Hours = 2weeks +
		System.out.println("---------------------------------------");
		System.out.println(convertHourTodayWeekOfOkazu(365));//360Hours = 2weeks +
		
		System.out.println("===============================================");
		System.out.println("432000s convertMillisecondsToTimeString=" + convertMillisecondsToTimeString(432000 * 1000));
		System.out.println("432000s convertMillis=" + convertMillis2TimeString(432000 * 1000));
		System.out.println("432000s convertMillisToTimeString=" + convertMillisToTimeString(432000 * 1000));
	}
}
