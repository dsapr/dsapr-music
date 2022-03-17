package com.dsapr.dsaprmusic.mapper;

import com.dsapr.dsaprmusic.dto.MusicCreateRequest;
import com.dsapr.dsaprmusic.dto.MusicDto;
import com.dsapr.dsaprmusic.dto.MusicUpdateRequest;
import com.dsapr.dsaprmusic.entity.Music;
import com.dsapr.dsaprmusic.vo.MusicVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MusicMapper extends MapperInterface<Music, MusicDto> {

    MusicVo toVo(MusicDto musicDto);

    MusicDto toDto(MusicCreateRequest musicCreateRequest);

    MusicDto toDto(MusicUpdateRequest musicUpdateRequest);
}
