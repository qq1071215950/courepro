package com.course.file.test;



import java.util.Date;

/**
 * @author jiange
 * @date 2020/7/9 17:56
 */
public class TestDemo {
    public static void main(String[] args) {
        String month = "202007";
        String date = DateUtils.format3(new Date());
        if (!month.equals(String.valueOf(DateUtils.queryCurrentMonth(new Date())))) {
            date = DateUtils.getLastDayOfMonth(Integer.parseInt(month.substring(0, 4)), Integer.parseInt(month.substring(4, 6)), "yyyyMMdd");
        }
        System.out.println("时间："+date);
    }
}
