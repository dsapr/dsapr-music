package com.dsapr.dsaprmusic.service;

import com.dsapr.dsaprmusic.dto.UserCreateDto;
import com.dsapr.dsaprmusic.dto.UserDto;
import com.dsapr.dsaprmusic.entity.User;
import com.dsapr.dsaprmusic.exception.BizException;
import com.dsapr.dsaprmusic.exception.ExceptionType;
import com.dsapr.dsaprmusic.mapper.UserMapper;
import com.dsapr.dsaprmusic.repository.UserRepository;
import com.dsapr.dsaprmusic.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/11 14:14
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Qualifier("userMapper")
    @Autowired
    UserMapper mapper;

    @Override
    public List<UserDto> list() {
        return userRepository.findAll()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        checkUserName(userCreateDto.getUsername());
        User user = mapper.createEntity(userCreateDto);
        User save = userRepository.save(user);
        return mapper.toDto(save);
    }

    private void checkUserName(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }
}
