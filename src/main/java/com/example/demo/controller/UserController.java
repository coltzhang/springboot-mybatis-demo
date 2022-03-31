package com.example.demo.controller;

import com.example.demo.common.Log;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("car", car);
        car.drive();
        return map;
    }

    // @ResponseBody
    @Log("自定义日志注解")
    @GetMapping("list")
    public List<User> list() throws NoSuchMethodException {
        //获取注解参数
        // 1.类的注解
        RequestMapping annRequestMapping = UserController.class.getAnnotation(RequestMapping.class);
        System.out.println("UserController annotation:" + annRequestMapping.toString());
        for (String str: annRequestMapping.value()) {
            System.out.println("UserController annotation value:" + str);
        }

        // 2.方法的注解
        try {
            Method method = UserController.class.getDeclaredMethod("list");
            if (method != null ) {
                Annotation[] ans = method.getAnnotations();
                for (int i = 0; i < ans.length; i++) {
                    System.out.println("list annotation:" + ans[i].annotationType().getSimpleName() + " " + ans[i].toString());
                }
                Log annLog = method.getAnnotation(Log.class);
                System.out.println("list annotation:" + annLog.annotationType().getSimpleName() + " " + annLog.toString()
                        + " value:" + annLog.value());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

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
