package com.dsapr.dsaprmusic.controller;

import com.dsapr.dsaprmusic.dto.UserCreateRequest;
import com.dsapr.dsaprmusic.dto.UserUpdateRequest;
import com.dsapr.dsaprmusic.mapper.UserMapper;
import com.dsapr.dsaprmusic.service.UserService;
import com.dsapr.dsaprmusic.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    Page<UserVo> search(@PageableDefault(sort = {"createdTime"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.search(pageable).map(userMapper::toVo);
    }

    @PostMapping("/")
    UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest) {
        return userMapper.toVo(userService.create(userCreateRequest));
    }

    @GetMapping("/{id}")
    UserVo get(@PathVariable String id) {
        return userMapper.toVo(userService.get(id));
    }

    @PutMapping("/{id}")
    UserVo update(@PathVariable String id,
                  @Validated @RequestBody UserUpdateRequest userUpdateRequest) {
        return userMapper.toVo(userService.update(id, userUpdateRequest));
    }

    @DeleteMapping("/{id}")
    void delte(@PathVariable String id) {
        userService.delete(id);
    }

}
