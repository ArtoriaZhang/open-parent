package com.ilbluesky.common.utils.date;

import com.ilbluesky.common.utils.date.YearUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Map;

/**
 * @author Orca Zhang
 * date 12/11/2024
 */
public class YearUtilsTest {

    @Test
    public void testGetAllYears() {

        Map<String, Date[]> result = YearUtils.getAllYears("2023", "2024");
        Assertions.assertTrue(result.size() == 2);

        result = YearUtils.getAllYears("2023", "2023");
        Assertions.assertTrue(result.size() == 1);

        result = YearUtils.getAllYears("2020", "2024");
        Assertions.assertTrue(result.size() == 5);

        Assertions.assertThrows(RuntimeException.class, () -> YearUtils.getAllYears("22", null));
    }
}
