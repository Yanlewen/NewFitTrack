package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionDetails {
    private Integer id;
    private String name;
    private Integer userId;
    private Integer submissionId;
    private Integer foodId;
    private BigDecimal weight;
    private String image;
    private BigDecimal calories;


}
