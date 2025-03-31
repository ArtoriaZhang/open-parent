package com.ilbluesky.common.utils.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @author Orca Zhang
 * date 3/31/2025
 */
public class MonthUtilsTest {

    @Test
    public void testGetAllMonths() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date start = calendar.getTime();

        calendar.set(Calendar.MONTH, 3);
        Date end = calendar.getTime();
        Map<Integer, Date[]> months = MonthUtils.getAllMonths(start, end);

        Assertions.assertTrue(months.size() == 3);
    }
}
