package com.ilbluesky.common.utils.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Orca Zhang
 * date 1/5/2026
 */
public class CollectionUtilsTest {

    @Test
    public void testSplitList() {
        List<String> source = new ArrayList<>();
        for (int i = 0; i < 20; i ++) {
            source.add(String.valueOf(i));
        }

        List<List<String>> t = CollectionUtils.split(source, 3);
        Assertions.assertEquals(7, t.size());

        t = CollectionUtils.split(source, 4);
        Assertions.assertEquals(5, t.size());

        Assertions.assertEquals("19", t.get(t.size() -1).get(t.get(t.size() -1).size() -1));
    }
}
