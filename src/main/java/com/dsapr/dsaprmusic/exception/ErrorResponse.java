package com.dsapr.dsaprmusic.exception;

import lombok.Data;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/14 14:02
 */
@Data
public class ErrorResponse {
    private Integer code;

    private String message;

    private Object trace;
}
