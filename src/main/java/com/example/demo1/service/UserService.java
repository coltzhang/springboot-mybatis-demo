package com.example.demo1.service;

import com.example.demo1.entity.User;
import com.example.demo1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    @Autowired
    private UserMapper userMapper;

    public User query(Integer id) {
        return userMapper.query(id);
    }

    public void insert(User user) {
        userMapper.insert(user);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void delete(Integer id) {
        userMapper.delete(id);
    }
}
