package com.itmo.soa.services.exceptions;

/**
 * @program: SOA-Lab2
 * @author: Siyuan
 * @create: 2022-10-11 19:00
 **/
public class NoSuchObjException extends ServiceException {
    public NoSuchObjException() {
        super();
    }

    public NoSuchObjException(String message) {
        super(message);
    }

    public NoSuchObjException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchObjException(Throwable cause) {
        super(cause);
    }

    protected NoSuchObjException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

