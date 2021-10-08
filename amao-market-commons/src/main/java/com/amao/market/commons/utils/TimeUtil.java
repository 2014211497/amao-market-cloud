package com.amao.market.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 时间工具类
 *
 * @author LinYuchang
 * @since 1.0.0
 */
public class TimeUtil {

    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取秒级时间戳
     *
     * @return 秒级时间戳
     */
    public static long timestamp() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 获取毫秒级时间戳
     *
     * @return 毫秒级时间戳
     */
    public static long milliTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * 将秒级时间戳格式化为日期字符串
     *
     * @param timestamp 秒级时间戳
     * @return 日期字符串
     */
    public static String format(long timestamp) {
        return formatMilli(timestamp * 1000);
    }

    public static String formatNow(String pattern) {
        return formatMilli(System.currentTimeMillis(), pattern);
    }

    /**
     * 将毫秒级时间戳格式化为日期字符串
     *
     * @param milliTimestamp 毫秒级时间戳
     * @return 日期字符串
     */
    public static String formatMilli(long milliTimestamp) {
        return DEFAULT_DATE_FORMAT.format(new Date(milliTimestamp));
    }

    /**
     * 将秒级时间戳格式化为日期字符串
     *
     * @param timestamp 秒级时间戳
     * @param pattern   日期格式，例如 yyyy-MM-dd HH:mm:ss
     * @return 日期时间戳
     */
    public static String format(long timestamp, String pattern) {
        return formatMilli(timestamp * 1000, pattern);
    }

    /**
     * 将秒级时间戳格式化为日期字符串
     *
     * @param milliTimestamp 毫秒级时间戳
     * @param pattern        日期格式，例如 yyyy-MM-dd HH:mm:ss
     * @return 日期时间戳
     */
    public static String formatMilli(long milliTimestamp, String pattern) {
        return new SimpleDateFormat(pattern).format(new Date(milliTimestamp));
    }

    /**
     * 根据毫秒级时间戳生成 Calendar 对象
     *
     * @param millTimestamp 毫秒级时间戳
     * @return Calendar 对象
     */
    public static Calendar calendar(long millTimestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(millTimestamp));
        return calendar;
    }
}
