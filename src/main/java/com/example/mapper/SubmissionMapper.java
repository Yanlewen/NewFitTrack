package com.example.mapper;

import com.example.pojo.Submission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubmissionMapper {
    @Insert("insert into fittrack_submission (user_id, submission_time,calories) " +
            "values (#{userId},#{submissionTime},#{calories})")
    void insert(Submission submission);
}
