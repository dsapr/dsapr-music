package com.dsapr.dsaprmusic.mapper;

import com.dsapr.dsaprmusic.dto.UserCreateRequest;
import com.dsapr.dsaprmusic.dto.UserDto;
import com.dsapr.dsaprmusic.dto.UserUpdateRequest;
import com.dsapr.dsaprmusic.entity.User;
import com.dsapr.dsaprmusic.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/11 14:07
 */
@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateRequest userCreateRequest);

    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
