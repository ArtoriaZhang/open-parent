package com.ilbluesky.common.utils.date;

import com.ilbluesky.common.utils.test.Asserts;

import java.util.*;

/**
 * @author Orca Zhang
 * date 12/10/2024
 */
public class WeekUtils extends DateUtils{

    /**
     * Get current week of year.
     * @return int: week number
     */
    public static int getCurrentWeek() {
        return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * Get all weeks between <b>start</b> and <b>end</b>.
     * See also {@link #getAllWeeks(Date, Date, Integer, Integer)}
     * @param start
     * @param end
     * @return Map with weeks
     */
    public static Map<Integer, Date[]> getAllWeeks(Date start, Date end) {
        return getAllWeeks(start, end, 0, 0);
    }
    /**
     * Get all weeks and each start day and end day of the week.
     * @param start Start day.
     * @param end End day
     * @param hourOfDay Hour of the start day. Default 0. Can be 0 - 23.
     * @param minuteOfHour Minute of the hour of the start day. Default 0. can be 0 - 59.
     * @return LinkedHashMap
     */
    public static Map<Integer, Date[]> getAllWeeks(Date start, Date end, Integer hourOfDay, Integer minuteOfHour) {

        Calendar cal = Calendar.getInstance();

        end = end == null ? new Date() : end;

        checkDate(cal, start, end);

        LinkedHashMap<Integer, Date[]> result = new LinkedHashMap<>();

        cal.setTime(start);
        setHourMinute(cal, hourOfDay, minuteOfHour);
        Integer week = cal.get(Calendar.WEEK_OF_YEAR);
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.SECOND, 0);

        calcWeeks(cal, result, end);

        return result;
    }

    private static void calcWeeks(Calendar cal, LinkedHashMap<Integer, Date[]> result, Date end) {

        Integer week = cal.get(Calendar.WEEK_OF_YEAR);
        Date[] tmpArr = new Date[2];
        result.put(week, tmpArr);

        tmpArr[0] = cal.getTime();
        cal.add(Calendar.DAY_OF_YEAR, 7);
        tmpArr[1] = cal.getTime();

        if (tmpArr[1].getTime() >= end.getTime()) {
            return;
        }
        calcWeeks(cal, result, end);
    }

}
