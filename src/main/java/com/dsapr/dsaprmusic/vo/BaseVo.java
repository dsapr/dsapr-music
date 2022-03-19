package com.dsapr.dsaprmusic.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author dsapr
 * @data 2022/3/16
 */
@Data
public abstract class BaseVo {
    private String id;

    private Date createdTime;

    private Date updatedTime;
}
