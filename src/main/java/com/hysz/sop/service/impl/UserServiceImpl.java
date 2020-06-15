package com.hysz.sop.service.impl;

import com.hysz.sop.entity.User;
import com.hysz.sop.mapper.UserMapper;
import com.hysz.sop.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper mapper;

    @Override
    public User getUserById(Integer id) {
        return mapper.getUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return mapper.getUsers();
    }

    @Override
    public Integer getUserCount() {
        return mapper.getUserCount();
    }

    @Override
    public Integer addUser(User user) {
        return mapper.addUser(user);
    }

    @Override
    public Integer removeUser(Integer id) {
        return mapper.removeUser(id);
    }

    @Override
    public Integer updateUser(User user) {
        return mapper.updateUser(user);
    }
}
