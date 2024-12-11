package com.ilbluesky.common.utils.date;

import com.ilbluesky.common.utils.test.Asserts;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Orca Zhang
 * date 12/11/2024
 */
public class QuarterUtils {

    /**
     * See also {@link #getAllQuarters(String, String, Integer, Integer)}.
     * @param quarterStart
     * @param quarterEnd
     * @return
     */
    public static Map<String, Date[]> getAllQuarters(String quarterStart, String quarterEnd) {

        return getAllQuarters(quarterStart, quarterEnd, 0, 0);
    }

    /**
     * Calculate each quarter start and end date between <b>quarterStart</b> and <b>quarterEnd</b>.
     * @param quarterStart The start quarter string. Format yyyy-Q. E.g. 2024-1.
     * @param quarterEnd The end quarter string. Format same as <b>quarterStart</b>
     * @param hourOfDay The hour number. Default 0. Range 0-23.
     * @param minuteOfHour The minute number. Default 0. Range 0-59.
     * @return LinkedHashMap
     */
    public static Map<String, Date[]> getAllQuarters(String quarterStart, String quarterEnd, Integer hourOfDay
            , Integer minuteOfHour) {

        Asserts.notNull(quarterStart, String.format("The start quarter cannot be null"));

        StringBuilder sb = new StringBuilder();
        Calendar cld = Calendar.getInstance();
        if (quarterEnd == null) {
            quarterEnd = sb.append(cld.get(Calendar.YEAR)).append("-").append((cld.get(Calendar.MONTH) / 3) + 1)
                    .toString();
        }
        Date[] startEndArr = calStartEndDate(quarterStart, quarterEnd, sb, cld, hourOfDay, minuteOfHour);

        Map<String, Date[]> result = new LinkedHashMap<>();

        calQuarters(result, startEndArr[0], startEndArr[1], cld, sb);

        return result;
    }

    private static void calQuarters(Map<String, Date[]> result, Date start, Date end, Calendar cld, StringBuilder sb) {

        cld.setTime(start);
        String quarter = calDateQuarter(start, sb, cld);
        Date[] dateArr = new Date[2];
        result.put(quarter, dateArr);

        dateArr[0] = start;
        cld.add(Calendar.MONTH, 3);
        dateArr[1] = cld.getTime();

        if (cld.getTime().getTime() >= end.getTime()) {
            return;
        }
        calQuarters(result, dateArr[1], end, cld, sb);
    }

    private static String calDateQuarter(Date start, StringBuilder sb, Calendar cld) {
        sb.setLength(0);
        return sb.append(cld.get(Calendar.YEAR)).append("-").append(cld.get(Calendar.MONTH) / 3 + 1).toString();
    }

    private static Date[] calStartEndDate(String quarterStart, String quarterEnd, StringBuilder sb, Calendar cld,
                                          Integer hourOfDay, Integer minuteOfHour) {

        Date[] result = new Date[2];

        Pattern p = Pattern.compile("\\d{4}-\\d");
        Matcher m = p.matcher(quarterStart);
        Asserts.beTrue(m.matches(), String.format("The startQuarter string[%s] is not acceptable.", quarterStart));
        Asserts.beTrue(p.matcher(quarterEnd).matches(),
                String.format("The endQuarter string[%s] is not acceptable.", quarterEnd));

        String[] yMArr = quarterStart.split("-");
        cld.set(Calendar.YEAR, Integer.valueOf(yMArr[0]));
        cld.set(Calendar.MONTH, (Integer.valueOf(yMArr[1]) - 1) * 3);
        cld.set(Calendar.DAY_OF_MONTH, 1);
        cld.set(Calendar.HOUR_OF_DAY, hourOfDay == null ? 0 : hourOfDay);
        cld.set(Calendar.MINUTE, minuteOfHour == null ? 0 : minuteOfHour);
        cld.set(Calendar.SECOND,  0);

        result[0] = cld.getTime();

        yMArr = quarterEnd.split("-");
        cld.set(Calendar.YEAR, Integer.valueOf(yMArr[0]));
        cld.set(Calendar.MONTH, (Integer.valueOf(yMArr[1]) * 3));

        result[1] = cld.getTime();

        cld.setTime(result[0]);
        return result;
    }
}
