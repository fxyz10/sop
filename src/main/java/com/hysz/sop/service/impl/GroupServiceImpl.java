package com.hysz.sop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hysz.sop.entity.Group;
import com.hysz.sop.mapper.GroupDao;
import com.hysz.sop.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GroupServiceImpl implements GroupService {

    private GroupDao dao;

    @Autowired
    public void setDao(GroupDao dao) {
        this.dao = dao;
    }

    @Override
    public Group getGroupById(Integer id) {
        return dao.selectById(id);
    }

    @Override
    public Integer getGroupCount() {
        return dao.selectCount(new QueryWrapper<>());
    }

    @Override
    public List<Group> getGroups() {
        return dao.selectList(new QueryWrapper<>());
    }

    @Override
    public Integer addGroup(Group group) {
        return dao.insert(group);
    }

    @Override
    public Integer removeGroup(Integer id) {
        return dao.deleteById(id);
    }

    @Override
    public Integer updateGroup(Group group) {
        QueryWrapper<Group> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", group.getId());
        return dao.update(group, queryWrapper);
    }


}
