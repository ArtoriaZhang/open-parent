package com.ilbluesky.common.utils.date;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 * @author Orca Zhang
 * date 12/10/2024
 */
public class DateUtils {

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}
