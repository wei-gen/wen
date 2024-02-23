package com.example.wenmanager.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@TableName("w_book")
public class Book {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private List<String> images;
    private String description;
    @TableField(value = "is_delete", fill = FieldFill.INSERT)
    private Integer isDelete;
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
