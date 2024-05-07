package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diet {
    private Integer id;
    private Integer userId;
    private Integer foodId;
    private String username;
    private BigDecimal weight;
    private BigDecimal calories;
    private LocalDateTime createTime;
}
