package com.ilbluesky.common.utils.date;

import com.ilbluesky.common.utils.test.Asserts;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Orca Zhang
 * date 12/10/2024
 */
public class DateUtils {

    /**
     * Common used format for {@link java.util.Date}
     */
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Common used format for {@link java.time.LocalDateTime}
     */
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Set default hour and minute to 0 if not present.
     * @param cal source
     * @param hourOfDay 0-23, default 0.
     * @param minuteOfHour 0-59, default 0.
     */
    protected static void setHourMinute(Calendar cal, Integer hourOfDay, Integer minuteOfHour) {
        cal.set(Calendar.HOUR_OF_DAY, hourOfDay == null ? 0 : hourOfDay);
        cal.set(Calendar.MINUTE, minuteOfHour == null ? 0 : minuteOfHour);
    }

    /**
     * Check if the date parameter is illegal.
     * @param cal Calender context.
     * @param start start date.
     * @param end end date.
     */
    protected static void checkDate(Calendar cal, Date start, Date end) {
        Asserts.notNull(start, String.format("Start date can not be null."));

        Asserts.beTrue(start.getTime() < end.getTime(), String.format("Start day[%s] must less than end day[%s].",
                start, end));

    }

    /**
     * Get the start time of a day. 00:00:00
     * @param source Source date
     * @return Same day as source but with 00:00:00
     */
    public static Date getDate(Date source) {
        if (source == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(source);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * Simply add one day to source date.
     * @param source Source date.
     * @return Source date + 1 day.
     */
    public static Date addOneDay(Date source) {
        if (source == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(source);
        c.add(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }
}
