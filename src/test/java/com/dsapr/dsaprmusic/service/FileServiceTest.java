package com.dsapr.dsaprmusic.service;

import com.dsapr.dsaprmusic.dto.FileDto;
import com.dsapr.dsaprmusic.dto.FileUploadDto;
import com.dsapr.dsaprmusic.dto.FileUploadRequest;
import com.dsapr.dsaprmusic.enums.FileStatus;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class FileServiceTest {

    @Autowired
    FileService fileService;

    @Test
    void initUpload() {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("u898sdfs879898sdfsd456");
        fileUploadRequest.setSize(30000);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);

        Assertions.assertNotNull(fileUploadDto.getKey());
        Assertions.assertNotNull(fileUploadDto.getFileId());
        Assertions.assertNotNull(fileUploadDto.getBucket());
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSecretKey());
        Assertions.assertNotNull(fileUploadDto.getSessionToken());
        Assertions.assertEquals(fileUploadDto.getKey(), fileUploadRequest.getKey());
        log.info(fileUploadDto.toString());
    }

    @Test
    void finishUpload() {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("u898sdfs879898sdfsd456");
        fileUploadRequest.setSize(30000);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);

        FileDto finishedFile = fileService.finishUpload(fileUploadDto.getFileId());

        Assertions.assertEquals(FileStatus.UPLOADED, finishedFile.getStatus().name());
        log.info(finishedFile.getStatus().name());
    }
}