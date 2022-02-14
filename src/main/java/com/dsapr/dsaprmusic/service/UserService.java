package com.dsapr.dsaprmusic.service;

import com.dsapr.dsaprmusic.dto.UserCreateDto;
import com.dsapr.dsaprmusic.dto.UserDto;
import com.dsapr.dsaprmusic.vo.UserVo;

import java.util.List;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/11 14:14
 */
public interface UserService {
    List<UserDto> list();

    UserDto create(UserCreateDto userCreateDto);
}
