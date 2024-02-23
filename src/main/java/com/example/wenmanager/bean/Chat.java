package com.example.wenmanager.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@TableName("w_chat")
public class Chat {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer sendId;
    private Integer acceptId;
    private String content;
    @TableField(value = "is_delete", fill = FieldFill.INSERT)
    private Integer isDelete;
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //聊天框会发送最新聊天的那条记录，根据这个id查找后面的新聊天记录给用户
    @TableField(exist = false)
    private Integer nowId;
}
