package com.dsapr.dsaprmusic.mapper;

import com.dsapr.dsaprmusic.dto.BaseDto;
import com.dsapr.dsaprmusic.entity.BaseEntity;
import org.mapstruct.MappingTarget;

/**
 * @author dsapr
 * @data 2022/3/16
 */
public interface MapperInterface<Entity extends BaseEntity, Dto extends BaseDto> {
    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    Entity updateEntity(@MappingTarget Entity entity, Dto dto);
}
