package com.ilbluesky.common.utils.lang;

import javax.annotation.Nullable;
/**
 * @author Orca Zhang
 * date 1/13/2025
 */
public class ObjectUtils {

    /**
     *
     * @param array Object array
     * @return true if empty.
     */
    public static boolean isEmpty(@Nullable Object[] array) {
        return array == null || array.length == 0;
    }

}
