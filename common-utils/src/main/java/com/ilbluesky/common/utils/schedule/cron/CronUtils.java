package com.ilbluesky.common.utils.schedule.cron;

import com.ilbluesky.common.utils.test.Asserts;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Orca Zhang
 * date 1/13/2025
 */
public class CronUtils {

    /**
     * Parse cron string and generate a list of date between startDate and endDate.
     * @param cron Cron String
     * @param startDate Begin date
     * @param endDate End Date
     * @return A list of date
     */
    public static List<LocalDateTime> getCronTimeArr(String cron, LocalDateTime startDate, LocalDateTime endDate) {
        Asserts.notNull(cron, "cron expression can not be null.");
        Asserts.notNull(startDate, "startDate can not be null.");
        Asserts.notNull(endDate, "endDate can not be null.");

        List<LocalDateTime> result = new ArrayList<>();
        CronExpression expression = CronExpression.parse(cron);
        while (startDate.compareTo(endDate) < 0) {
            startDate = expression.next(startDate);
            result.add(startDate);
        }

        return result;
    }
}
