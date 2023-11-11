package com.neusoft.elmboot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getTodayString() {
        return simpleDateFormat.format(new Date());
    }

    public static Date getTodayDate() {
        return new Date();
    }

    public static Date getDateByString(String date) {
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
