package com.dsapr.dsaprmusic.dto;

import lombok.Data;

@Data
public class FileUploadDto {
    private String secretId;

    private String secretKey;

    private String sessionToken;

    private String key;

    private String fileId;

    private String bucket;

    private String region;
}
