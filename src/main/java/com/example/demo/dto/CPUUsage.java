package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CPUUsage{
    long logTime;
    BigDecimal CPUUSAGE;
}

