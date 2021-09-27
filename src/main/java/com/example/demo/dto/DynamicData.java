package com.example.demo.dto;

import lombok.Data;

import java.util.Map;

@Data
public class DynamicData {
    private long logTime;
    private Map<String, Object> dataMap;
}
