package com.dsapr.dsaprmusic.dto;

import com.dsapr.dsaprmusic.enums.FileStatus;
import com.dsapr.dsaprmusic.enums.FileType;
import com.dsapr.dsaprmusic.enums.Storage;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
public class FileDto extends BaseDto{
    private String name;

    private String key;

    private String ext;

    private Integer size;

    private FileType type;

    private Storage storage;

    private FileStatus status;
}
