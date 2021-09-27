package com.example.demo.controller;

import com.example.demo.dto.DynamicData;
import com.example.demo.type.DateType;
import com.example.demo.dto.CPUUsage;
import com.example.demo.dto.MemoryUsage;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/api")
public class NewTestController {


    private int calculateDataInterval(DateType dateType) {
        int dataInterval = 1;

        // 결국 dateType에 따라
        // 다른 테이블을 선택해야함
        // 하지만 여기서는
        // 임시적으로 데이터를 생성함
        switch (dateType) {
            case second:
                break;
            case month:
                dataInterval *= 12;
            case day:
                dataInterval *= 24;
            case hour:
                dataInterval *= 60;
            case minute:
                dataInterval *= 60;
        }
        return dataInterval;
    }

    private long calculateStartTime(long startTime, int dataInterval) {
        if (startTime % dataInterval > 0) {
            startTime = (((long) (startTime / dataInterval) + 1) * dataInterval);
        }
        return startTime;
    }

    @GetMapping("/cpu/{startTime}/{endTime}/{dateType}")
    public String getCPUUsage(@PathVariable long startTime, @PathVariable long endTime,
                                           @PathVariable DateType dateType, @RequestParam(value = "resources") ArrayList<String> resources) {

        JSONArray result = new JSONArray();

        int dataInterval = calculateDataInterval(dateType);

        startTime = calculateStartTime(startTime, dataInterval);


        for (long i = startTime; i <= endTime; i += dataInterval) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("logTime", i);
            for (String resource : resources) {
                jsonObject.put(resource, BigDecimal.valueOf((int) (Math.random() * 100)));
            }
            result.put(jsonObject);
        }

        return result.toString();
    }

    @GetMapping("/memory/{startTime}/{endTime}/{dateType}")
    public String getMemoryUsage(@PathVariable long startTime, @PathVariable long endTime,
                              @PathVariable DateType dateType, @RequestParam(value = "resources") ArrayList<String> resources) {

        JSONArray result = new JSONArray();

        int dataInterval = calculateDataInterval(dateType);

        startTime = calculateStartTime(startTime, dataInterval);


        for (long i = startTime; i <= endTime; i += dataInterval) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("logTime", i);
            for (String resource : resources) {
                jsonObject.put(resource, BigDecimal.valueOf((int) (Math.random() * 100)));
            }
            result.put(jsonObject);
        }

        return result.toString();
    }

}
