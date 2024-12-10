package com.ilbluesky.common.utils.excepton;

/**
 * @author Orca Zhang
 * @date 12/10/2024
 */
public class ExceptionUtils {

    public static void throwCustomException(String msg) {
        throw new BusinessException(msg);
    }

    public static void throwException(String msg) {
        throw new RuntimeException(msg);
    }
}
