package com.example.mapper;

import com.example.pojo.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FoodMapper {
    @Select("select * from fittrack_food Where id = #{id}")
    Food getById(int id);
}
