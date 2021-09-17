package com.example.demo.controller;

import com.example.demo.frontConfig.ChartInfo;
import com.example.demo.frontConfig.FrontConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/chart/")
public class ChartController {

    private final FrontConfigService configService;

    @GetMapping("list")
    public List<ChartInfo> getChartLists(){
        log.info("haha");
        return configService.findAll();
    }

    @GetMapping("{id}")
    public ChartInfo getChart(@PathVariable Long id){
        return configService.findById(id);
    }
    @DeleteMapping("{id}")
    public ChartInfo DeleteChart(@PathVariable Long id, ChartInfo chartInfo){
        return configService.updateById(id, chartInfo);
    }
    @PutMapping("{id}")
    public ChartInfo updateChart(@PathVariable Long id, ChartInfo chartInfo){
        return configService.updateById(id, chartInfo);
    }

    @PostMapping
    public ChartInfo save(ChartInfo chartInfo){
        return configService.save(chartInfo);
    }

}
