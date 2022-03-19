package com.dsapr.dsaprmusic.service;

import com.dsapr.dsaprmusic.dto.FileDto;
import com.dsapr.dsaprmusic.dto.FileUploadDto;
import com.dsapr.dsaprmusic.dto.FileUploadRequest;

public interface FileService {

    FileUploadDto initUpload(FileUploadRequest fileUploadRequest);

    FileDto finishUpload(String id);
}
