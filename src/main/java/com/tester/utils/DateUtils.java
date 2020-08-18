package com.tester.utils;


import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 日期工具类
 *
 * @author sirk
 */
@Slf4j
public class DateUtils {

    public static final String PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_DAY = "yyyy-MM-dd";
    public static final String PATTERN_STRING_DAY = "yyyyMMdd";
    public static final String PATTERN_STRING_TIME = "HHmmss";
    public static final String PATTERN_STRING_DEFAULT = "yyMMddHHmmss";
    public static final String PATTERN_DEFAULT_DATE = "yyyyMMddHHmmss";
    public static final String PATTERN_DEFAULT_RULE = "yyyy-MM-dd_HH:mm:ss";
    public static final String DATE_FMT_HOUR_MIN = "HH:mm";

    /**
     * 获得可以正常显示的时间
     *
     * @param time
     * @return
     */
    public static String normalizeTime(long time) {
        SimpleDateFormat sm = new SimpleDateFormat(PATTERN_DEFAULT);
        Date date = new Date(time);
        return sm.format(date);
    }

    public static String normalizeTime(Timestamp timestamp) {
        if (timestamp == null) {
            return "";
        }
        Date date = new Date(timestamp.getTime());
        SimpleDateFormat sm = new SimpleDateFormat(PATTERN_DEFAULT);
        return sm.format(date);
    }

    /**
     * Date转换String
     *
     * @param date
     * @return
     */
    public static String parseDate(Date date, String format) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sm = new SimpleDateFormat(format);
        return sm.format(date);
    }

    /**
     * Date转换String
     *
     * @param date
     * @return
     */
    public static String parseDate(Date date) {
        return parseDate(date, PATTERN_DEFAULT);
    }

    /**
     * Date转换String
     *
     * @param date
     * @return
     */
