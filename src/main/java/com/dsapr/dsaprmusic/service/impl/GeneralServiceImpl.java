package com.dsapr.dsaprmusic.service.impl;

import com.dsapr.dsaprmusic.dto.BaseDto;
import com.dsapr.dsaprmusic.entity.BaseEntity;
import com.dsapr.dsaprmusic.exception.BizException;
import com.dsapr.dsaprmusic.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author dsapr
 * @data 2022/3/16
 */
public abstract class GeneralServiceImpl<Entity extends BaseEntity, Dto extends BaseDto> implements GeneralService<Entity, Dto> {

    @Override
    public Dto create(Dto dto) {
        return getMapper().toDto(getRepository().save(getMapper().toEntity(dto)));
    }

    @Override
    public Dto get(String id) {
        return getMapper().toDto(getEntity(id));
    }

    protected Entity getEntity(String id) {
        Optional<Entity> optionalEntity = getRepository().findById(id);
        if (!optionalEntity.isPresent()) {
            throw new BizException(getNotFoundExceptionType());
        }
        return optionalEntity.get();
    }

    @Override
    public Dto update(String id, Dto dto) {
        // Todo: dto 可能无法控制更新字段
        Entity existedEntity = getEntity(id);
        Entity updateEntity = getMapper().updateEntity(existedEntity, dto);
        return getMapper().toDto(getRepository().save(updateEntity));
    }

    @Override
    public void delete(String id) {
        Entity existedEntity = getEntity(id);
        getRepository().delete(existedEntity);
    }

    @Override
    public Page<Dto> search(BaseDto searchDto, Pageable pageable) {
        return null;
    }
}
