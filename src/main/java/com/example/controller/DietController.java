package com.example.controller;

import com.example.exception.DietTypeNotFoundException;
import com.example.pojo.Diet;
import com.example.pojo.Food;
import com.example.pojo.Result;
import com.example.service.DietService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/diet")
public class DietController {
    @Autowired
    private DietService dietService;

    @PostMapping("/add")
    public Result add(Diet diet,HttpServletRequest request) throws DietTypeNotFoundException {
        log.info("增添用户记录");
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        //Integer userId = diet.getUserId();
        if (userId == null) {
            // 如果无法获取用户 ID，返回错误信息
            return Result.error("User ID not found in session");
        }
        diet.setUserId(userId);
        dietService.add(diet);
        return Result.success(diet);
    }

    @GetMapping("/list")
    public Result list(HttpServletRequest request){
        log.info("查看该条记录");
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId == null) {
            return Result.error("User ID not found in session");
        }
        List<Diet> list = dietService.list(userId);
        return Result.success(list);

    }

    @DeleteMapping("/clean")
    public Result clean(Diet diet, HttpServletRequest request) throws DietTypeNotFoundException {
        log.info("删除用户记录");
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId == null) {
            // 如果无法获取用户 ID，返回错误信息
            return Result.error("User ID not found in session");
        }
        diet.setUserId(userId);
        dietService.clean(diet);
        return Result.success(diet);
    }

}
