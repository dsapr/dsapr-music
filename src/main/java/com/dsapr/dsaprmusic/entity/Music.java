package com.dsapr.dsaprmusic.entity;

import com.dsapr.dsaprmusic.enums.MusicStatus;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Music extends AbstractEntity{
    private String name;

    private MusicStatus musicStatus;

    private String description;
}
