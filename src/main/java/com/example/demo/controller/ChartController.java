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

    /**
     * 조회기능
     */

    @GetMapping("list")
    public List<ChartInfo> getChartLists() {
        return configService.findAll();
    }

    /**
     * Save 기능
     */
    @PostMapping("list/save")
    public void updateChartLists(@RequestBody List<ChartInfo> chartInfos) {

        for (ChartInfo chartInfo : chartInfos) {
            configService.updateById(chartInfo.getId(), chartInfo);
        }

    }

    /**
     * 차트 하나의 정보?
     * 사용되지않는 기능
     */
    @GetMapping("{id}")
    public ChartInfo getChart(@PathVariable Long id) {
        return configService.findById(id);
    }

    /**
     * Delete 기능
     */
    @DeleteMapping("{id}")
    public ChartInfo DeleteChart(@PathVariable Long id, ChartInfo chartInfo) {
        return configService.updateById(id, chartInfo);
    }

    /**
     * Edit 기능
     */
    @PutMapping("{id}")
    public ChartInfo updateChart(@PathVariable Long id, ChartInfo chartInfo) {
        return configService.updateById(id, chartInfo);
    }

    /**
     * Create 기능
     * 하나의 차트를 추가함
     * 하지만 결국 'Save' 버튼을 누름으로 저장되니까 실제로는 사용되지 않은 기능이라고 할 수 있음
     */
    @PostMapping("save")
    public ChartInfo save(@RequestBody ChartInfo chartInfo) {
        return configService.save(chartInfo);
    }

}
