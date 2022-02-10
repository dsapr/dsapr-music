package com.dsapr.dsaprmusic.repository;

import com.dsapr.dsaprmusic.entity.User;
import com.dsapr.dsaprmusic.enums.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/10 17:04
 */
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void findByUsername() {
        User user = new User();
        user.setUsername("dsapr");
        user.setNickname("辰怡");
        user.setEnabled(true);
        user.setLocked(false);
        user.setPassword("879993");
        user.setGender(Gender.MALE);
        user.setLastLoginTime(new Date());

        User savedUser = repository.save(user);
        System.out.println("savedUser = " + savedUser);

//        repository.findByUsername(user.getUsername()).stream().forEach(System.out::println);
    }
}