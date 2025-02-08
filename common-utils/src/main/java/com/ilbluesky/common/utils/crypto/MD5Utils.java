package com.ilbluesky.common.utils.crypto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Orca Zhang
 * date 2/8/2025
 */
public class MD5Utils {
    private MD5Utils() {}

    /**
     * Get MD5 hash of <code>target</code>
     * @param target The String
     * @return MD5 Hash
     */
    public static String hash(String target) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return new String(md.digest(target.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
