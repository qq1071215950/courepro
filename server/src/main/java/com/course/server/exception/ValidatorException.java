package com.course.server.exception;

/**
 * @author jiange
 * @date 2020/6/29 20:25
 */
public class ValidatorException extends RuntimeException{
    public ValidatorException(String message) {
        super(message);
    }
}
