package com.dsapr.dsaprmusic.service;

import com.dsapr.dsaprmusic.dto.UserCreateDto;
import com.dsapr.dsaprmusic.dto.UserDto;
import com.dsapr.dsaprmusic.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/11 14:14
 */
public interface UserService extends UserDetailsService {
    List<UserDto> list();

    UserDto create(UserCreateDto userCreateDto);

    @Override
    User loadUserByUsername(String username);
}
