package com.dsapr.dsaprmusic.vo;

import com.dsapr.dsaprmusic.entity.Role;
import com.dsapr.dsaprmusic.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/11 13:48
 */
@Data
public class UserVo extends BaseVo{

    private String id;

    private String username;

    private String nickname;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private List<RoleVo> roles;

}