//    public static String parseDate(Date date, String format) {
//        if (date == null) {
//            return "";
//        }
//        SimpleDateFormat sm = new SimpleDateFormat(format);
//        return sm.format(date);
//    }

    /**
     * 字符串转为Date
     *
     * @param date
     * @return
     */
    public static Date parseDate(String date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sm = new SimpleDateFormat(format);
        try {
            return sm.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 取一天最大的时间
     *
     * @param date
     * @return
     */
    public static Date ceiling(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sm = new SimpleDateFormat(PATTERN_DAY);
        String day = sm.format(date) + " 23:59:59";
        return parseDate(day, PATTERN_DEFAULT);
    }

    /**
     * 取一天最小的时间
     *
     * @param date
     * @return
     */
    public static Date floor(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sm = new SimpleDateFormat(PATTERN_DAY);
        String day = sm.format(date) + " 00:00:00";
        return parseDate(day, PATTERN_DEFAULT);
    }


    /**
     * 对比
     *
     * @return
     */
    public static int compareTo(Date date1, Date date2) {
        return date1.getTime() >= date2.getTime() ? 1 : 0;
    }


    /**
     * Date类型转换Timestamp
     *
     * @param date
     * @return
     */
    public static Timestamp toTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(date.getTime());
    }


    /**
     * 日期增加m月
     *
     * @param sDate
     * @param m
     * @return
     */
    public static Date addMonths(Date sDate, int m) {
        if (sDate == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(sDate);
        cal.add(Calendar.MONTH, m);
        return cal.getTime();
    }


    /**
     * 日期增加n天
     *
     * @param sDate
     * @param n
     * @return
     */
    public static Date addDays(Date sDate, int n) {
        if (sDate == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(sDate);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }


    /**
     * 强制设置天
     *
     * @param sDate
     * @param days
     * @return
     */
    public static Date resetDays(Date sDate, int days) {
        if (sDate == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(sDate);
        cal.set(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }


    /**
     * 获取日
     *
     * @param date
     * @return
     */
    public static int parseDays(Date date) {
        SimpleDateFormat sm = new SimpleDateFormat("dd");
        String days = sm.format(date);
        return Integer.valueOf(days);
    }


    /**
     * 日期增加n天
     *
     * @param sDate
     * @param n
     * @return
     */
    public static Date addHours(Date sDate, int n) {
        if (sDate == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(sDate);
        cal.add(Calendar.HOUR, n);
        return cal.getTime();
    }


    /**
     * 日期减少n天
     *
     * @param sDate
     * @param n
     * @return
     */
    public static Date reduceDays(Date sDate, int n) {
        if (sDate == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(sDate);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - n);
        return cal.getTime();
    }

    /**
     * 日期减少一个月
     *
     * @param sDate
     * @param n
     * @return
     */
    public static Date reduceMonths(Date sDate, int n) {
        if (sDate == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(sDate);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - n);
        return cal.getTime();
    }


    /**
     * 日期增加n分钟
     *
     * @param sDate
     * @param minutes
     * @return
     */
    public static Date addMinutes(Date sDate, int minutes) {
        if (sDate == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(sDate);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    /**
     * 求两日期之间相差几天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDays(String date1, String date2) {
        if (date1 == null || date1.equals(""))
            return 0;
        if (date2 == null || date2.equals(""))
            return 0;
        SimpleDateFormat sf = new SimpleDateFormat(PATTERN_DAY);
        Date date = null;
        Date mydate = null;
        try {
            date = sf.parse(date1);
            mydate = sf.parse(date2);
        } catch (Exception e) {
        }
        long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        return Math.abs(day);
    }

    public static long getDiffDays(Date date1, Date date2) {
        if (date1 == null) {
            throw new RuntimeException("传入日期为空");
        }
        if (date2 == null) {
            throw new RuntimeException("传入日期为空");
        }
        return (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000);
    }


    public static int getMonth(Date date) {
        if (date == null || date.equals(""))
            return 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 求两日期之间相差几天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDays(Date date1, Date date2) {
        if (date1 == null || date1.equals(""))
            return 0;
        if (date2 == null || date2.equals(""))
            return 0;
        long day = (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000);
        return Math.abs(day);
    }

    /**
     * 获取天数
     *
     * @param date
     * @return
     */
    public static long toDays(Date date) {
        if (date == null)
            return 0;
        long day = (date.getTime()) / (24 * 60 * 60 * 1000);
        return Math.abs(day);
    }

    /**
     * 当前时间是否在开始时间和结束时间之间
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean betweenDate(Date startDate, Date endDate) {
        Date todayDate = new Date();
        if (startDate.getTime() <= todayDate.getTime() && todayDate.getTime() <= endDate.getTime()) {
            return true;
        } else {
            return false;
        }
    }


    // NOTE: 精确对比到  日
    public static boolean betweenDate(Date todayDate, Date startDate, Date endDate) {
        if (toDays(startDate) <= toDays(todayDate) && toDays(todayDate) <= toDays(endDate)) {
            return true;
        } else {
            return false;
        }


//        if (startDate.getTime() <= todayDate.getTime() && todayDate.getTime() <= endDate.getTime()) {
//            return true;
//        } else {
//            return false;
//        }
    }

    // NOTE: 精确对比到  日
    public static boolean betweenDates(Date todayDate, Date startDate, Date endDate) {
        if (toDays(startDate) < toDays(todayDate) && toDays(todayDate) <= toDays(endDate)) {
            return true;
        } else {
            return false;
        }
    }



    /**
     * 判断是否是同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        SimpleDateFormat sf = new SimpleDateFormat(PATTERN_DAY);
        String day1 = sf.format(date1);
        String day2 = sf.format(date2);
        return day1.equals(day2);
    }

    public void isBelong() {

        SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
        Date now = null;
        Date beginTime = null;
        Date endTime = null;
        try {
            now = df.parse(df.format(new Date()));
            beginTime = df.parse("06:00");
            endTime = df.parse("22:00");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Boolean flag = belongCalendar(now, beginTime, endTime);
        System.out.println(flag);
    }

    /**
     * @param beginHourMin
     * @param endHourMin
     * @return
     */
    public static boolean belongTime(String beginHourMin, String endHourMin, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Date now = null;
        Date beginTime = null;
        Date endTime = null;
        try {
            now = df.parse(df.format(new Date()));
            beginTime = df.parse(beginHourMin);
            endTime = df.parse(endHourMin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return belongCalendar(now, beginTime, endTime);
    }

    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        Date breakDay = new Date();
//        System.out.println("breakDay=》" + DateUtils.parseDate(breakDay, "yyyy-MM-dd"));
//        System.out.println("getMonth=》" + DateUtils.getMonth(breakDay));
//        Date nextMonth = DateUtils.addMonths(breakDay, 1);
//        System.out.println("nextMonth=》" + DateUtils.parseDate(nextMonth, "yyyy-MM-dd"));
//        breakDay = DateUtils.reduceDays(nextMonth, 2);
//        System.out.println("breakDay=》" + DateUtils.parseDate(breakDay, "yyyy-MM-dd"));
//        Date resetDays = DateUtils.resetDays(breakDay, 4);
//        System.out.println("resetDays=》" + DateUtils.parseDate(resetDays, "yyyy-MM-dd"));
//        System.out.println("resetDays=》" + DateUtils.parseDate(DateUtils.reduceMonths(resetDays, 1), "yyyy-MM-dd"));
//        System.out.println("parseDays=》" + DateUtils.parseDays(resetDays));
//
//        boolean date = betweenTime("12:10", "20:20");
//        System.out.println("date=" + date);
//
//        System.out.println("Result =>" + betweenDate("2015-10-11", "2015-10-12", "2015-10-20", PATTERN_DAY));
//
//        Date date1 = addMonths(DateUtils.parseDate("2019-02-28",PATTERN_DAY), 1);
//        System.out.println(DateUtils.parseDate(date1));
    }
}
