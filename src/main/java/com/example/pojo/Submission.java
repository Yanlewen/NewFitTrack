package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Submission {
    private Integer id;
    private Integer userId;
    private LocalDateTime submissionTime;
    private BigDecimal calories;

}
