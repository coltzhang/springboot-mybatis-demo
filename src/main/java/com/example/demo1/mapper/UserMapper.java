package com.example.demo1.mapper;

import com.example.demo1.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User query(Integer id);

    public void insert(User user);

    public void update(User user);

    public void delete(Integer id);
}
