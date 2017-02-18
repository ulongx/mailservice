package com.mapath.mailservice.exception;

/**
 * Created by ulongx on 2017/2/18.
 */
public class CustomerException extends Exception {

    public CustomerException(String message) {
        super(message);
    }

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
