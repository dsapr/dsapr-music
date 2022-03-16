package com.dsapr.dsaprmusic.service;

import com.dsapr.dsaprmusic.dto.BaseDto;
import com.dsapr.dsaprmusic.entity.BaseEntity;
import com.dsapr.dsaprmusic.exception.ExceptionType;
import com.dsapr.dsaprmusic.mapper.MapperInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dsapr
 * @data 2022/3/16
 */
public interface GeneralService<Entity extends BaseEntity, Dto extends BaseDto> {
    JpaRepository<Entity, String> getRepository();

    MapperInterface<Entity, Dto> getMapper();

    ExceptionType getNotFoundExceptionType();

    Dto create(Dto dto);

    Dto get(String id);

    Dto update(String id, Dto dto);

    void delete(String id);

    Page<Dto> search(Dto searchDto, Pageable pageable);
}
