package com.ilbluesky.common.utils.test;

import com.ilbluesky.common.utils.excepton.ExceptionUtils;

/**
 * @author Orca Zhang
 * date 12/10/2024
 */
public class Asserts {

    /**
     * Null then throw exception.
     * @param tar
     * @param msg
     */
    public static void notNull(Object tar, String msg) {
        if (tar == null) {
            ExceptionUtils.throwException(msg);
        }
    }

    /**
     * Throw runtime Exc if false
     * @param bol condition
     * @param msg Exception msg
     */
    public static void beTrue(boolean bol, String msg) {
        if (!bol) {
            ExceptionUtils.throwException(msg);
        }
    }
}
