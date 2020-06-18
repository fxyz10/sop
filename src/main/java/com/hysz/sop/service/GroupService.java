package com.hysz.sop.service;

import com.hysz.sop.entity.Group;

import java.util.List;

public interface GroupService {

    Group getGroupById(Integer id);
    Integer getGroupCount();
    List<Group> getGroups();
    Integer addGroup(Group group);
    Integer removeGroup(Integer id);
    Integer updateGroup(Group group);
}
