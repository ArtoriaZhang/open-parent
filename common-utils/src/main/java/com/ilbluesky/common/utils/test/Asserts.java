package com.ilbluesky.common.utils.test;

import com.ilbluesky.common.utils.excepton.ExceptionUtils;
import com.ilbluesky.common.utils.lang.ObjectUtils;
import com.ilbluesky.common.utils.lang.StringUtils;

import javax.annotation.Nullable;
import java.util.function.Supplier;

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

    /**
     *
     * @param text Target
     * @param message Exception message.
     */
    public static void hasLength(@Nullable String text, String message) {
        if (!StringUtils.hasLength(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     *
     * @param text Target
     * @param messageSupplier Exception message supplier.
     */
    public static void hasLength(@Nullable String text, Supplier<String> messageSupplier) {
        if (!StringUtils.hasLength(text)) {
            throw new IllegalArgumentException(nullSafeGet(messageSupplier));
        }
    }

    /**
     *
     * @param expression
     * @param message
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    @Nullable
    /**
     *
     */
    private static String nullSafeGet(@Nullable Supplier<String> messageSupplier) {
        return messageSupplier != null ? (String)messageSupplier.get() : null;
    }

    /**
     *
     * @param array Target
     * @param message Exception message
     */
    public static void notEmpty(@Nullable Object[] array, String message) {
        if (ObjectUtils.isEmpty(array)) {
            throw new IllegalArgumentException(message);
        }
    }

}
