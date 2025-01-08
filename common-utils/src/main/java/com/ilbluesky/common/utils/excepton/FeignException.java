package com.ilbluesky.common.utils.excepton;

/**
 * @author Orca Zhang
 * date 1/8/2025
 */
public class FeignException extends RuntimeException{

    public FeignException() {
        super();
    }

    public FeignException(String message) {
        super(message);
    }

    public FeignException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeignException(Throwable cause) {
        super(cause);
    }

    protected FeignException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
