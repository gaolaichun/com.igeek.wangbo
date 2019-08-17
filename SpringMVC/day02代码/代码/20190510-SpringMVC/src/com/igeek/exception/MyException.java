package com.igeek.exception;

/**
 * @author Administrator
 * @create 2019/05/10
 */
public class MyException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MyException(String message) {
        super(message);
        this.message = message;
    }

    public MyException(){

    }


}
