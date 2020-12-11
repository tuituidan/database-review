package com.tuituidan.dbreview.exception;

import com.tuituidan.dbreview.util.StringExtUtils;

import ch.qos.logback.classic.spi.EventArgUtil;

/**
 * RunException.
 *
 * @author tuituidan
 * @version 1.0
 * @date 2020/12/11
 */
public class RunException extends RuntimeException {

    private static final long serialVersionUID = -8719642386102557954L;

    /**
     * WrapperException.
     *
     * @param message message
     * @param args args
     */
    public RunException(String message, Object... args) {
        super(StringExtUtils.format(message, args), EventArgUtil.extractThrowable(args));
    }

}
