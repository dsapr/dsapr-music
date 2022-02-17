package com.dsapr.dsaprmusic.entity;

import com.dsapr.dsaprmusic.enums.Gender;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/10 16:01
 */
@Entity
@Data
public class User extends AbstractEntity implements UserDetails {

    @Column(unique = true)
    private String username;

    private String nickname;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    /**
     * 是否锁定，1-是，0-否
     */
    private Boolean locked = false;

    /**
     * 是否可用，1-是，0-否
     */
    private Boolean enabled = true;

    private String lastLoginIp;

    private Date lastLoginTime;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getEnabled();
    }
}
