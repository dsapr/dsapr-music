package com.dsapr.dsaprmusic.mapper;

import com.dsapr.dsaprmusic.dto.FileDto;
import com.dsapr.dsaprmusic.dto.FileUploadRequest;
import com.dsapr.dsaprmusic.entity.File;
import com.dsapr.dsaprmusic.vo.FileVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {
    File createEntity(FileUploadRequest fileUploadRequest);

    FileVo toVo(FileDto fileDto);

    FileDto toDto(File file);
}
