package com.ilbluesky.common.utils.date;

import com.ilbluesky.common.utils.test.Asserts;
import com.ilbluesky.common.utils.test.RegExrUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Orca Zhang
 * date 12/11/2024
 */
public class YearUtils {

    /**
     * See also {@link #getAllYears(String, String, Integer, Integer)}.
     * @param yearStart Year-start. Format yyyy. E.g. 2024
     * @param yearEnd Year-end. The format is same as <b>yearStart</b>
     * @return LinkedHashMap
     */
    public static Map<String, Date[]> getAllYears(String yearStart, String yearEnd) {
        return getAllYears(yearStart, yearEnd, 0, 0);
    }

    /**
     * Get each year start and end date between <b>yearStart</b> and <b>yearEnd</b>.
     * @param yearStart Year-start. Format yyyy. E.g. 2024
     * @param yearEnd Year-end. The format is same as <b>yearStart</b>
     * @param hourOfDay Hour. Range 0-23.
     * @param minuteOfHour Minute. Range 0-59.
     * @return LinkedHashMap
     */
    public static Map<String, Date[]> getAllYears(String yearStart, String yearEnd, Integer hourOfDay,
                                                  Integer minuteOfHour) {

        Asserts.notNull(yearStart, String.format("The start quarter cannot be null"));

        StringBuilder sb = new StringBuilder();
        Calendar cld = Calendar.getInstance();
        if (yearEnd == null) {
            yearEnd = sb.append(cld.get(Calendar.YEAR)).toString();
        }
        Date[] startEndArr = calStartEndDate(yearStart, yearEnd, cld, hourOfDay, minuteOfHour);

        Map<String, Date[]> result = new LinkedHashMap<>();
        calYears(startEndArr[0], startEndArr[1], result, cld);
        
        return result;
    }

    private static void calYears(Date yearStart, Date yearEnd, Map<String, Date[]> result, Calendar cld) {

        cld.setTime(yearStart);
        String yearStr = String.valueOf(cld.get(Calendar.YEAR));
        Date[] dateArr = new Date[2];
        result.put(yearStr, dateArr);

        dateArr[0] = cld.getTime();
        cld.add(Calendar.YEAR, 1);
        dateArr[1] = cld.getTime();

        if (dateArr[1].getTime() >= yearEnd.getTime()) {
            return;
        }
        calYears(dateArr[1], yearEnd, result, cld);
    }

    private static Date[] calStartEndDate(String yearStart, String yearEnd, Calendar cld,
                                          Integer hourOfDay, Integer minuteOfHour) {
        Asserts.beTrue(RegExrUtils.matches("\\d{4}", yearStart),
                String.format("The format of yearStart[%s] is not acceptable", yearStart));
        Asserts.beTrue(RegExrUtils.matches("\\d{4}", yearEnd),
                String.format("The format of yearEnd[%s] is not acceptable", yearEnd));

        Date[] result = new Date[2];
        cld.set(Calendar.DAY_OF_YEAR, 1);
        cld.set(Calendar.YEAR, Integer.valueOf(yearStart));
        cld.set(Calendar.HOUR_OF_DAY, hourOfDay == null ? 0 : hourOfDay);
        cld.set(Calendar.MINUTE, minuteOfHour == null ? 0 : minuteOfHour);
        cld.set(Calendar.SECOND, 0);

        result[0] = cld.getTime();

        cld.add(Calendar.YEAR, 1);
        result[1] = cld.getTime();
        cld.setTime(result[0]);
        return result;
    }
}
