package com.usefultool.Util;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


//@Component
public class DateUtil {
	/** 日期格式，yyyy-MM-dd **/
	public final static String DATE_FORMATE_YYYY_MM_DD = "yyyy-MM-dd";
	public final static String DATE_FORMATE_DD_MM_YY = "dd-MM-yy";
	/** 日期格式，yyyy/MM/dd **/
	public final static String DATE_FORMATE_YYYY_MM_DD_ = "yyyy/MM/dd";
	/** 日期格式，yyyyMMdd **/
	public final static String DATE_FORMATE_YYYYMMDD = "yyyyMMdd";
	/** 日期格式，yyyy-MM-dd HH:mm:ss **/
	public final static String DATE_FORMATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public final static String DATE_FORMATE_YYYY_MM_DD_T_HH_MM_SS = "yyyy-MM-dd'T'HH:mm:ss";
	public final static String DATE_FORMATE_YYYY_MM_DDTHH_MM_SS = "yyyy-MM-ddTHH:mm:ss";
	/** 日期格式，yyyyMMddHHmmss **/
	public final static String DATE_FORMATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	/** 日期格式，yyyy-MM-dd HH:mm **/
	public final static String DATE_FORMATE_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

	public final static String DATE_FORMATE_yyyy_MM_dd_HH_mm_ss = "yyyy/MM/dd HH:mm:ss";
	/** 日志格式，2018年02月01日 **/
	public final static String DATE_FORMATE_CH_YYYY_M_D = "yyyy年M月d日";
	/** 日志格式，2018年02月01日 **/
	public final static String DATE_FORMATE_CH_YYYY_M_D_HH_MM_SS = "yyyy年M月d日 HH时mm分ss秒";
	/** 日志格式，01-Jan-2018 **/
	public final static String DATE_FORMATE_EN_DD_MMM_YYYY = "dd-MMM-yyyy";

	public final static String DAY_START = " 00:00:00";

	public final static String DAY_END = " 23:59:59";

	/**
	 * 获取int格式时间，精确到妙 <一句话功能简述> <功能详细描述>
	 * 
	 * @param d
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static int getDateToInt(Date d) {
		return (int) (d.getTime() / 1000);
	}

	public static String intDateToString(String intDate, String format) {
		long dateLong = Long.parseLong(intDate) * 1000;

		Date d = new Date(dateLong);

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		String rs = sdf.format(d);

		return rs;
	}

	/**
	 * 开始计算的日期 日期添加的秒数
	 * 
	 * @param startDate
	 * @param addSecondCount
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static Date addDatetime(Date startDate, int addSecondCount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.SECOND, addSecondCount);
		return calendar.getTime();
	}

	public static String addDateHour(String date, String format, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(stringToDate(date, format));
		calendar.add(Calendar.HOUR, hour);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// calendar.add(Calendar.MONTH, 1);
		String dateStr = sdf.format(calendar.getTime());
		return dateStr;
	}

	public static String addDateMonth(String date, String format, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(stringToDate(date, format));
		calendar.add(Calendar.MONTH, month);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// calendar.add(Calendar.MONTH, 1);
		String dateStr = sdf.format(calendar.getTime());
		return dateStr;
	}

	/**
	 * 字符串转日期格式
	 * 
	 * @param dateStr
	 * @param formateRule
	 * @return
	 */
	public static Date stringToDate(String dateStr, String formateRule) {
		SimpleDateFormat sdf = new SimpleDateFormat(formateRule);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (Exception e) {
			return null;
		}
		return date;
	}

