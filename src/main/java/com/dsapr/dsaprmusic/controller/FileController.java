package com.dsapr.dsaprmusic.controller;

import com.dsapr.dsaprmusic.dto.FileDto;
import com.dsapr.dsaprmusic.dto.FileUploadDto;
import com.dsapr.dsaprmusic.dto.FileUploadRequest;
import com.dsapr.dsaprmusic.mapper.FileMapper;
import com.dsapr.dsaprmusic.mapper.FileUploadMapper;
import com.dsapr.dsaprmusic.service.FileService;
import com.dsapr.dsaprmusic.vo.FileUploadVo;
import com.dsapr.dsaprmusic.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("haseRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private FileUploadMapper fileUploadMapper;

    @PostMapping("/upload_init")
    public FileUploadVo initUpload(@Validated @RequestBody FileUploadRequest fileUploadRequest) {
        return fileUploadMapper.toVo(fileService.initUpload(fileUploadRequest));
    }

    @PostMapping("/{id}/upload_finish")
    public FileVo finishUpload(@PathVariable String id) {
        return fileMapper.toVo(fileService.finishUpload(id));
    }
}
