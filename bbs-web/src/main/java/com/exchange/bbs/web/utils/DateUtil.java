package com.exchange.bbs.web.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期转换工具类
 *
 * @author lx
 */
public class DateUtil {
    public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat yyyy_MM_ddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
    public static final Object lock = new Object();

    public static String formateDateyyyyMMdd(Date date) {
        synchronized (lock) {
            return yyyyMMdd.format(date);
        }
    }

    public static String formateDateyyyy_MM_ddHHmmss(Date date) {
        synchronized (lock) {
            return yyyy_MM_ddHHmmss.format(date);
        }
    }

    public static String formateDateyyyy_MM_dd(Date date) {
        synchronized (lock) {
            return yyyy_MM_dd.format(date);
        }
    }

    public static String formateDateyyyyMMddHHmmss(Date date) {
        synchronized (lock) {
            return yyyyMMddHHmmss.format(date);
        }
    }

    /**
     * @param dateStr 时间串
     * @return 转化结果，无法转化则new date
     */
    public static Date parseDate(String dateStr) {
        synchronized (lock) {
            try {
                return yyyy_MM_ddHHmmss.parse(dateStr);
            } catch (Exception e) {
                try {
                    return yyyy_MM_dd.parse(dateStr);
                } catch (Exception e2) {
                    try {
                        return yyyyMMdd.parse(dateStr);
                    } catch (Exception e3) {
                        PrintUtil.print("can't parse to Date :" + dateStr);
                        return new Date();
                    }
                }
            }
        }
    }

    /**
     * 获取下一天时间串
     *
     * @param dateStr
     * @return 下一天的时间串
     */
    public static String getNextDayString(String dateStr) {
        Date date = null;
        synchronized (lock) {
            try {
                date = yyyy_MM_ddHHmmss.parse(dateStr);
                date.setTime(date.getTime() + 24 * 60 * 60 * 1000);
                return formateDateyyyy_MM_ddHHmmss(date);
            } catch (Exception e) {
                try {
                    date = yyyy_MM_dd.parse(dateStr);
                    date.setTime(date.getTime() + 24 * 60 * 60 * 1000);
                    return formateDateyyyy_MM_dd(date);
                } catch (Exception e2) {
                    try {
                        date = yyyyMMdd.parse(dateStr);
                        date.setTime(date.getTime() + 24 * 60 * 60 * 1000);
                        return formateDateyyyyMMdd(date);
                    } catch (Exception e3) {
                        PrintUtil.print("cant getNextDayString :" + dateStr);
                        return "";
                    }
                }
            }
        }
    }

    /**
     * 获取随机日期
     *
     * @param beginDate 起始日期，格式为：yyyyMMdd
     * @param endDate   结束日期，格式为：yyyyMMdd
     * @return
     */

    public static Date randomDate(String beginDate, String endDate) {
        try {
            Date start = parseDate(beginDate);
            Date end = parseDate(endDate);
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间 串
     * @param bdate  较大的时间 串
     * @return 相差天数
     */
    public static int daysBetween(String smdate, String bdate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(parseDate(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * @param mss 要转换的毫秒数
     * @return 该毫秒数转换为 * 分 * 秒 * 毫秒 后的格式
     */
    public static String formatDuring(long mss) {
        long minutes = (mss) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        long ms = (mss % (1000));
        if (minutes != 0) {
            return minutes + "分钟" + (seconds != 0 ? seconds + "秒" + (ms != 0 ? ms + "毫秒" : "") : "");
        }
        if (seconds != 0) {
            return seconds + "秒" + (ms != 0 ? ms + "毫秒" : "");
        }
        return ms + "毫秒";
    }

    public static Date beginOfToday() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static Date beginOfWeek() {
        Calendar c = Calendar.getInstance();
        Date date = new Date();
        date.setTime(date.getTime() - 3600000 * 24);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static Date beginOfMonth() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

}
