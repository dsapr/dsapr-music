package com.dsapr.dsaprmusic.dto;

import com.dsapr.dsaprmusic.enums.MusicStatus;
import lombok.Data;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@ToString(callSuper = true)
public class MusicDto extends BaseDto{
    private String name;

    @Enumerated(EnumType.STRING)
    private MusicStatus status = MusicStatus.DRAFT;

    private String description;
}
