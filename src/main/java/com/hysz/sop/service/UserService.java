package com.hysz.sop.service;

import com.hysz.sop.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);
    List<User> getUsers();
    Integer getUserCount();
    Integer addUser(User user);
    Integer removeUser(Integer id);
    Integer updateUser(User user);
}