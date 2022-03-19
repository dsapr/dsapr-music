package com.dsapr.dsaprmusic.vo;

import com.dsapr.dsaprmusic.enums.FileStatus;
import com.dsapr.dsaprmusic.enums.FileType;
import com.dsapr.dsaprmusic.enums.Storage;
import lombok.Data;

@Data
public class FileVo extends BaseVo{
    private String name;

    private String key;

    private String ext;

    private Integer size;

    private FileType type;

    private FileStatus status;
}
