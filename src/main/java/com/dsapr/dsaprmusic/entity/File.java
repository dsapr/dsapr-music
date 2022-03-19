package com.dsapr.dsaprmusic.entity;

import com.dsapr.dsaprmusic.enums.FileStatus;
import com.dsapr.dsaprmusic.enums.FileType;
import lombok.Data;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
public class File extends BaseEntity {
    private String name;

    private String key;

    private String ext;

    private Integer size;

    @Enumerated(EnumType.STRING)
    private FileType type;

    @Enumerated(EnumType.STRING)
    private FileStatus status = FileStatus.UPLOADING;
}
