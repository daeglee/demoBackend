package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MemoryUsage{
    long logTime;
    BigDecimal memoryUsage;
}
