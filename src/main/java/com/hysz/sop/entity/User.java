package com.hysz.sop.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Integer userId;
    private String userName;
    private String password;
    private Integer groupId;
    private Integer roleId;

    public User() {
    }

    public User(Integer userId, String userName, String password, Integer groupId, Integer roleId) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.groupId = groupId;
        this.roleId = roleId;
    }
}
