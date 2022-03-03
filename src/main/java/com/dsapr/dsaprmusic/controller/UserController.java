package com.dsapr.dsaprmusic.controller;

import com.dsapr.dsaprmusic.dto.UserCreateRequest;
import com.dsapr.dsaprmusic.dto.UserUpdateRequest;
import com.dsapr.dsaprmusic.mapper.UserMapper;
import com.dsapr.dsaprmusic.service.UserService;
import com.dsapr.dsaprmusic.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/11 13:52
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @GetMapping
    @ApiOperation("用户检索")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Page<UserVo> search(@PageableDefault(sort = {"createdTime"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.search(pageable).map(userMapper::toVo);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest) {
        return userMapper.toVo(userService.create(userCreateRequest));
    }

    @GetMapping("/{id}")
    UserVo get(@PathVariable String id) {
        return userMapper.toVo(userService.get(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    UserVo update(@PathVariable String id,
                  @Validated @RequestBody UserUpdateRequest userUpdateRequest) {
        return userMapper.toVo(userService.update(id, userUpdateRequest));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(@PathVariable String id) {
        userService.delete(id);
    }

    @GetMapping("/me")
    UserVo me() {
        return userMapper.toVo(userService.getCurrentUser());
    }

}
