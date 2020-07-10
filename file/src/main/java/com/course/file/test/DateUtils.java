package com.course.file.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author jiange
 * @date 2020/7/9 17:58
 */
public class DateUtils {

    public static final String DATEPATTERN_YYYYMM = "yyyyMM";
    /**
     * 获取指定月份的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month, String format) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
        return new SimpleDateFormat(format).format(cal.getTime());
    }

    /**
     * 获取当前日期的前一天
     *
     * @param time
     * @return
     */
    public static String format3(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.DATE, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String str = sdf.format(calendar.getTime());
        return str;
    }

    public static Integer queryCurrentMonth(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATEPATTERN_YYYYMM);
        Integer month = Integer.parseInt(format.format(date));
        return month;
    }
}
