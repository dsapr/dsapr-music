package com.dsapr.dsaprmusic.service;

import com.dsapr.dsaprmusic.dto.UserCreateRequest;
import com.dsapr.dsaprmusic.dto.UserDto;
import com.dsapr.dsaprmusic.dto.UserUpdateRequest;
import com.dsapr.dsaprmusic.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/11 14:14
 */
public interface UserService extends UserDetailsService {

    UserDto create(UserCreateRequest userCreateRequest);

    @Override
    User loadUserByUsername(String username);

    UserDto get(String id);

    UserDto update(String id, UserUpdateRequest userUpdateRequest);

    Page<UserDto> search(Pageable pageable);

    void delete(String id);
}
