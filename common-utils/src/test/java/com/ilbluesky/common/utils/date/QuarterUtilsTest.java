package com.ilbluesky.common.utils.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Map;

/**
 * @author Orca Zhang
 * date 12/11/2024
 */
public class QuarterUtilsTest {

    @Test
    public void testGetAllQuarters() {
        Map<String, Date[]> result = null;

        result = QuarterUtils.getAllQuarters("2024-1", "2024-4");
        Assertions.assertTrue(result.size() == 4);

        result = QuarterUtils.getAllQuarters("2024-1", "2024-3");
        Assertions.assertTrue(result.size() == 3);


    }
}
