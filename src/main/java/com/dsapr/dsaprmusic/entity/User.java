package com.dsapr.dsaprmusic.entity;

import com.dsapr.dsaprmusic.enums.Gender;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/10 16:01
 */
@Entity
@Data
public class User extends AbstractEntity{

    private String username;

    private String nickname;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    /**
     * 是否锁定，1-是，0-否
     */
    private Boolean locked;

    /**
     * 是否可用，1-是，0-否
     */
    private Boolean enabled;

    private String lastLoginIp;

    private Date lastLoginTime;

}
