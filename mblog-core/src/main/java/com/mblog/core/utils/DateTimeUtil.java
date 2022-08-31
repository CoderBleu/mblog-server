package com.mblog.core.utils;

import cn.hutool.core.date.TemporalUtil;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Lauy
 * @create 2022/8/29
 */
public class DateTimeUtil {

    /**
     * 默认使用系统当前时区
     */
    private static final ZoneId ZONE = ZoneId.systemDefault();

    /**
     * 获取目标时间的当前最小时间
     * @param time
     * @return
     */
    public static LocalDateTime getDayStartTime(LocalDateTime time) {
        return LocalDateTime.of(time.toLocalDate(), LocalTime.MIN);
    }

    /**
     * 获取此月第一天
     * @param time
     * @return
     */
    public static LocalDateTime getFirstDayOfMonth(LocalDateTime time) {
        return time.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取此月最小时间
     * @param time
     * @return
     */
    public static LocalDateTime getMinTimeOfMonth(LocalDateTime time) {
        return LocalDateTime.of(time.with(TemporalAdjusters.firstDayOfMonth()).toLocalDate(), LocalTime.MIN);
    }

    /**
     * 获取此月最后一天
     * @param time
     * @return
     */
    public static LocalDateTime getLastDayOfMonth(LocalDateTime time) {
        return time.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 获取此月最大时间
     * @param time
     * @return
     */
    public static LocalDateTime getMaxTimeOfMonth(LocalDateTime time) {
        return LocalDateTime.of(time.with(TemporalAdjusters.lastDayOfMonth()).toLocalDate(), LocalTime.MAX);
    }

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * 时间戳转LocalDateTime
     * @param time
     * @return
     */
    public static LocalDateTime parseLocalDateTime(long time) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
    }

    public static LocalDateTime parseChinaLocalDateTime(long time) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(time),  ZoneOffset.ofHours(8));
    }

    /**
     * 转时间戳
     * @param time
     * @return
     */
    public static long localDateTimeToLong(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * toLocalDate
     * @param time
     * @return
     */
    public static LocalDate toLocalDate(LocalDateTime time) {
        return time.toLocalDate();
    }


    /**
     * 获取两个时间差
     * @param startTimeInclude
     * @param endTimeExclude
     * @return
     */
    public static Duration between(LocalDateTime startTimeInclude, LocalDateTime endTimeExclude) {
        return TemporalUtil.between(startTimeInclude, endTimeExclude);
    }

    public static long between(LocalDateTime startTimeInclude, LocalDateTime endTimeExclude, ChronoUnit unit) {
        return TemporalUtil.between(startTimeInclude, endTimeExclude, unit);
    }

    public static void main(String[] args) {
        System.out.println(getMaxTimeOfMonth(LocalDateTime.now()));
        System.out.println(getFirstDayOfMonth(LocalDateTime.now()));
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(parseLocalDateTime(currentTimeMillis));
    }

}
