package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "email")
public class Email implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String aname;
    private  String sname;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sdate;//发送时间
}
