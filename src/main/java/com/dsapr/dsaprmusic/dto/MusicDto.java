package com.dsapr.dsaprmusic.dto;

import com.dsapr.dsaprmusic.enums.MusicStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
public class MusicDto {
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MusicStatus status;

    private String description;

    private Date createdTime;

    private Date updatedTime;
}
