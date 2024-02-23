package com.example.wenmanager.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("w_user")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String openId;
    private String vxName;
    private String avatar;
    @TableField(value = "is_delete", fill = FieldFill.INSERT)
    private Integer isDelete;
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
