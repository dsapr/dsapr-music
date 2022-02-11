package com.dsapr.dsaprmusic.controller;

import com.dsapr.dsaprmusic.mapper.UserMapper;
import com.dsapr.dsaprmusic.service.UserService;
import com.dsapr.dsaprmusic.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/11 13:52
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @GetMapping("/")
    List<UserVo> list() {
        return userService.list()
                .stream().map(userMapper::toVo).collect(Collectors.toList());
    }

}
