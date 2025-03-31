package com.ilbluesky.common.utils.crypto;

import org.junit.jupiter.api.Test;

/**
 * @author Orca Zhang
 * date 2/8/2025
 */
public class Md5UtilsTest {

    @Test
    public void testMd5() {
        System.out.println(MD5Utils.hash("abc"));
    }
}
