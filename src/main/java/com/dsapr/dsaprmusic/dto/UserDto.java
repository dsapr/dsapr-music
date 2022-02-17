package com.dsapr.dsaprmusic.dto;

import com.dsapr.dsaprmusic.enums.Gender;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/11 13:58
 */
@Data
public class UserDto {
    private String id;

    private String username;

    private String nickname;

    private List<RoleDto> roles;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private String lastLoginIp;

    private Date lastLoginTime;
}
