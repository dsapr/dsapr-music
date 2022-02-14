package com.dsapr.dsaprmusic.repository;

import com.dsapr.dsaprmusic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/10 16:49
 */
public interface UserRepository extends JpaRepository<User, String>{
    User getByUsername(String username);
    User getByUsernameAndNickname(String username, String nickname);

    Optional<User> findByUsername(String username);
}
