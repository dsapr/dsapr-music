package com.dsapr.dsaprmusic.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author dsapr
 * @data 2022/3/16
 */
@Data
public class BaseDto {
    private String id;

    private Date createdTime;

    private Date updatedTime;
}
