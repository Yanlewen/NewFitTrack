package com.example.service.impl;

import com.example.mapper.FoodMapper;
import com.example.pojo.Food;
import com.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public Food getById(int id) {
        return foodMapper.getById(id);
    }
}
