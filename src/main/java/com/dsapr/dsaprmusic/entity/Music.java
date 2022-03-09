package com.dsapr.dsaprmusic.entity;

import com.dsapr.dsaprmusic.enums.MusicStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
public class Music extends AbstractEntity{
    private String name;

    @Enumerated(EnumType.STRING)
    private MusicStatus musicStatus;

    private String description;
}
