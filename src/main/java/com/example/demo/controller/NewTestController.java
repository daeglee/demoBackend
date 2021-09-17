package com.example.demo.controller;

import com.example.demo.DateType;
import com.example.demo.dto.CPUUsage;
import com.example.demo.dto.MemoryUsage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;

@RestController
@Slf4j
@RequestMapping("/api")
public class NewTestController {

    @GetMapping("/cpu/{startTime}/{endTime}")
    public ArrayList<CPUUsage> getCPUUsage(@PathVariable long startTime, @PathVariable long endTime,
                                           @RequestParam(value = "type") DateType dateType){

        ArrayList<CPUUsage> cpuUsages = new ArrayList<>();

        int dataInterval = 1;

        // 결국 dateType에 따라
        // 다른 테이블을 선택해야함
        // 하지만 여기서는
        // 임시적으로 데이터를 생성함
        switch (dateType){
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

        for (long i = startTime; i<=endTime; i+= dataInterval){
            CPUUsage cpuUsage = new CPUUsage();
            cpuUsage.setCPUUSAGE(BigDecimal.valueOf((int)(Math.random() * 100)));
            cpuUsage.setLogTime(i);
            cpuUsages.add(cpuUsage);
        }
        return cpuUsages;
    }



    @GetMapping("/memory/{startTime}/{endTime}")
    public ArrayList<MemoryUsage> getMemoryUsages(@PathVariable long startTime, @PathVariable long endTime,
                                                  @RequestParam(value = "type") DateType dateType){

        ArrayList<MemoryUsage> memoryUsages = new ArrayList<>();

        int dataInterval = 1;

        // 결국 dateType에 따라
        // 다른 테이블을 선택해야함
        // 하지만 여기서는
        // 임시적으로 데이터를 생성함
        switch (dateType){
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
        for (long i = startTime; i<=endTime; i+= dataInterval){
            MemoryUsage memoryUsage = new MemoryUsage();
            memoryUsage.setMemoryUsage(BigDecimal.valueOf((int)(Math.random() * 100)));
            memoryUsage.setLogTime(i);
            memoryUsages.add(memoryUsage);
        }
        return memoryUsages;
    }

}
