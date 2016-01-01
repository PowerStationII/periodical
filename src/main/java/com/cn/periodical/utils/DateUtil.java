package com.cn.periodical.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 15-12-26
 * Time: 下午2:38
 * To change this template use File | Settings | File Templates.
 */
public class DateUtil {

    /**
     * 获得当前年 2015
     * @return
     */
    public static String getYear(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String dateString = formatter.format(currentTime);
        return dateString ;
    }
    /**
     * 获得当前年月日时 2015010100
     * @return
     */
    public static String getYearMonthDayHour(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHH");
        String dateString = formatter.format(currentTime);
        return dateString ;
    }
}
