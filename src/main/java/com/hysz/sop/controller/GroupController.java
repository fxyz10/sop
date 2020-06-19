package com.hysz.sop.controller;

import com.hysz.sop.entity.Group;
import com.hysz.sop.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/group")
public class GroupController {

    @Autowired
    private GroupService service;

    @PostMapping(value = "/get/{id}")
    public Group getUserById(@PathVariable Integer id) {
        Group group = service.getGroupById(id);
        Assert.notNull(group, "组不存在");
        return group;
    }

    @PostMapping(value = "/count")
    public int getUserCount() {
        return service.getGroupCount();
    }

    @PostMapping(value = "/list")
    public List<Group> getUsers() {
        return service.getGroups();
    }

    @PostMapping(value = "/add")
    public String addUser(@RequestBody Group group) {

        int res = service.addGroup(group);
        System.out.println(res);
        return "insert group";
    }

    @PostMapping(value = "/update")
    public String updateGroup(@RequestBody Group group) {
        int res = service.updateGroup(group);
        System.out.println(res);
        return "update group";
    }

    @PostMapping(value = "/remove/{id}")
    public String removeGroup(@PathVariable Integer id) {
        int res = service.removeGroup(id);
        System.out.println(res);
        return "remove group";
    }
}
