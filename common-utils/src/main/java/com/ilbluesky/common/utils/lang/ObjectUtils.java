package com.ilbluesky.common.utils.lang;

import javax.annotation.Nullable;
/**
 * @author Orca Zhang
 * date 1/13/2025
 */
public class ObjectUtils {

    private ObjectUtils() {}
    /**
     *
     * @param array Object array
     * @return true if empty.
     */
    public static boolean isEmpty(@Nullable Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * Test equal
     * @param a Object a.
     * @param b Object b.
     * @return True if a.equals(b)
     */
    public static boolean equal(@Nullable Object a, @Nullable Object b) {
        return a == b || a != null && a.equals(b);
    }
}
