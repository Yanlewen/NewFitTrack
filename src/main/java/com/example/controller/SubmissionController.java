package com.example.controller;

import com.example.pojo.Result;
import com.example.pojo.Submission;
import com.example.service.SubmissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/dietorder")

public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;
    @PostMapping("/submit")
    public Result submit(@RequestBody Submission submission, HttpServletRequest request){
        log.info("提交数据：{}",submission);
        Integer  userId = (Integer) request.getSession().getAttribute("userId");
        submission.setUserId(userId);
        submissionService.submit(submission);
        return Result.success();
    }

}
