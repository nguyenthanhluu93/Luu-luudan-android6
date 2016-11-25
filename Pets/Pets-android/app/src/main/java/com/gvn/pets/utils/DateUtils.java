/*
 * @author Created by Robert Hoang on 22 Nov 2016
 */
package com.gvn.pets.utils;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import java.util.TimeZone;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

import com.gvn.pets.R;

// TODO: Auto-generated Javadoc
//TODO: Auto-generated Javadoc
/* (non-Javadoc)
* @see 
 * The Class DateUtils.
 */
public class DateUtils {
	
	/** getDifferenceTime=60000 milliseconds --> Difference Time = 1 Minute getDifferenceTime=3600000 milliseconds --> Difference Time = 1 Hour getDifferenceTime=86400000 milliseconds --> Difference Time = 1 Day. */
	public static final long ONE_MINUTE = 60000;//milliseconds
	
	/** The Constant ONE_HOUR. */
	public static final long ONE_HOUR = 3600000;//milliseconds
	
	/** The Constant ONE_DAY. */
	public static final long ONE_DAY = 86400000;//milliseconds

	/**
	 * Instantiates a new date utils.
	 */
	private DateUtils() {  }

	/**
	 * Gets the month name.
	 *
	 * @param month the month
	 * @return the month name
	 */
	public static String getMonthName(int month) {
		return getMonthName(month, Locale.getDefault());
	}

	/**
	 * Gets the month name.
	 *
	 * @param month the month
	 * @param locale the locale
	 * @return the month name
	 */
	public static String getMonthName(int month, Locale locale) {
		DateFormatSymbols symbols = new DateFormatSymbols(locale);
		String[] monthNames = symbols.getMonths();
		return monthNames[month - 1];
	}
  
	/**
	 * Gets the day name.
	 *
	 * @param day the day
	 * @param locale the locale
	 * @return the day name
	 */
	public static String getDayName(int day, Locale locale) {
		DateFormatSymbols symbols = new DateFormatSymbols(locale);
		String[] dayNames = symbols.getWeekdays();
		return dayNames[day];
	}
  
