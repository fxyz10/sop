package com.hysz.sop.controller;

import com.hysz.sop.common.CheckInterface;
import com.hysz.sop.entity.User;
import com.hysz.sop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(value = "/get/{id}")
    public User getUserById(@PathVariable Integer id) {
        return service.getUserById(id);
    }

    @PostMapping(value = "/count")
    public int getUserCount() {
        return service.getUserCount();
    }

    @PostMapping(value = "/list")
    public List<User> getUsers() {
        return service.getUsers();
    }

    @PostMapping(value = "/add")
    public String addUser(@RequestBody @Validated(CheckInterface.Add.class) User user, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError oe : result.getAllErrors()) {
                System.out.println(oe.getDefaultMessage());
            }
            System.out.println("===");
        }
        int res = service.addUser(user);
        System.out.println(res);
        return "insert user";
    }

    @PostMapping(value = "/remove/{id}")
    public String removeUser(@PathVariable Integer id) {
        int res = service.removeUser(id);
        System.out.println(res);
        return "remove user";
    }

    @PostMapping(value = "/update")
    public String updateUser(@RequestBody @Validated(CheckInterface.Update.class) User user, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError oe : result.getAllErrors()) {
                System.out.println(oe.getDefaultMessage());
            }
        }
        int res = service.updateUser(user);
        System.out.println(res);
        return "update user";
    }
}
