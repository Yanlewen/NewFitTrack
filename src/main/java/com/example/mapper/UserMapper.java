package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from fittrack_user Where username = #{username} and password = #{password}")
    User getPasswordAndUsername(User user);

    @Insert("insert into fittrack_user(username,password,create_time,update_time)" +
            "values(#{username},#{password},#{createTime},#{updateTime})")
    int insert(User user);
}