	  /**
  	 * Convert format history.
  	 *
  	 * @param eventTime the event time
  	 * @param currFormat the curr format
  	 * @return the string
  	 */
  	public static String convertFormatHistory(String eventTime, String currFormat) {
		  //2014-08-12T15:32:41+09:00 <-> yyyy-MM-ddTHH:mm:ssZ
			String result = "";
			TimeZone tz = TimeZone.getTimeZone("UTC");
			// create a date object for testing
			DateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.JAPAN);
			fromFormat.setTimeZone(tz);
			try {
				Date date = fromFormat.parse(eventTime);
				Calendar cl = Calendar.getInstance();
			    ////System.out.println("current: "+cl.getTime());
			    TimeZone z = cl.getTimeZone();
				DateFormat toFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault());
				toFormat.setTimeZone(z);
				toFormat.setLenient(false);
				result = toFormat.format(date);
	
			} catch (ParseException e) {
				e.printStackTrace();
			}
		  return result;
	  }
	  
	  /**
  	 * Convert format history.
  	 *
  	 * @param eventTime the event time
  	 * @param currFormat the curr format
  	 * @param outFormat the out format
  	 * @return the string
  	 */
  	public static String convertFormatHistory(String eventTime, String currFormat, String outFormat) {
		  //2014-08-12T15:32:41+09:00 <-> yyyy-MM-ddTHH:mm:ssZ
			String result = "";
			TimeZone tz = TimeZone.getTimeZone("UTC");
			// create a date object for testing
			DateFormat fromFormat = new SimpleDateFormat(currFormat, Locale.JAPAN);
			fromFormat.setTimeZone(tz);
			try {
				Date date = fromFormat.parse(eventTime);
				Calendar cl = Calendar.getInstance();
			    ////System.out.println("current: "+cl.getTime());
			    TimeZone z = cl.getTimeZone();
				DateFormat toFormat = new SimpleDateFormat(outFormat, Locale.getDefault());
				toFormat.setTimeZone(z);
				toFormat.setLenient(false);
				result = toFormat.format(date);
	
			} catch (ParseException e) {
				e.printStackTrace();
			}
		  return result;
	  }
	
	  /**
  	 * Convert time to default time history.
  	 *
  	 * @param eventTime the event time
  	 * @param currFormat the curr format
  	 * @param outFormat the out format
  	 * @return the string
  	 */
  	public static String convertTimeToDefaultTimeHistory(String eventTime, String currFormat, String outFormat) {
			String result = "";
			TimeZone tz = TimeZone.getDefault();
			// create a date object for testing
			DateFormat fromFormat = new SimpleDateFormat(currFormat, Locale.getDefault());
			fromFormat.setTimeZone(tz);
			try {
				Date date = fromFormat.parse(eventTime);
				Calendar cl = Calendar.getInstance();
			    ////System.out.println("current: "+cl.getTime());
			    TimeZone z = cl.getTimeZone();
				DateFormat toFormat = new SimpleDateFormat(outFormat, Locale.getDefault());
				toFormat.setTimeZone(z);
				//toFormat.setLenient(false);
				result = toFormat.format(date);
	
			} catch (ParseException e) {
				e.printStackTrace();
			}
		  return result;
	  }
	  
	  /**
  	 * Display date.
  	 *
  	 * @param currentLocale the current locale
  	 */
  	public static void displayDate(Locale currentLocale) {
	
			Date today;
			String dateOut;
			DateFormat dateFormatter;
	
			dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT,
					currentLocale);
			today = new Date();
			dateOut = dateFormatter.format(today);
	
			////System.out.println(dateOut + "   " + currentLocale.toString());
		}
	
	  /**
  	 * Show both styles.
  	 *
  	 * @param currentLocale the current locale
  	 */
  	public static void showBothStyles(Locale currentLocale) {
			Date today;
			String result;
			DateFormat formatter;
	
			int[] styles = { DateFormat.DEFAULT, DateFormat.SHORT,
					DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL };
	
			//System.out.println();
			//System.out.println("Locale: " + currentLocale.toString());
			//System.out.println();
	
			today = new Date();
	
			for (int k = 0; k < styles.length; k++) {
				formatter = DateFormat.getDateTimeInstance(styles[k], styles[k],
						currentLocale);
				result = formatter.format(today);
				//System.out.println(result);
			}
	
		}
	
	  /**
  	 * Show date styles.
  	 *
  	 * @param currentLocale the current locale
  	 */
  	public static void showDateStyles(Locale currentLocale) {
	
			Date today = new Date();
			String result;
			DateFormat formatter;
	
			int[] styles = { DateFormat.DEFAULT, DateFormat.SHORT,
					DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL };
	
			//System.out.println();
			//System.out.println("Locale: " + currentLocale.toString());
			//System.out.println();
	
			for (int k = 0; k < styles.length; k++) {
				formatter = DateFormat.getDateInstance(styles[k], currentLocale);
				result = formatter.format(today);
				//System.out.println(result);
			}
		}
	
	   /**
   	 * Show time styles.
   	 *
   	 * @param currentLocale the current locale
   	 */
   	public static void showTimeStyles(Locale currentLocale) {
	
			Date today = new Date();
			String result;
			DateFormat formatter;
	
			int[] styles = { DateFormat.DEFAULT, DateFormat.SHORT,
					DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL };
	
			//System.out.println();
			//System.out.println("Locale: " + currentLocale.toString());
			//System.out.println();
	
			for (int k = 0; k < styles.length; k++) {
				formatter = DateFormat.getTimeInstance(styles[k], currentLocale);
				result = formatter.format(today);
				//System.out.println(result);
			}
		}
		  
	   /**
   	 * Show both.
   	 *
   	 * @param eventTime the event time
   	 * @param currentLocale the current locale
   	 */
   	public static void showBoth(String eventTime, Locale currentLocale) {
			try {
				String result;
				TimeZone tz = TimeZone.getTimeZone("UTC");
				// create a date object for testing
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.JAPAN);
				formatter.setTimeZone(tz);
				Date date = formatter.parse(eventTime);
				formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, currentLocale);
				result = formatter.format(date);
				//System.out.println(result);
			} catch (ParseException e) {
			}
		}
	  
	   /**
   	 * Convert format.
   	 *
   	 * @param eventTime the event time
   	 */
   	public static void convertFormat(String eventTime) {
			try {
				TimeZone tz = TimeZone.getTimeZone("UTC");
				// create a date object for testing
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.JAPAN);
				formatter.setTimeZone(tz);
				Date date = formatter.parse(eventTime);
				//DateFormat fullDf = DateFormat.getDateInstance(DateFormat.FULL, new Locale("ja"));//Locale.getDefault()
				//String newFormat = fullDf.format(date);
				////System.out.println(newFormat);
				//System.out.println(DateFormat.getDateInstance(DateFormat.FULL, Locale.US).format(date));
				
				////System.out.println(DateFormat.getDateInstance(DateFormat.FULL, Locale.FRANCE).format(date));
				////System.out.println(DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMAN).format(date));
			} catch (ParseException e) {
			}
		}
	   
	   /**
   	 * Convert format by locale.
   	 *
   	 * @param eventTime the event time
   	 * @return the string
   	 */
   	public static String convertFormatByLocale(String eventTime) {
			try {
				TimeZone tz = TimeZone.getTimeZone("UTC");
				// create a date object for testing
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.JAPAN);
				formatter.setTimeZone(tz);
				Date date = formatter.parse(eventTime);
				DateFormat fullDf = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
				String newFormat = fullDf.format(date);
				////System.out.println(newFormat);
				return newFormat;
			} catch (ParseException e) {
			}
			return "";
		}
	   
	   /**
   	 * Convert format by locale.
   	 *
   	 * @param eventTime the event time
   	 * @param currFormat the curr format
   	 * @return the string
   	 */
   	public static String convertFormatByLocale(String eventTime, String currFormat) {
			try {
				TimeZone tz = TimeZone.getTimeZone("UTC");
				// create a date object for testing
				DateFormat formatter = new SimpleDateFormat(currFormat, Locale.JAPAN);
				formatter.setTimeZone(tz);
				Date date = formatter.parse(eventTime);
				DateFormat fullDf = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
				String newFormat = fullDf.format(date);
				////System.out.println(newFormat);
				return newFormat;
			} catch (ParseException e) {
			}
			return "";
		}
	   
 // TODO: Auto-generated Javadoc
   	/* (non-Javadoc)
   	 * @see 
   	 * Convert format by locale.
   	 *
   	 * @param eventTime the event time
   	 * @param currFormat the curr format
   	 * @param mContext the m context
   	 * @return the string
   	 */
   	public static String convertFormatByLocale(String eventTime, String currFormat, Context mContext) {
			try {
				TimeZone tz = TimeZone.getTimeZone("UTC");
				// create a date object for testing
				DateFormat formatter = new SimpleDateFormat(currFormat, Locale.JAPAN);
				formatter.setTimeZone(tz);
				Date date = formatter.parse(eventTime);
				DateFormat fullDf = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
				String newFormat = fullDf.format(date);
				////System.out.println(newFormat);
				String prefix = "";
				Log.d("DEBUG", "sDate=" + eventTime);
				Log.d("DEBUG", "getTodayDateString()=" + getTodayDateString("yyyy-MM-dd"));
				Log.d("DEBUG", "getYesterdayDateString()=" + getYesterdayDateString());
				if (eventTime.contains(getTodayDateString("yyyy-MM-dd"))) prefix = mContext.getString(R.string.today);
				else if (eventTime.contains(getYesterdayDateString())) prefix = mContext.getString(R.string.yesterday);
				Log.d("DEBUG", "prefix=" + prefix);
				return ((StringUtils.isEmptyOrNull(prefix) ? "" : prefix + " - ") + newFormat);
			} catch (ParseException e) {
			}
			return "";
		}
	   
 // TODO: Auto-generated Javadoc
   	/* (non-Javadoc)
   	 * @see 
   	 * Convert format from japan to locale.
   	 *
   	 * @param eventTime the event time
   	 * @param currFormat the curr format
   	 * @param mContext the m context
   	 * @return the string
   	 */
   	public static String convertFormatFromJapanToLocale(String eventTime, String currFormat, Context mContext) {
			try {
				TimeZone tz = TimeZone.getTimeZone("UTC");
				// create a date object for testing
				DateFormat formatter = new SimpleDateFormat(currFormat, Locale.JAPAN);
				formatter.setTimeZone(tz);
				Date date = formatter.parse(eventTime);
				
				Calendar cl = Calendar.getInstance();
			    TimeZone z = cl.getTimeZone();
			    DateFormat toFormat = new SimpleDateFormat(currFormat, Locale.getDefault());
				toFormat.setTimeZone(z);
				toFormat.setLenient(false);
				String eventTimeTmp = toFormat.format(date);
				//System.out.println("------------------>" + eventTimeTmp);
				date = toFormat.parse(eventTimeTmp);
				DateFormat fullDf = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
				String resultEventTime = fullDf.format(date);
				//System.out.println("=====================>" + resultEventTime);
				String prefix = "";
				//Log.d("DEBUG", "getTodayDateString()=" + getTodayDateString());
				//Log.d("DEBUG", "getYesterdayDateString()=" + getYesterdayDateString());
				
				if (eventTime.contains(getTodayDateString("yyyy-MM-dd"))) prefix = mContext.getString(R.string.today);
				else if (eventTime.contains(getYesterdayDateString())) prefix = mContext.getString(R.string.yesterday);
	
				return ((StringUtils.isEmptyOrNull(prefix) ? "" : prefix + " - ") + resultEventTime);
				
			} catch (ParseException e) {
			}
			return "";
		}
	   
	 /**
	 * Convert eventTime to Japan format.
	 *
	 * @param eventTime the event time
	 * @param currFormat the curr format
	 * @return the string
	 */
	public static String convert2JapanFormat(String eventTime, String currFormat) {
		try {
			TimeZone tz = TimeZone.getTimeZone("Asia/Tokyo");//TimeZone.getTimeZone("Japan")
			// create a date object for testing
			DateFormat jpFormatter = new SimpleDateFormat(currFormat, Locale.JAPAN);
			jpFormatter.setTimeZone(tz);
			Date date = jpFormatter.parse(eventTime);
			return jpFormatter.format(date);
		} catch (ParseException e) {
		}
		return "";
	}
   	
   	/**
   	 * Convert2 japan format.
   	 *
   	 * @param sDate the s date
   	 * @return the string
   	 */
   	public static String convert2JapanFormat(String sDate) {
			  String desDateTime = "";
			  try {
					String[] mDateContent = StringUtils.splits(sDate, "-");
					String mYear = "";
					String mMonth = "";
					String mDay = "";
	
					Calendar cal = Calendar.getInstance();
					int year = Integer.parseInt(mDateContent[0]);
					int month = Integer.parseInt(mDateContent[1]) - 1;
					int day = Integer.parseInt(mDateContent[2]);
					
					cal.set(Calendar.DAY_OF_MONTH, day);
					cal.set(Calendar.MONTH, month);
					cal.set(Calendar.YEAR, year);
					int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	
					mYear = mDateContent[0]/* + " 年" */;
					mMonth = jpMonthName.get(mDateContent[1]);//mMonth = mDateContent[1] + " 月";
					mDay = mDateContent[2]/* + " 日" */;
					desDateTime = DateUtils.getDayName(dayOfWeek, Locale.JAPAN) + ", " + mMonth + " " + mDay + ", " + mYear;
				} catch (Exception e) {
				}
			return desDateTime;
		  }
	   
	  /**
  	 * Convert2 japan format.
  	 *
  	 * @param sDate the s date
  	 * @param mContext the m context
  	 * @return the string
  	 */
  	public static String convert2JapanFormat(String sDate, Context mContext) {
		  String desDateTime = "";
		  try {
				String[] mDateContent = StringUtils.splits(StringUtils.replaceAll(sDate, ":", "-"), "-");
				String mYear = "";
				String mMonth = "";
				String mDay = "";
	
				Calendar cal = Calendar.getInstance();
				int year = Integer.parseInt(mDateContent[0]);
				int month = Integer.parseInt(mDateContent[1]) - 1;
				int day = Integer.parseInt(mDateContent[2]);
				/*int hour = Integer.parseInt(mDateContent[3]);
				int minute = Integer.parseInt(mDateContent[4]);
				int second = Integer.parseInt(mDateContent[5]);*/
				
				/*cal.set(Calendar.SECOND, second);
				cal.set(Calendar.MINUTE, minute);
				cal.set(Calendar.HOUR_OF_DAY, hour);*/
				
				cal.set(Calendar.DAY_OF_MONTH, day);
				cal.set(Calendar.MONTH, month);
				cal.set(Calendar.YEAR, year);
				int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	
				String prefix = "";
				Log.d("DEBUG", "sDate=" + sDate);
				Log.d("DEBUG", "getTodayDateString()=" + getTodayDateString("yyyy-MM-dd"));
				Log.d("DEBUG", "getYesterdayDateString()=" + getYesterdayDateString());
				
				if (sDate.contains(getTodayDateString("yyyy-MM-dd"))) prefix = mContext.getString(R.string.today);
				else if (sDate.contains(getYesterdayDateString())) prefix = mContext.getString(R.string.yesterday);
	
				mYear = mDateContent[0]/* + " 年" */;
				//mMonth = jpMonthName.get(mDateContent[1]);
				mMonth = mDateContent[1];
				mDay = mDateContent[2]/* + " 日" */;
				//desDateTime = (StringUtils.isEmptyOrNull(prefix) ? "" : prefix + " - ") + DateUtils.getDayName(dayOfWeek, Locale.JAPAN) + ", " + mMonth + " " + mDay + ", " + mYear;
				//năm tháng ngày, thứ - hôm nay
				//desDateTime = mYear + " " + mMonth + " " + mDay + ", " + DateUtils.getDayName(dayOfWeek, Locale.JAPAN) + (StringUtils.isEmptyOrNull(prefix) ? "" : " - " + prefix);
				//2014年 8月 16日 土曜日 - 今日
				desDateTime = mYear + "年 " + mMonth + "月 " + mDay + "日 " + DateUtils.getDayName(dayOfWeek, Locale.JAPAN) + (StringUtils.isEmptyOrNull(prefix) ? "" : " - " + prefix);
			} catch (Exception e) {
			}
		return desDateTime;
	  }
	  
	  /** The jp month name. */
  	public static Hashtable<String, String> jpMonthName;
	  static {
		  jpMonthName = new Hashtable<String, String>();
		  jpMonthName.put("01","一月"); jpMonthName.put("1","一月");
		  jpMonthName.put("02","二月"); jpMonthName.put("2","二月");
		  jpMonthName.put("03","三月"); jpMonthName.put("3","三月");
		  jpMonthName.put("04","四月"); jpMonthName.put("4","四月");
		  jpMonthName.put("05","五月"); jpMonthName.put("5","五月");
		  jpMonthName.put("06","六月"); jpMonthName.put("6","六月");
		  jpMonthName.put("07","七月"); jpMonthName.put("7","七月");
		  jpMonthName.put("08","八月"); jpMonthName.put("8","八月");
		  jpMonthName.put("09","九月"); jpMonthName.put("9","九月");
		  jpMonthName.put("10","十月");
		  jpMonthName.put("11","十一月");
		  jpMonthName.put("12","十二月");
	  }
	   
	  /**
  	 * Compare date.
  	 */
  	public static void compareDate() {
	  	try{
	
	  		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      	Date date1 = sdf.parse("2009-12-31");
	      	Date date2 = sdf.parse("2010-01-01");
	
	      	//System.out.println(sdf.format(date1));
	      	//System.out.println(sdf.format(date2));
	
	      	if(date1.compareTo(date2) > 0){
	      		//System.out.println("Date1 is after Date2|date1.compareTo(date2)=" + date1.compareTo(date2));
	      	}else if(date1.compareTo(date2) < 0){
	      		//System.out.println("Date1 is before Date2|date1.compareTo(date2)=" + date1.compareTo(date2));
	      	}else if(date1.compareTo(date2) == 0){
	      		//System.out.println("Date1 is equal to Date2|date1.compareTo(date2)=" + date1.compareTo(date2));
	      	}
	
	  	}catch(ParseException ex){
	  		ex.printStackTrace();
	  	}
	  }
  
	/**
	 * Compare date.
	 *
	 * @param sDateOne the s date one
	 * @param sDateTwo the s date two
	 * @param dateFormat the date format
	 * @return the int
	 */
	public static int compareDate(String sDateOne, String sDateTwo, String dateFormat) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			Date date1 = sdf.parse(sDateOne);
			Date date2 = sdf.parse(sDateTwo);
	
			//System.out.println("date1=" + sdf.format(date1));
	      	//System.out.println("date2=" + sdf.format(date2));
	
			int result = date1.compareTo(date2);
	
			if (result > 0) {
				//System.out.println("sDateOne is after sDateTwo(sDateOne Newest sDateTwo)|result=" + result);
			} else if (result < 0) {
				//System.out.println("sDateOne is before sDateTwo(sDateOne Older sDateTwo)|result=" + result);
			} else if (result == 0) {
				//System.out.println("sDateOne is equal to sDateTwo|result=" + result);
			}
			return result;
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Get max date.
	 *
	 * @param sDateOne the s date one
	 * @param sDateTwo the s date two
	 * @param dateFormat the date format
	 * @return the int
	 */
	public static String getMaxDate(String sDateOne, String sDateTwo, String dateFormat) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			Date date1 = sdf.parse(sDateOne);
			Date date2 = sdf.parse(sDateTwo);
	
			//System.out.println("date1=" + sdf.format(date1));
	      	//System.out.println("date2=" + sdf.format(date2));
	
			int result = date1.compareTo(date2);
	
			if (result > 0) {
				//System.out.println("sDateOne is after sDateTwo(sDateOne Newest sDateTwo)|result=" + result);
				return sDateOne;
			} else if (result < 0) {
				//System.out.println("sDateOne is before sDateTwo(sDateOne Older sDateTwo)|result=" + result);
				return sDateTwo;
			} else if (result == 0) {
				//System.out.println("sDateOne is equal to sDateTwo|result=" + result);
				return sDateOne;
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return "";
	}
	
  /**
   * Compare cal.
   */
  public static void compareCal() {
  	try{

  		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      	Date date1 = sdf.parse("2009-12-31");
      	Date date2 = sdf.parse("2010-01-01");

      	//System.out.println(sdf.format(date1));
      	//System.out.println(sdf.format(date2));

      	Calendar cal1 = Calendar.getInstance();
      	Calendar cal2 = Calendar.getInstance();
      	cal1.setTime(date1);
      	cal2.setTime(date2);

      	if(cal1.after(cal2)){
      		//System.out.println("Date1 is after Date2");
      	}

      	if(cal1.before(cal2)){
      		//System.out.println("Date1 is before Date2");
      	}

      	if(cal1.equals(cal2)){
      		//System.out.println("Date1 is equal Date2");
      	}

  	}catch(ParseException ex){
  		ex.printStackTrace();
  	}
  }
  
  /**
   * Gets the yesterday date string.
   *
   * @return the yesterday date string
   */
  public static String getYesterdayDateString() {
      try {
    	  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
          Calendar cal = Calendar.getInstance();
          cal.add(Calendar.DATE, -1);    
          return dateFormat.format(cal.getTime());
	} catch (Exception e) {
	}
	return "";
  }
  
  public static String getYesterdayDateString(String outFormat, TimeZone timeZone, Locale locale/*Locale.JAPAN*/) {
      try {
    	  DateFormat dateFormat = new SimpleDateFormat(outFormat, locale);
    	  dateFormat.setTimeZone(timeZone);
          Calendar cal = Calendar.getInstance();
          cal.add(Calendar.DATE, -1);    
          return dateFormat.format(cal.getTime());
	} catch (Exception e) {
	}
	return "";
  }
  
  public static String getNearTodayToDateString(String outFormat, TimeZone timeZone, Locale locale/*Locale.JAPAN*/, int numDay) {
      try {
    	  DateFormat dateFormat = new SimpleDateFormat(outFormat, locale);
    	  dateFormat.setTimeZone(timeZone);
          Calendar cal = Calendar.getInstance();
          cal.add(Calendar.DATE, numDay);    
          return dateFormat.format(cal.getTime());
	} catch (Exception e) {
	}
	return "";
  }
  
  /**
   * Gets the today date string.
   *
   * @param outFormat the out format
   * @return the today date string by default Locale
   */
  public static String getTodayDateString(String outFormat) {
      try {
    	  DateFormat dateFormat = new SimpleDateFormat(outFormat, Locale.getDefault());
          Calendar cal = Calendar.getInstance();
          return dateFormat.format(cal.getTime());
	} catch (Exception e) {
	}
	return "";
  }
  
   /**
   * Gets the today date string by Locale
   *
   * @param outFormat the out format
   * @param locale
   * The input locale ex: Locale.JAPAN
   * @param timeZone The input TimeZone
   * @return the today date string
   */
  public static String getTodayDateString(String outFormat, TimeZone timeZone, Locale locale/*Locale.JAPAN*/) {
      try {
    	  //TimeZone timeZone = TimeZone.getTimeZone("Asia/Tokyo");//TimeZone.getTimeZone("Japan")
    	  DateFormat dateFormat = new SimpleDateFormat(outFormat, locale);
    	  dateFormat.setTimeZone(timeZone);
          Calendar cal = Calendar.getInstance();
          return dateFormat.format(cal.getTime());
	} catch (Exception e) {
	}
	return "";
  }
  
	/**
	 * Convert time.
	 *
	 * @param iso8601Format the iso8601 format
	 * @param mContext the m context
	 * @return the string
	 */
	public static String convertTime(String iso8601Format, Context mContext) {
		String result = "";
		TimeZone tz = TimeZone.getTimeZone("UTC");
		// create a date object for testing
		Date date = new Date();

		DateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.JAPAN);
		fromFormat.setTimeZone(tz);
		try {
			date = fromFormat.parse(iso8601Format);
			Calendar cl = Calendar.getInstance();
		    ////System.out.println("current: "+cl.getTime());
		    TimeZone z = cl.getTimeZone();
			//DateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", mContext.getResources().getConfiguration().locale);
		    DateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ", mContext.getResources().getConfiguration().locale);
			toFormat.setTimeZone(z);
			toFormat.setLenient(false);
			result = toFormat.format(date);

		} catch (ParseException e) {
			result = "";
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Calcutate age.
	 *
	 * @param birthday the birthday
	 * @param formatDate the format date
	 * @return the int
	 */
	public static int calcutateAge(String birthday, String formatDate) {
		try {
			TimeZone tz = TimeZone.getTimeZone("UTC");
			// create a date object for testing
			DateFormat dateFormat = new SimpleDateFormat(formatDate, Locale.getDefault());
			dateFormat.setTimeZone(tz);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateFormat.parse(birthday));//cal.add(Calendar.YEAR, 17);
			//get current year
			int currYear = Calendar.getInstance(Locale.getDefault()).get(Calendar.YEAR);
			//System.out.println("cal.get(Calendar.YEAR)=" + cal.get(Calendar.YEAR));
			return currYear - cal.get(Calendar.YEAR);
		} catch (Exception e) {
		}
		return -1;
	}
	
	/**
	 * Enough register.
	 *
	 * @param birthday the birthday
	 * @param formatDate the format date
	 * @param ageEnoughFull the age enough full
	 * @return true, if successful
	 */
	public static boolean enoughRegister(String birthday, String formatDate, int ageEnoughFull) {
		if (calcutateAge(birthday, formatDate) >= ageEnoughFull) return true;
		return false;
	}
	
	/**
	 * Enough full register.
	 *
	 * @param birthday the birthday
	 * @param formatDate the format date
	 * @param ageEnoughFull the age enough full
	 * @return true, if successful
	 */
	public static boolean enoughFullRegister(String birthday, String formatDate, int ageEnoughFull) {
		try {
			TimeZone tz = TimeZone.getTimeZone("UTC");
			// create a date object for testing
			DateFormat dateFormat = new SimpleDateFormat(formatDate, Locale.getDefault());
			dateFormat.setTimeZone(tz);
			Calendar calOfAge = Calendar.getInstance();
			calOfAge.setTime(dateFormat.parse(birthday));
			
			calOfAge.add(Calendar.YEAR, ageEnoughFull);//add more 'ageEnoughFull' years old
			//get current time
			Calendar currCal = Calendar.getInstance(Locale.getDefault());
			
			return (calOfAge.getTimeInMillis() <= currCal.getTimeInMillis());
		} catch (Exception e) {
		}
		return false;
	}
  
	//get current time
	//Calendar currCal = Calendar.getInstance(Locale.getDefault());
	/**
	 * Get time difference between String Time input.
	 *
	 * @param firstTime the first time
	 * @param secondTime the second time
	 * @return milliseconds
	 */
	public static long getDifferenceTime(String firstTime, String secondTime) {
		try {
			TimeZone tz = TimeZone.getDefault();
			// create a date object for testing
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
			dateFormat.setTimeZone(tz);
			
			Calendar calOfFirstTime = Calendar.getInstance();
			calOfFirstTime.setTime(dateFormat.parse(firstTime));
			
			Calendar calOfSecondTime = Calendar.getInstance();
			calOfSecondTime.setTime(dateFormat.parse(secondTime));
			
			return calOfFirstTime.getTimeInMillis() - calOfSecondTime.getTimeInMillis();
		} catch (Exception e) {
		}
		return 0;
	}
	
	/**
	 * Get time difference between String Time input.
	 *
	 * @param firstTime the first time
	 * @param secondTime the second time
	 * @return milliseconds = firstTime - secondTime
	 */
	public static long getDifferenceTime(String firstTime, String secondTime, String outputFormat, Locale locale) {
		try {
			TimeZone tz = TimeZone.getDefault();
			// create a date object for testing
			DateFormat dateFormat = new SimpleDateFormat(outputFormat, locale);
			dateFormat.setTimeZone(tz);
			
			Calendar calOfFirstTime = Calendar.getInstance();
			calOfFirstTime.setTime(dateFormat.parse(firstTime));
			
			Calendar calOfSecondTime = Calendar.getInstance();
			calOfSecondTime.setTime(dateFormat.parse(secondTime));
			Log.i("DifferenceTime", "DifferenceTime=" + (calOfFirstTime.getTimeInMillis() - calOfSecondTime.getTimeInMillis()));
			return calOfFirstTime.getTimeInMillis() - calOfSecondTime.getTimeInMillis();
		} catch (Exception e) {
		}
		return 0;
	}
	
	/**
	 * Get time difference between String Time input.
	 *
	 * @param firstTime the first time
	 * @param secondTime the second time
	 * @return milliseconds = firstTime - secondTime
	 */
	public static long getDifferenceTime(String firstTime, String secondTime, String outputFormat, TimeZone timeZone, Locale locale) {
		try {
			// create a date object for testing
			DateFormat dateFormat = new SimpleDateFormat(outputFormat, locale);
			dateFormat.setTimeZone(timeZone);
			
			Calendar calOfFirstTime = Calendar.getInstance();
			calOfFirstTime.setTime(dateFormat.parse(firstTime));
			
			Calendar calOfSecondTime = Calendar.getInstance();
			calOfSecondTime.setTime(dateFormat.parse(secondTime));
			Log.i("DifferenceTime", "DifferenceTime=" + (calOfFirstTime.getTimeInMillis() - calOfSecondTime.getTimeInMillis()));
			return calOfFirstTime.getTimeInMillis() - calOfSecondTime.getTimeInMillis();
		} catch (Exception e) {
		}
		return 0;
	}
	
	/**
	 * Addition time into inputTime
	 * @param inputTime
	 * @param currFormat
	 * @param locale
	 * @param field
	 * @param amount
	 * @return
	 */
	public static String addTime(String inputTime, String currFormat, TimeZone timeZone, Locale locale, int field, int amount) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(currFormat, locale);
	    	dateFormat.setTimeZone(timeZone);
			Calendar cal = Calendar.getInstance();
			if (field == Calendar.YEAR) {
				cal.add(Calendar.YEAR, amount);	
			} else if (field == Calendar.MONTH) {
				cal.add(Calendar.MONTH, amount);	
			} else if (field == Calendar.DAY_OF_YEAR) {
				cal.add(Calendar.DAY_OF_YEAR, amount);	
			} else if (field == Calendar.DAY_OF_MONTH) {
				cal.add(Calendar.DAY_OF_MONTH, amount);	
			} else if (field == Calendar.DAY_OF_WEEK) {
				cal.add(Calendar.DAY_OF_WEEK, amount);	
			} else if (field == Calendar.DATE) {
				cal.add(Calendar.DATE, amount);	
			} else if (field == Calendar.HOUR_OF_DAY) {
				cal.add(Calendar.HOUR_OF_DAY, amount);	
			} else if (field == Calendar.HOUR) {
				cal.add(Calendar.HOUR, amount);	
			} else if (field == Calendar.MINUTE) {
				cal.add(Calendar.MINUTE, amount);	
			} else if (field == Calendar.SECOND) {
				cal.add(Calendar.SECOND, amount);	
			} else if (field == Calendar.MILLISECOND) {
				cal.add(Calendar.MILLISECOND, amount);	
			}
			
			return dateFormat.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
    private static final Object sLocaleLock = new Object();
    private static Locale sIs24HourLocale;
    private static boolean sIs24Hour;
    /**
     * Returns true if user preference is set to 24-hour format.
     * @param context the context to use for the content resolver
     * @return true if 24 hour time format is selected, false otherwise.
     */
    public static boolean is24HourFormat(Context context) {
        String value = Settings.System.getString(context.getContentResolver(),
                Settings.System.TIME_12_24);

        if (value == null) {
            Locale locale = context.getResources().getConfiguration().locale;

            synchronized (sLocaleLock) {
                if (sIs24HourLocale != null && sIs24HourLocale.equals(locale)) {
                    return sIs24Hour;
                }
            }

            DateFormat natural =
                DateFormat.getTimeInstance(DateFormat.LONG, locale);

            if (natural instanceof SimpleDateFormat) {
                SimpleDateFormat sdf = (SimpleDateFormat) natural;
                String pattern = sdf.toPattern();

                if (pattern.indexOf('H') >= 0) {
                    value = "24";
                } else {
                    value = "12";
                }
            } else {
                value = "12";
            }

            synchronized (sLocaleLock) {
                sIs24HourLocale = locale;
                sIs24Hour = value.equals("24");
            }

            return sIs24Hour;
        }

        return value.equals("24");
    }
	
    /**
  	 * Convert format history.
  	 *
  	 * @param eventTime the event time ISO 8601 format
  	 * @param currFormat the curr format
  	 * @return the string
  	 */
  	public static String convertJapanTimeToLocal(String eventTime, String currFormat, String newFormat) {
  		if (StringUtils.isEmptyOrNull(eventTime)) return "";
  		String result = "";
  		TimeZone tz = TimeZone.getTimeZone("UTC");
  		// create a date object for testing
  		DateFormat fromFormat = new SimpleDateFormat(currFormat/*"yyyy-MM-dd'T'HH:mm:ssZ"*/, Locale.JAPAN);
  		fromFormat.setTimeZone(tz);
  		try {
  			Date date = fromFormat.parse(eventTime);
  			Calendar cl = Calendar.getInstance();
  		    //System.out.println("current: "+cl.getTime());
  		    TimeZone z = cl.getTimeZone();
  			DateFormat toFormat = new SimpleDateFormat(newFormat/*"yyyy-MM-dd HH:mm:ss"*/, Locale.getDefault());
  			toFormat.setTimeZone(z);
  			toFormat.setLenient(false);
  			result = toFormat.format(date);

  		} catch (ParseException e) {
  			e.printStackTrace();
  		}
  	  return result;
    }
  	
    /**
  	 * Convert format history.
  	 *
  	 * @param unixSeconds the long seconds unix
  	 * @param currFormat the String format
  	 * @param newFormat the String format
  	 * @return the string
  	 */
  	public static String convertJapanTimestampToLocal(long unixSeconds, String currFormat, String newFormat) {
  		if (unixSeconds < 1) return "";
  		String result = "";
  		try {
  			Date date = new Date(unixSeconds * 1000L); // *1000 is to convert seconds to milliseconds
  		    SimpleDateFormat sdf = new SimpleDateFormat(currFormat/*"yyyy-MM-dd HH:mm:ss"*/); // the format of your date
  		    sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo")); // give a timezone reference for formating (see comment at the bottom
  		    String formattedDate = sdf.format(date);
  		    //System.out.println("Time source=" + formattedDate);
  		    
  			Calendar cl = Calendar.getInstance();
  		    TimeZone z = cl.getTimeZone();
  			DateFormat toFormat = new SimpleDateFormat(newFormat/*"yyyy-MM-dd HH:mm:ss"*/, Locale.getDefault());
  			toFormat.setTimeZone(z);
  			toFormat.setLenient(false);
  			result = toFormat.format(date);
  			//System.out.println("Time destination=" + result);
  			//-----------------------------
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	  return result;
    }
  	
    /**
  	 * Convert format history.
  	 *
  	 * @param unixSeconds the long seconds unix
  	 * @param currFormat the String format
  	 * @param newFormat the String format
  	 * @return the string
  	 */
  	public static String convertJapanTimestampToString(long unixSeconds, String currFormat, String newFormat) {
  		if (unixSeconds < 1) return "";
  		String result = "";
  		try {
  			Date date = new Date(unixSeconds * 1000L); // *1000 is to convert seconds to milliseconds
  		    SimpleDateFormat sdf = new SimpleDateFormat(currFormat/*"yyyy-MM-dd HH:mm:ss"*/); // the format of your date
  		    sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo")); // give a timezone reference for formating (see comment at the bottom
  		    result = sdf.format(date);
  		    System.out.println("Time source=" + result);
  			//-----------------------------
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	  return result;
    }
  	
    /**
     * Convert unix milliseconds to String
     * @param unixMilliseconds
     * @param outFormat
     * @param timeZone
     * @param locale
     * @return
     */
  	public static String convertUnixMillisecondsToString(long unixMilliseconds, String outFormat, TimeZone timeZone, Locale locale) {
  		if (unixMilliseconds < 1) return "";
  		String result = "";
  		try {
  			Date date = new Date(unixMilliseconds);
  		    SimpleDateFormat sdf = new SimpleDateFormat(outFormat, locale);
  		    sdf.setTimeZone(timeZone);
  		    result = sdf.format(date);
  		    System.out.println("Time source=" + result);
  			//-----------------------------
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	  return result;
    }
  	
	/**
	 * Get time milliseconds from String Time input.
	 *
	 * @param timeString the first time
	 * @param outputFormat the time string output format
	 * @param timeZone the TimeZone input
	 * @param locale the Locale input
	 * @return milliseconds
	 */
	public static long getTimeLong(String timeString, String outputFormat, TimeZone timeZone, Locale locale) {
		try {
			// create a date object for testing
			DateFormat dateFormat = new SimpleDateFormat(outputFormat, locale);
			dateFormat.setTimeZone(timeZone);
			
			Calendar calOfTime = Calendar.getInstance();
			calOfTime.setTime(dateFormat.parse(timeString));
			//System.out.println("getTimeInMillis=" + calOfTime.getTimeInMillis());
			return calOfTime.getTimeInMillis();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Get time seconds from String Time input.
	 *
	 * @param timeString the first time
	 * @param outputFormat the time string output format
	 * @param timeZone the TimeZone input
	 * @param locale the Locale input
	 * @return seconds
	 */
	public static long getTimeLongSeconds(String timeString, String outputFormat, TimeZone timeZone, Locale locale) {
		try {
			// create a date object for testing
			DateFormat dateFormat = new SimpleDateFormat(outputFormat, locale);
			dateFormat.setTimeZone(timeZone);
			
			Calendar calOfTime = Calendar.getInstance();
			calOfTime.setTime(dateFormat.parse(timeString));
			//System.out.println("getTimeInMillis=" + calOfTime.getTimeInMillis());
			return calOfTime.getTimeInMillis()/1000;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Get time milliseconds from String today.
	 * @param outFormat
	 * @param timeZone
	 * @param locale
	 * @return
	 */
	public static long getTodayTimeLong(String outFormat, TimeZone timeZone, Locale locale/* Locale.JAPAN */) {
		try {
			// TimeZone.getTimeZone("Asia/Tokyo");//TimeZone.getTimeZone("Japan")
			DateFormat dateFormat = new SimpleDateFormat(outFormat, locale);
			dateFormat.setTimeZone(timeZone);
			Calendar cal = Calendar.getInstance();
			return cal.getTimeInMillis();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
  	
	/**
	 * Get time seconds from String today.
	 * @param outFormat
	 * @param timeZone
	 * @param locale
	 * @return seconds
	 */
	public static long getTodayTimeLongSeconds(String outFormat, TimeZone timeZone, Locale locale/* Locale.JAPAN */) {
		try {
			// TimeZone.getTimeZone("Asia/Tokyo");//TimeZone.getTimeZone("Japan")
			DateFormat dateFormat = new SimpleDateFormat(outFormat, locale);
			dateFormat.setTimeZone(timeZone);
			Calendar cal = Calendar.getInstance();
			return cal.getTimeInMillis()/1000;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
	String todayTime = getTodayDateString("yyyy-MM-dd HH:mm:ss");
	String firstTime = "2014-10-20 16:54:00";
	String secondTime = "2014-10-19 16:54:00";
	//System.out.println(todayTime);
	/**
	 * getDifferenceTime=60000 milliseconds --> Difference Time = 1 Minute
	 * getDifferenceTime=3600000 milliseconds --> Difference Time = 1 Hour
	 * getDifferenceTime=86400000 milliseconds --> Difference Time = 1 Day
	 */
	//System.out.println("getDifferenceTime=" + getDifferenceTime(firstTime, secondTime));
	//System.out.println("===========================================================================");	
	
    String birthday = "1997/08/30";
	//System.out.println("enoughRegister(" + birthday + ")=" + enoughRegister(birthday, "yyyy/MM/dd", 17));
	//System.out.println("enoughFullRegister(" + birthday + ")=" + enoughFullRegister(birthday, "yyyy/MM/dd", 17));

	//System.out.println(DateUtils.getMonthName(1));
    //System.out.println(DateUtils.getMonthName(1, new Locale("it")));
    String jpFormatDate = DateUtils.getMonthName(1, new Locale("ja")); 
    //System.out.println(jpFormatDate); //
    
    //System.out.println(DateUtils.getDayName(java.util.Calendar.SUNDAY, Locale.getDefault()));
    
    String jpFormatDay = DateUtils.getDayName(Calendar.SUNDAY, new Locale("ja"));
    //System.out.println(jpFormatDay);
    //System.out.println("===============================");
    ////System.out.println(convertFormatHistory("2014-08-11T15:32:41+0900", "-"));//2014-07-28T12:00:17+0900
    ////System.out.println("========================================");
    //showBoth("2014-08-11T15:32:41+0900", Locale.getDefault());
    ////System.out.println("==================================");
    //convertFormat("2014-08-11T15:32:41+0900");
    //Monday, August 11, 2014 = dddd, MMMM dd, yyyy
    //System.out.println("convert2JapanFormat=" + convert2JapanFormat("2014-08-11"));
    //System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    //System.out.println("-----------------------------------------------------------");
    //compareDate(); compareCal();
    compareDate("2015-02-25T10:47:15+09:00", "2015-02-25T10:49:21+09:00", "yyyy-MM-dd'T'HH:mm:ssXXX");
    
    compareDate("2015-02-25T10:47:15+0900", "2015-02-25T10:49:21+0900", "yyyy-MM-dd'T'HH:mm:ssZ");
    
    //System.out.println("-----------------------------------------------------------");
    //System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    
    //System.out.println("convertFormatByLocale=" + convertFormatByLocale("2014-08-11T15:32:41+0900", "yyyy-MM-dd'T'HH:mm:ssZ"));
    //System.out.println("-----------------------------------------------------------");
    //System.out.println("Today=" + getTodayDateString("yyyy-MM-dd"));
    //System.out.println("Yesterday=" + getYesterdayDateString());
    //System.out.println("=============================================");
    
    String eventTime = "2014-08-10T13:29:21+09:00";
    //System.out.println(eventTime.substring(0, eventTime.indexOf("T")));
    //System.out.println("========================================================");
    //0000-00-00 00:00:00
    /*Letter	Date or Time Component	Presentation	Examples
    G	Era designator	Text	AD
    y	Year	Year	1996; 96
    Y	Week year	Year	2009; 09
    M	Month in year	Month	July; Jul; 07
    w	Week in year	Number	27
    W	Week in month	Number	2
    D	Day in year	Number	189
    d	Day in month	Number	10
    F	Day of week in month	Number	2
    E	Day name in week	Text	Tuesday; Tue
    u	Day number of week (1 = Monday, ..., 7 = Sunday)	Number	1
    a	Am/pm marker	Text	PM
    H	Hour in day (0-23)	Number	0
    k	Hour in day (1-24)	Number	24
    K	Hour in am/pm (0-11)	Number	0
    h	Hour in am/pm (1-12)	Number	12
    m	Minute in hour	Number	30
    s	Second in minute	Number	55
    S	Millisecond	Number	978
    z	Time zone	General time zone	Pacific Standard Time; PST; GMT-08:00
    Z	Time zone	RFC 822 time zone	-0800
    X	Time zone	ISO 8601 time zone	-08; -0800; -08:00*/
    
    /*"yyyy.MM.dd G 'at' HH:mm:ss z"	2001.07.04 AD at 12:08:56 PDT
    "EEE, MMM d, ''yy"	Wed, Jul 4, '01
    "h:mm a"	12:08 PM
    "hh 'o''clock' a, zzzz"	12 o'clock PM, Pacific Daylight Time
    "K:mm a, z"	0:08 PM, PDT
    "yyyyy.MMMMM.dd GGG hh:mm aaa"	02001.July.04 AD 12:08 PM
    "EEE, d MMM yyyy HH:mm:ss Z"	Wed, 4 Jul 2001 12:08:56 -0700
    "yyMMddHHmmssZ"	010704120856-0700
    "yyyy-MM-dd'T'HH:mm:ss.SSSZ"	2001-07-04T12:08:56.235-0700
    "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"	2001-07-04T12:08:56.235-07:00
    "YYYY-'W'ww-u"	2001-W27-3*/
    
    //http://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
    //System.out.println("Today(yyyy-MM-dd'T'HH:mm:ssZ)=" + getTodayDateString("yyyy-MM-dd'T'HH:mm:ssZ"));
    //Result: Today(yyyy-MM-dd'T'HH:mm:ssZ)=2015-02-13T10:11:12+0700
    //System.out.println("Today(yyyy-MM-dd'T'HH:mm:ssXXX)=" + getTodayDateString("yyyy-MM-dd'T'HH:mm:ssXXX"));
    //Result: Today(yyyy-MM-dd'T'HH:mm:ss.XXX)=2015-02-13T10:11:12+07:00
    //System.out.println("Today(yyyy-MM-dd'T'HH:mm:ss.SSSXXX)=" + getTodayDateString("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
    //Result: Today(yyyy-MM-dd'T'HH:mm:ss.SSSXXX)=2015-02-13T10:11:12.799+07:00
    
    //System.out.println("convert2JapanFormat=" + convert2JapanFormat(getTodayDateString("yyyy-MM-dd'T'HH:mm:ssXXX")));
    //System.out.println(convert2JapanFormat("2015-02-13T10:11:12+07:00", "yyyy-MM-dd'T'HH:mm:ssXXX"));
    
    //System.out.println(getTodayDateString("yyyy-MM-dd'T'HH:mm:ssZ", TimeZone.getTimeZone("Japan"), Locale.JAPAN));
    //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    String sDateOne = "2015-03-18 19:15:56";//"0000-00-00 00:00:00";
    String sDateTwo = "2015-03-19 10:47:46";
    String dateFormat = "yyyy-MM-dd HH:mm:ss";
    //System.out.println("sDateOne.compareToIgnoreCase(sDateTwo)=" + sDateOne.compareToIgnoreCase(sDateTwo));
    
    //System.out.println(compareDate(sDateOne, sDateTwo, dateFormat));
    //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    //System.out.println("===FUCK=" + convertJapanTimeToLocal("2014-08-11T15:32:41+0900", "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd HH:mm:ss"));
    //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    //System.out.println("======================getTimeLong===================");
    //System.out.println(getTimeLong("2015-05-28T11:48:37+0900", "yyyy-MM-dd'T'HH:mm:ssZ", TimeZone.getTimeZone("Japan"), Locale.JAPAN));
    //System.out.println(getTodayTimeLong("yyyy-MM-dd'T'HH:mm:ssZ", TimeZone.getTimeZone("Japan"), Locale.JAPAN));
    //System.out.println("======================getTimeLong===================");
    //System.out.println(getTimeLong("2015-05-28T11:48:37.180+0900", "yyyy-MM-dd'T'HH:mm:ss.SSSZ", TimeZone.getTimeZone("Japan"), Locale.JAPAN));
    //System.out.println(getTodayTimeLong("yyyy-MM-dd'T'HH:mm:ss.SSSZ", TimeZone.getTimeZone("Japan"), Locale.JAPAN));
    

    System.out.println("======================getTimeLong===================");
    long aLastFreeTime = getTimeLong("2015-07-16T10:33:27+09:00", "yyyy-MM-dd'T'HH:mm:ssZ", TimeZone.getTimeZone("Japan"), Locale.JAPAN) + 432000000;
    long todayLong = getTodayTimeLong("yyyy-MM-dd'T'HH:mm:ss.SSSZ", TimeZone.getTimeZone("Japan"), Locale.JAPAN);
    System.out.println("lastFreeTime=" + aLastFreeTime);
    System.out.println("todayLong=" + todayLong);
    System.out.println(aLastFreeTime - todayLong);
    System.out.println("convertMillisToTimeString=" + TimeUtils.convertMillisToTimeString(aLastFreeTime - todayLong));
    
    
  }
}