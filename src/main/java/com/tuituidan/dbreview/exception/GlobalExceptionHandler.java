package com.tuituidan.dbreview.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/17
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 统一处理 ImageHostException 的方法.
     *
     * @param ex 异常实例
     * @return 异常提示字符串
     */
    @ExceptionHandler(RunException.class)
    public ResponseEntity<String> handleException(RunException ex) {
        // ex.getCause()：包装了一层的，所以用ex.getCause()拿到原始的异常写日志就行
        log.error(ex.getMessage(), ex.getCause());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    /**
     * 捕获其他未知异常，避免报到前端.
     *
     * @param throwable throwable
     * @return String
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public String handleException(Throwable throwable) {
        log.error(throwable.getMessage(), throwable);
        return "服务器内部出现问题！";
    }
}
