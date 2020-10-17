package com.tuituidan.dbreview.exception;

import com.tuituidan.dbreview.kit.StringKit;

import ch.qos.logback.classic.spi.EventArgUtil;

/**
 * DbReviewException.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/17
 */
public class DbReviewException extends RuntimeException{

    private static final long serialVersionUID = -6611783498373065076L;

    private final String tip;

    /**
     * 非public只被ExceptionBuilder使用.
     *
     * @param tip tip
     * @param error error
     * @param cause cause
     */
    private DbReviewException(String tip, String error, Throwable cause) {
        super(error, cause);
        this.tip = tip;
    }

    String getTip() {
        return this.tip;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String tip;

        private String error;

        private Throwable cause;

        public Builder tip(String msg, Object... args) {
            this.tip = StringKit.format(msg, args);
            return this;
        }

        public Builder error(String msg, Object... args) {
            this.cause = EventArgUtil.extractThrowable(args);
            this.error = StringKit.format(msg, args);
            return this;
        }

        public DbReviewException build() {
            return new DbReviewException(this.tip, this.error, this.cause);
        }
    }
}
