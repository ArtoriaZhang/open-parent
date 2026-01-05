package com.ilbluesky.common.utils.collection;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Orca Zhang
 * date 1/5/2026
 */
public abstract class CollectionUtils {

    /**
     * Split the <b>source</b> list to specific size list of list.
     * @param source source list
     * @param size The split list's size.
     * @return List of list with size
     * @param <T>
     */
    public static <T> List<List<T>> split(@Nonnull List<T> source, @Nonnull int size) {
        if (source == null || size < 1) {
            throw new IllegalArgumentException("Source list cannot be null and size great than 1.");
        }
        int capacity = (source.size() + size - 1) / size;
        int decimal = source.size() % size;
        List<List<T>> result = new ArrayList<>(capacity);
        if (capacity == 1) {
            result.add(source);
            return result;
        }
        for (int i = 0; i < capacity; i++) {
            List<T> temp = new ArrayList<>(size);
            result.add(temp);
            if (i < capacity - 1 || decimal == 0) {
                for (int j = 0; j < size; j++) {
                    temp.add(source.get(i * size + j));
                }
            } else {
                for (int j = 0; j < decimal; j++) {
                    temp.add(source.get(i * size + j));
                }
            }
        }
        return result;
    }

}
