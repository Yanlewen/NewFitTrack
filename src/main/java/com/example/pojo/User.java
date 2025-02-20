package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //用户ID
    private Integer id;

    //姓名
    private String username;

    //密码
    private String password;

    //性别 0 女 1 男
    private String gender;

    //年龄
    private Integer age;

    //头像
    private String image;

    //创建时间
    private LocalDateTime createTime;

    //更新时间
    private LocalDateTime updateTime;


}
