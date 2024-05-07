package com.example.service.impl;

import com.example.exception.DietTypeNotFoundException;
import com.example.mapper.DietMapper;
import com.example.pojo.Diet;
import com.example.pojo.Food;
import com.example.service.DietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DietServiceImpl implements DietService {

    @Autowired
    private DietMapper dietMapper;

    @Override
    public void add(Diet diet) {
        diet.setCreateTime(LocalDateTime.now());
        //查询当前选择的食物是否在我的”购物车“中
        long foodId = diet.getFoodId();
        long userId = diet.getUserId();
        Diet dietRecord = dietMapper.getByUserIdAndFoodId(userId, foodId);
        //如果已经存在，就在原来那个重量quantity上更改
        if (dietRecord != null) {
            // 如果已经存在，就直接更改
            BigDecimal originalWeight = dietRecord.getWeight();
            BigDecimal newWeight = originalWeight.add(diet.getWeight());
            dietRecord.setWeight(newWeight);
            dietMapper.update(dietRecord);
        } else {
            // 如果不存在，则添加到购物车, 重量 quantity 不改变
            dietMapper.insert(diet);
            dietRecord = diet;
        }
    }

    @Override
    public List<Diet> list(Integer userId) {
        return dietMapper.getByUserId(userId);
    }

    @Override
    public void clean(Diet diet) {
        dietMapper.delete(diet);

    }


}
