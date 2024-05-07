package com.example.controller;

import com.example.pojo.Food;
import com.example.pojo.Result;
import com.example.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;
    @GetMapping("/{id}")
    public Result get(@PathVariable int id){

        Food food = foodService.getById(id);

        return Result.success(food);
    }


}
