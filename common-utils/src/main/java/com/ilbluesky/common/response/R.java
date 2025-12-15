package com.ilbluesky.common.response;

import org.apache.http.HttpStatus;

import java.util.Date;

/**
 * @author Orca Zhang
 * date 7/23/2021
 **/
public class R<T> {

    public static final String SUCCESS = "success";
    public static final String fail = "fail";

    private Integer code;
    private String message;
    private T result;
    private Date timestamp = new Date();

    public static <T> R<T> fail(String msg) {
        R<T> r = new R<>();
        r.setCode(HttpStatus.SC_BAD_REQUEST);
        r.setMessage(msg);
        return r;
    }
    public static <T> R<T> fail() {
        return fail(fail);
    }

    public static <T> R<T> success(T data, String msg) {
        R r = new R<T>();
        r.setResult(data);
        r.setMessage(msg);
        r.setCode(HttpStatus.SC_OK);
        return r;
    }

    public static <T> R<T> ok(T data) {
        return success(data, SUCCESS);
    }

    public static <T> R<T> success(T data) {
        return success(data, SUCCESS);
    }

    public static <T> R<T> success() {
        return success(null, SUCCESS);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T data) {
        this.result = data;
    }
}
