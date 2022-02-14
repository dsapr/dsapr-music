package com.dsapr.dsaprmusic.exception;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/14 13:48
 */
public class BizException extends RuntimeException{
    private final Integer code;

    public BizException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.code = exceptionType.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
