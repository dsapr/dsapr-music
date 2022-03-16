package com.dsapr.dsaprmusic.dto;

import com.dsapr.dsaprmusic.enums.MusicStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class MusicDto extends BaseDto{
    private String name;

    @Enumerated(EnumType.STRING)
    private MusicStatus status;

    private String description;
}
