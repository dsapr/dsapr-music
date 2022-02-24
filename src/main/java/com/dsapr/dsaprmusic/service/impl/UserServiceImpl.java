package com.dsapr.dsaprmusic.service.impl;

import com.dsapr.dsaprmusic.dto.UserCreateRequest;
import com.dsapr.dsaprmusic.dto.UserDto;
import com.dsapr.dsaprmusic.dto.UserUpdateRequest;
import com.dsapr.dsaprmusic.entity.User;
import com.dsapr.dsaprmusic.exception.BizException;
import com.dsapr.dsaprmusic.exception.ExceptionType;
import com.dsapr.dsaprmusic.mapper.UserMapper;
import com.dsapr.dsaprmusic.repository.UserRepository;
import com.dsapr.dsaprmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/11 14:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper mapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDto create(UserCreateRequest userCreateRequest) {
        checkUserName(userCreateRequest.getUsername());
        User user = mapper.createEntity(userCreateRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toDto(userRepository.save(user));
    }

    @Override
    public User loadUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }

        return user.get();
    }

    @Override
    public UserDto get(String id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return mapper.toDto(user.get());
    }

    @Override
    public UserDto update(String id, UserUpdateRequest userUpdateRequest) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return mapper.toDto(userRepository.save(mapper.updateEntity(user.get(), userUpdateRequest)));
    }

    @Override
    public Page<UserDto> search(Pageable pageable) {
        return userRepository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public void delete(String id) {

        // Todo: 重构
        User user = userRepository.getById(id);
        if (user == null) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }

        userRepository.delete(user);
    }

    private void checkUserName(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }


}
