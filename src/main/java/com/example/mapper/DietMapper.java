package com.example.mapper;

import com.example.pojo.Diet;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DietMapper {
    @Select("select * from fittrack_diet where user_id = #{userId} and food_id = #{foodId};")
    Diet getByUserIdAndFoodId(long userId, long foodId);

    @Update("update fittrack_diet set weight = #{weight} where id = #{id}")
    void update(Diet dietRecord);

    @Insert("insert into fittrack_diet(user_id, food_id, weight,calories, create_time) " +
            "values (#{userId},#{foodId},#{weight},#{calories},#{createTime})")
    void insert(Diet diet);

    @Delete("delete from fittrack_diet where user_id = #{userId}")
    void delete(Diet diet);

    @Select("select * from fittrack_diet where user_id = #{userId};")
    List<Diet> getByUserId(Integer userId);

    @Select("select * from fittrack_diet where user_id = #{userId};")
    List<Diet> list(Integer userId);

    @Delete("delete from fittrack_diet where user_id = #{userId}")
    void removeByUserId(Integer userId);
}
