package com.ilbluesky.common.utils.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Orca Zhang
 * date 1/9/2025
 */
public class GsonUtil {

    private GsonUtil() {}

    public static Gson getGson() {
        return GsonHolder.GSON;
    }

    private static class GsonHolder {
        private static final Gson GSON = new GsonBuilder().create();
    }
}
