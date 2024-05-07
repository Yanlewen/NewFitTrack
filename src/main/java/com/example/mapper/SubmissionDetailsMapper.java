package com.example.mapper;

import com.example.pojo.SubmissionDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubmissionDetailsMapper {
    @Insert("insert into fittrack_submission_details(" +
            " user_id, submission_id, food_id, weight, calories) " +
            "values (#{userId},#{submissionId},#{foodId},#{weight},#{calories})")
    void insert(List<SubmissionDetails> submissionDetails);
}
