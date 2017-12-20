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
    
    /**
     * 当前周是本月第几周
     *
     * @param date
     * @return
     */
    public static int weekOfMonth(LocalDate date) {
        int day = date.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        int dayOfWeek = date.getDayOfWeek().getValue();
        
        if (day <= dayOfWeek) {
            return date.get(ChronoField.ALIGNED_WEEK_OF_MONTH);
        } else {
            return date.get(ChronoField.ALIGNED_WEEK_OF_MONTH) + 1;
        }
    }
    
    /**
     * 当前周是本年第几周
     *
     * @param date
     * @return
     */
    public static int weekOfYear(LocalDate date) {
        int day = date.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR);
        int dayOfWeek = date.getDayOfWeek().getValue();
        
        if (day <= dayOfWeek) {
            return date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        } else {
            return date.get(ChronoField.ALIGNED_WEEK_OF_YEAR) + 1;
        }
    }
    
    /**
     * 当前周是本月第-几周
     *
     * @param date
     * @return
     */
    public static int weekOfMonthLast(LocalDate date) {
        int weekOfMonth = weekOfMonth(date);
        int weekOfMonthLast = weekOfMonth(date.withDayOfMonth(1).plusMonths(1).minusDays(1));
        return weekOfMonth - weekOfMonthLast - 1;
    }
    
    /**
     * 当前周是本年第-几周
     *
     * @param date
     * @return
     */
    public static int weekOfYearLast(LocalDate date) {
        int weekOfYear = weekOfYear(date);
        int weekOfYearLast = weekOfYear(date.withDayOfMonth(1).withMonth(1).plusYears(1).minusDays(1));
        return weekOfYear - weekOfYearLast - 1;
    }
    
    /**
     * 当前日期是本月第-几个周X
     *
     * @param date
     * @return
     */
    public static int weekdayOfMonthLast(LocalDate date) {
        int dayOfWeek = date.getDayOfWeek().getValue();
        int alignedWeekOfMonth = date.get(ChronoField.ALIGNED_WEEK_OF_MONTH);
        
        LocalDate first = date.withDayOfMonth(1);
        LocalDate last = first.plusMonths(1).minusDays(1);
        
        int firstDayOfWeek = first.getDayOfWeek().getValue();
        int lastDayOfWeek = last.getDayOfWeek().getValue();
        int lastAlignedWeekOfMonth = last.get(ChronoField.ALIGNED_WEEK_OF_MONTH);
    
        return countDay(dayOfWeek, alignedWeekOfMonth, firstDayOfWeek, lastDayOfWeek, lastAlignedWeekOfMonth);
    }
    
    /**
     * 当前日期是本年第-几个周X
     *
     * @param date
     * @return
     */
    public static int weekdayOfYearLast(LocalDate date) {
        int dayOfWeek = date.getDayOfWeek().getValue();
        int alignedWeekOfYear = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        
        LocalDate first = date.withDayOfMonth(1).withMonth(1);
        LocalDate last = first.plusYears(1).minusDays(1);
        
        int firstDayOfWeek = first.getDayOfWeek().getValue();
        int lastDayOfWeek = last.getDayOfWeek().getValue();
        int lastAlignedWeekOfYear = last.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        
        return countDay(dayOfWeek, alignedWeekOfYear, firstDayOfWeek, lastDayOfWeek, lastAlignedWeekOfYear);
    }
    
    private static int countDay(int dayOfWeek, int alignedWeekOfTarget, int firstDayOfWeek,
            int lastDayOfWeek, int lastAlignedWeekOfTarget) {
        if (firstDayOfWeek <= lastDayOfWeek) {
            if (dayOfWeek >= firstDayOfWeek && dayOfWeek <= lastDayOfWeek) {
                return alignedWeekOfTarget - lastAlignedWeekOfTarget - 1;
            } else {
                return alignedWeekOfTarget - lastAlignedWeekOfTarget;
            }
        } else {
            if (dayOfWeek >= firstDayOfWeek || dayOfWeek <= lastDayOfWeek) {
                return alignedWeekOfTarget - lastAlignedWeekOfTarget - 1;
            } else {
                return alignedWeekOfTarget - lastAlignedWeekOfTarget;
            }
        }
    }
    
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now().withDayOfMonth(1);
        
        for (int i = 1; i <= localDate.getMonth().maxLength(); i++) {
            LocalDate date = localDate.withDayOfMonth(i);
            System.out.println(i + "\t:\t" + weekdayOfYearLast(date));
        }
    }
    
    public static LocalDate date2Local(Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        ZoneId zoneId = ZoneId.systemDefault();
        
        return LocalDateTime.ofInstant(instant, zoneId).toLocalDate();
    }
}
