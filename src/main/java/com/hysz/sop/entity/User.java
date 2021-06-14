package com.hysz.sop.entity;

import com.hysz.sop.common.Add;
import com.hysz.sop.common.CheckInterface;
import com.hysz.sop.common.Update;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
// https://blog.csdn.net/justry_deng/article/details/86571671
// https://blog.csdn.net/weixin_35977449/article/details/112142912 check enum
// https://blog.csdn.net/weixin_43874301/article/details/102604869 嵌套校验
// https://blog.csdn.net/lp840312696/article/details/105530593 统一处理异常
// https://segmentfault.com/q/1010000019712182/a-1020000019715839 not in controller
public class User {

    @NotNull(message = "userId not be blank", groups = CheckInterface.Update.class)
    private Integer userId;
    @NotBlank(message = "userName not be blank", groups = CheckInterface.Add.class)
    private String userName;
    @NotEmpty(message = "pwd not be empty", groups = Add.class)
    @Length(min = 5, message = "pwd too short", groups = Add.class)
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
