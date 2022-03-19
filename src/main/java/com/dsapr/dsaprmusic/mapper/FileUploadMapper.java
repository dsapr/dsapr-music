package com.dsapr.dsaprmusic.mapper;

import com.dsapr.dsaprmusic.dto.FileUploadDto;
import com.dsapr.dsaprmusic.vo.FileUploadVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileUploadMapper {
    FileUploadVo toVo(FileUploadDto fileUploadDto);
}
