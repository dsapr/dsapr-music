package com.dsapr.dsaprmusic.vo;

import com.dsapr.dsaprmusic.enums.MusicStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MusicVo {
    private String id;

    private String name;

    private MusicStatus status;

    private String description;

    @JsonFormat(timezone = "GTM+8", pattern = "yyyyMMddHHmmss")
    private Date createdTime;

    @JsonFormat(timezone = "GTM+8", pattern = "yyyyMMddHHmmss")
    private Date updatedTime;
}
