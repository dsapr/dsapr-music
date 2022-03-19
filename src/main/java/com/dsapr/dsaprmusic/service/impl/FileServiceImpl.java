package com.dsapr.dsaprmusic.service.impl;

import com.dsapr.dsaprmusic.dto.FileDto;
import com.dsapr.dsaprmusic.dto.FileUploadDto;
import com.dsapr.dsaprmusic.dto.FileUploadRequest;
import com.dsapr.dsaprmusic.entity.File;
import com.dsapr.dsaprmusic.enums.FileStatus;
import com.dsapr.dsaprmusic.enums.FileType;
import com.dsapr.dsaprmusic.enums.Storage;
import com.dsapr.dsaprmusic.exception.BizException;
import com.dsapr.dsaprmusic.exception.ExceptionType;
import com.dsapr.dsaprmusic.mapper.FileMapper;
import com.dsapr.dsaprmusic.repository.FileRepository;
import com.dsapr.dsaprmusic.service.FileService;
import com.dsapr.dsaprmusic.service.StorageService;
import com.dsapr.dsaprmusic.utils.FileTypeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private Map<String, StorageService> storageServices;

    @Autowired
    private FileRepository repository;

    @Autowired
    private FileMapper mapper;

    @Override
    @Transactional
    public FileUploadDto initUpload(FileUploadRequest fileUploadRequest) {
        // 创建 File 实体
        File file = mapper.createEntity(fileUploadRequest);
        file.setType(getFileType(fileUploadRequest.getExt()));

        File savedSave = repository.save(file);

        // 通过接口获取STS令牌
        FileUploadDto fileUploadDto = storageServices.get(getDefaultStorage().name()).initFileUpload();

        fileUploadDto.setKey(savedSave.getKey());
        fileUploadDto.setFileId(savedSave.getId());
        return fileUploadDto;
    }

    private FileType getFileType(String ext) {
        return FileTypeTransformer.getFileTypeFromExt(ext);
    }

    @Override
    public FileDto finishUpload(String id) {
        Optional<File> fileOptional = repository.findById(id);
        if(!fileOptional.isPresent()) {
            throw new BizException(ExceptionType.FILE_NOT_FOUND);
        }

        // TODO 只有上传者才能更新 finish；权限判断

        // TODO 验证远程文件是否存在
        File file = fileOptional.get();
        file.setStatus(FileStatus.UPLOADED);

        return mapper.toDto(repository.save(file));
    }

    // Todo: 后台设置当前 Storage
    private Storage getDefaultStorage() {
        return Storage.COS;
    }
}
