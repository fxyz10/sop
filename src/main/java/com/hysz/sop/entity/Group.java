package com.hysz.sop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@TableName(value = "tb_group")
public class Group {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "group_name")
    private String name;
    private String info;
    @TableField(value = "number_of_people")
    private Integer count;
    @TableField(value = "foundation_date")
    private Timestamp foundationDate;
    @TableField(value = "close_date")
    private Date closeDate;

}
