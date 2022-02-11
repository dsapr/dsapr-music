package com.dsapr.dsaprmusic.service;

import com.dsapr.dsaprmusic.dto.UserDto;
import com.dsapr.dsaprmusic.entity.User;
import com.dsapr.dsaprmusic.mapper.UserMapper;
import com.dsapr.dsaprmusic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/11 14:14
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper mapper;

    @Override
    public List<UserDto> list() {
        return userRepository.findAll()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
