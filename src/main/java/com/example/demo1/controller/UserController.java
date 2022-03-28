package com.example.demo1.controller;

import com.example.demo1.entity.User;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("hello")
    public String hellp() {
        return "hello";
    }

    @GetMapping("query")
    public User query(Integer id) {
        return userService.query(id);
    }

    @GetMapping("insert")
    public void insert() {
        User user = new User();
        user.setUserName("王五");
        user.setPassword("123456");
        user.setPhoneNumber("xxxx");
        userService.insert(user);
    }

    @GetMapping("update")
    public void update() {
        User user = new User();
        user.setId(1);
        user.setUserName("张三");
        user.setPassword("123456");
        user.setPhoneNumber("xxxx");
        userService.update(user);
    }

    @GetMapping("delete")
    public void delete(Integer id) {
        userService.delete(id);
    }


}
