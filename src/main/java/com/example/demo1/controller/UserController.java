package com.example.demo1.controller;

import com.example.demo1.entity.User;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    Car car;

    @GetMapping("control")
    public String control() {
        return "control";
    }

    @GetMapping("hello")
    public Map<String, Object> hello() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "zhangsan");
        map.put("car", car);
        car.drive();
        return map;
    }

    @ResponseBody
    @GetMapping("list")
    public List<User> list() {
        User user1 = new User();
        user1.setUserName("zhangsan");
        User user2 = new User();
        user2.setUserName("lisi");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        return list;
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
