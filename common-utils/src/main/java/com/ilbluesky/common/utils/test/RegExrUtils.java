package com.ilbluesky.common.utils.test;

import java.util.regex.Pattern;

/**
 * @author Orca Zhang
 * date 12/11/2024
 */
public class RegExrUtils {

    public static boolean matches(String pattern, String target) {
        return Pattern.compile(pattern).matcher(target).matches();
    }
}
