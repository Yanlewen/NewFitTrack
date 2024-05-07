package com.example.service;

import com.example.pojo.Diet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DietService {
    void add(Diet diet);

    void clean(Diet diet);

    List<Diet> list(Integer userId);
}
