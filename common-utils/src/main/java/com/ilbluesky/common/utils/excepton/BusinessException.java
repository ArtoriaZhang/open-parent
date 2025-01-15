package com.ilbluesky.common.utils.excepton;

/**
 * @author Orca Zhang
 * date 12/10/2024
 */
public class BusinessException extends RuntimeException{
    public BusinessException() {
    }

    /**
     *
     * @param message Exception message
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     *
     * @param message Exception message.
     * @param cause Throwable.
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     *
     * @param cause Throwable.
     */
    public BusinessException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message Exception message.
     * @param cause Throwable
     * @param enableSuppression whether or not suppression is enabled
     *                          or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     */
    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
