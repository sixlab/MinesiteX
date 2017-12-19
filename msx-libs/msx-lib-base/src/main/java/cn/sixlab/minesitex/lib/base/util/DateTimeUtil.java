/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/12/19 13:36
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.lib.base.util;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;

public class DateTimeUtil {
    
    public static int weekOfMonth(LocalDate date) {
        int day = date.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        int dayOfWeek = date.getDayOfWeek().getValue();
        
        if (day <= dayOfWeek) {
            return date.get(ChronoField.ALIGNED_WEEK_OF_MONTH);
        } else {
            return date.get(ChronoField.ALIGNED_WEEK_OF_MONTH) + 1;
        }
    }
    
    public static int weekOfYear(LocalDate date) {
        int day = date.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR);
        int dayOfWeek = date.getDayOfWeek().getValue();
        
        if (day <= dayOfWeek) {
            return date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        } else {
            return date.get(ChronoField.ALIGNED_WEEK_OF_YEAR) + 1;
        }
    }
    
    public static int weekOfMonthLast(LocalDate date) {
        int weekOfMonth = weekOfMonth(date);
        int weekOfMonthLast = weekOfMonth(date.withDayOfMonth(1).plusMonths(1).minusDays(1));
        return weekOfMonth - weekOfMonthLast - 1;
    }
    
    public static int weekOfYearLast(LocalDate date) {
        int weekOfYear = weekOfYear(date);
        int weekOfYearLast = weekOfYear(date.withDayOfMonth(1).withMonth(1).plusYears(1).minusDays(1));
        return weekOfYear - weekOfYearLast - 1;
    }
    
    public static LocalDate date2Local(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
    
        return LocalDateTime.ofInstant(instant, zoneId).toLocalDate();
    }
}
