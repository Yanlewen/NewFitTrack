package com.example.service.impl;

import com.example.exception.SubmissionException;
import com.example.mapper.DietMapper;
import com.example.mapper.SubmissionDetailsMapper;
import com.example.mapper.SubmissionMapper;
import com.example.pojo.Diet;
import com.example.pojo.Submission;
import com.example.pojo.SubmissionDetails;
import com.example.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class SubmissionServiceImpl implements SubmissionService {

        @Autowired
        private SubmissionMapper submissionMapper;
        @Autowired
        private DietMapper dietMapper;
        @Autowired
        private SubmissionDetailsMapper submissionDetailsMapper;


        @Override
        @Transactional
        public void submit(Submission submission) {
            Integer userId = submission.getUserId();
            submission.setSubmissionTime(LocalDateTime.now());


            submissionMapper.insert(submission);

            Integer submissionId = submission.getId();//订单号


            List<Diet> diet = dietMapper.list(userId);
            if(diet == null || diet.size() == 0){
                try {
                    throw new SubmissionException("购物车为空,不能显示本次饮食");
                } catch (SubmissionException e) {
                    throw new RuntimeException(e);
                }
            }
            AtomicLong calories = new AtomicLong(0);
            List<SubmissionDetails> submissionDetails = diet.stream().map((item)->{
                SubmissionDetails submissionDetail = new SubmissionDetails();
                submissionDetail.setUserId(userId);
                submissionDetail.setSubmissionId(submissionId);
                submissionDetail.setFoodId(item.getFoodId());
                submissionDetail.setCalories(item.getCalories());
                BigDecimal calorieIncrement = item.getWeight().multiply(
                        item.getCalories()).divide(BigDecimal.valueOf(100));
                long calorieIncrementAsLong = calorieIncrement.longValue();
                calories.addAndGet(calorieIncrementAsLong);
                return submissionDetail;
            }).collect(Collectors.toList());

            submission.setCalories(new BigDecimal(calories.get()));//计算总卡路里
            submissionMapper.insert(submission);
            submissionMapper.insert(submission);
            submissionDetailsMapper.insert(submissionDetails);

            dietMapper.removeByUserId(userId);

        }





}
