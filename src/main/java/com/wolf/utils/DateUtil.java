package com.wolf.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date obterDataDiferencaDias(int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, dias);
        return calendar.getTime();
    }
}
