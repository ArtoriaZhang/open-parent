package com.ilbluesky.common.utils.lang;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Orca Zhang
 * date 1/13/2025
 */
public abstract class CollectionUtils {
    static final float DEFAULT_LOAD_FACTOR = 0.75F;

    public CollectionUtils() {
    }

    /**
     *
     * @param collection Target collection.
     * @return True if empty or null.
     */
    public static boolean isEmpty(@Nullable Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     *
     * @param map Target
     * @return True if map is null or empty.
     */
    public static boolean isEmpty(@Nullable Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     *
     * @param expectedSize Map size
     * @return HashMap instance.
     * @param <K> The generic of key.
     * @param <V> The generic of Value.
     */
    public static <K, V> HashMap<K, V> newHashMap(int expectedSize) {
        return new HashMap((int) ((float) expectedSize / 0.75F), 0.75F);
    }
}