	/**
	 * 比较两日期的大小，前一个日期大于后一个日期，返回0，否则返回-1
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static int compareDate(Date date1, Date date2) {
		int com = -1;
		if (date1.getTime() > date2.getTime()) {
			com = 0;
		}
		return com;
	}

	public static int compareStringDate(String DATE1, String DATE2, String format) {
		DateFormat df = new SimpleDateFormat(format);
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 取得系统日期
	 * 
	 * @return Date 系统日期(yyyy-MM-dd HH:mm:ss)
	 * 
	 */
	public static String getSysDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(new Date());
	}

	public static String getFormatDate(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(new Date());
	}

	// 获取当前的unix时间
	public static String getUnixDate(){
		return Long.toString(System.currentTimeMillis()/1000L);
	}









	public static int stringDateToInt(String strDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = dateFormat.parse(strDate);
			return (int) (date.getTime() / 1000);
		} catch (ParseException e) {
			return 0;
		}
	}

	/**
	 * 取得int系统日期
	 * 
	 * @return Date 系统日期(yyyy-MM-dd HH:mm:ss)
	 * 
	 */
	public static int getIntSysDate() {
		return (int) (new Date().getTime() / 1000);
	}

	/**
	 * 
	 * @Title: getYesterday @Description: 获取当前时间的前后interval的日期 @param
	 *         interval @return @throws
	 */
	public static String getYesterday(String format, int interval) {
		Calendar calendar = Calendar.getInstance();// 此时打印它获取的是系统当前时间
		calendar.add(Calendar.DATE, interval); // 得到前一天
		return new SimpleDateFormat(format).format(calendar.getTime());
	}

	public static Calendar stringToCalendarAddMouth(String dateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		try {
			Date date = sdf.parse(dateStr);
			calendar.setTime(date);
			calendar.add(Calendar.MONTH, 1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	}

	public static Calendar stringToCalendar(String dateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		try {
			Date date = sdf.parse(dateStr);
			calendar.setTime(date);
			// calendar.add(Calendar.MONTH, 1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	}

	public static Calendar stringToCalendarAdd(String dateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		try {
			Date date = sdf.parse(dateStr);
			calendar.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	}

//	public static String calendarToYYYYMMDD(Calendar calendar) {
//		int year = calendar.get(Calendar.YEAR);
//		int month = calendar.get(Calendar.MONTH) + 1;
//		int day = calendar.get(Calendar.DATE);
//		String dateStr = year + "-" + StringFormat.formatLeft0(month, 2) + "-" + StringFormat.formatLeft0(day, 2);
//		return dateStr;
//	}

//	public static String calendarToYYYYMMDDHHSSMM(Calendar calendar) {
//		int year = calendar.get(Calendar.YEAR);
//		int month = calendar.get(Calendar.MONTH);
//		int day = calendar.get(Calendar.DATE);
//		int hour = calendar.get(Calendar.HOUR_OF_DAY); // 时
//		int minute = calendar.get(Calendar.MINUTE); // 分
//		int second = calendar.get(Calendar.SECOND); // 秒
//		String dateStr = year + "-" + StringFormat.formatLeft0(month, 2) + "-" + StringFormat.formatLeft0(day, 2) + " "
//				+ StringFormat.formatLeft0(hour, 2) + ":" + StringFormat.formatLeft0(minute, 2) + ":"
//				+ StringFormat.formatLeft0(second, 2);
//		return dateStr;
//	}

	public static long dateDiff(String startTime, String endTime) {
		// 按照传入的格式生成一个simpledateformate对象
		SimpleDateFormat sd = new SimpleDateFormat(DATE_FORMATE_YYYY_MM_DD_HH_MM_SS);
		long nm = 1000 * 60;// 一分钟的毫秒数
		long diff;
		long min = 0l;
		try {
			// 获得两个时间的毫秒时间差异
			diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
			min = diff / nm;// 计算差多少分钟
			// 输出结果
		} catch (ParseException e) {
		}
		return min;
	}

	/**
	 * 将String型格式化,比如想要将2011-11-11格式化成2011年11月11日,就StringPattern("2011-11-11",
	 * "yyyy-MM-dd","yyyy年MM月dd日").
	 * 
	 * @param date
	 *            String 想要格式化的日期
	 * @param oldPattern
	 *            String 想要格式化的日期的现有格式
	 * @param newPattern
	 *            String 想要格式化成什么格式
	 * @return String
	 */
	public static String StringPattern(String date, String oldPattern, String newPattern) {
		if (date == null || oldPattern == null || newPattern == null)
			return "";
		SimpleDateFormat sdf1 = new SimpleDateFormat(oldPattern); // 实例化模板对象
		SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern); // 实例化模板对象
		Date d = null;
		try {
			d = sdf1.parse(date); // 将给定的字符串中的日期提取出来
		} catch (Exception e) { // 如果提供的字符串格式有错误，则进行异常处理
			e.printStackTrace(); // 打印异常信息
		}
		return sdf2.format(d);
	}

	public static String StringPattern(String date, String oldPattern, String newPattern, Locale locale) {
		if (date == null || oldPattern == null || newPattern == null)
			return "";
		SimpleDateFormat sdf1 = new SimpleDateFormat(oldPattern, locale); // 实例化模板对象
		SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern, locale); // 实例化模板对象
		Date d = null;
		try {
			d = sdf1.parse(date); // 将给定的字符串中的日期提取出来
		} catch (Exception e) { // 如果提供的字符串格式有错误，则进行异常处理
			e.printStackTrace(); // 打印异常信息
		}
		return sdf2.format(d);
	}

	public static String dateToString(String date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date d = null;
		try {
			d = dateFormat.parse(date); // 将给定的字符串中的日期提取出来
		} catch (Exception e) { // 如果提供的字符串格式有错误，则进行异常处理
			e.printStackTrace(); // 打印异常信息
		}
		return dateFormat.format(d);
	}

//	public static void main(String[] args) throws Exception {
////		System.out.println(DateUtil.getFormatDate(DateUtil.DATE_FORMATE_DD_MM_YY));
////		System.out.println(StringPattern("2018-01-02 15:44:29", DateUtil.DATE_FORMATE_YYYY_MM_DD_HH_MM_SS,
////				"MM月dd日 HH:mm aa", Locale.CHINA));
////		System.out.println(StringPattern("2018-01-02 15:44:29", DateUtil.DATE_FORMATE_YYYY_MM_DD_HH_MM_SS,
////				"dd-MMMM HH:mm aa", Locale.ENGLISH));
//
////		System.out.println(DateUtil.getFormatDate(DateUtil.DATE_FORMATE_YYYYMMDDHHMMSS));
//		System.out.println(getUnixDate());
//
//
//
//	}
}