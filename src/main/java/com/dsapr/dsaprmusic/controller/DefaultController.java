package com.dsapr.dsaprmusic.controller;

import com.dsapr.dsaprmusic.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class DefaultController {

    @GetMapping
    public String sayHello() {
        User user = new User();
        user.hashCode();
        return "欢迎来到音乐盒！";
    }

}
