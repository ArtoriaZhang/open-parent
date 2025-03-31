package com.ilbluesky.common.utils.date;

import javax.annotation.Nullable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Orca Zhang
 * date 3/31/2025
 */
public class MonthUtils extends DateUtils{

    /**
     * Calculate all month between startDate and endDate.
     * @param start start date.
     * @param end end date. Nullable.
     * @param hourOfDay Hour of the day. 0-23, default 0.
     * @param minuteOfHour Minute of hour. 0-59, default 0.
     * @return Map with months.
     */
    public static Map<Integer, Date[]> getAllMonths(Date start, @Nullable Date end, Integer hourOfDay, Integer minuteOfHour) {

        Calendar cal = Calendar.getInstance();

        end = end == null ? new Date() : end;
        checkDate(cal, start, end);

        cal.setTime(start);
        setHourMinute(cal, hourOfDay, minuteOfHour);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.SECOND, 0);

        start = cal.getTime();
        Map<Integer, Date[]> result = new LinkedHashMap<>();

        calMonth(cal, start, end, result);

        return result;
    }

    /**
     * Calculate method.
     * @param cal  Calendar
     * @param start Start date.
     * @param end End date.
     * @param result Final result Map.
     */
    private static void calMonth(Calendar cal, Date start, Date end, Map<Integer, Date[]> result) {

        Integer month = cal.get(Calendar.MONTH);
        Date[] tmp = new Date[2];
        result.put(month, tmp);
        tmp[0] = start;
        cal.add(Calendar.MONTH, 1);
        tmp[1] = cal.getTime();

        if (start.compareTo(end) >= 0) {
            return;
        }
        calMonth(cal, tmp[1], end, result);
    }

    /**
     * Calculate all month between startDate and endDate.
     * @see #getAllMonths(Date, Date, Integer, Integer)
     * @param start startDate
     * @param end endDate
     * @return Map with months.
     */
    public static Map<Integer, Date[]> getAllMonths(Date start, Date end) {
        return getAllMonths(start, end, 0, 0);
    }
}
