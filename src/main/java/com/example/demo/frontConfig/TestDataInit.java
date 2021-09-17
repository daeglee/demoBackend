package com.example.demo.frontConfig;

import com.example.demo.DateType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestDataInit {
    private final FrontConfigRepository repository;

    @PostConstruct
    public void init() {
        log.info("init ----");

        ChartInfo chartInfo = new ChartInfo();
        chartInfo.setX((int)(Math.random() * 100));
        chartInfo.setY((int)(Math.random() * 100));
        chartInfo.setWidth(400);
        chartInfo.setHeight(400);
        chartInfo.setDateType(DateType.second);
        chartInfo.setChartType("area");
        chartInfo.setRawDataType("cpu");

        ChartInfo chartInfo2 = new ChartInfo();
        chartInfo2.setX((int)(Math.random() * 100));
        chartInfo2.setY((int)(Math.random() * 100) +600);
        chartInfo2.setWidth(500);
        chartInfo2.setHeight(500);
        chartInfo2.setDateType(DateType.minute);
        chartInfo2.setChartType("bar");
        chartInfo2.setRawDataType("memory");
        repository.save(chartInfo);
        repository.save(chartInfo2);
        log.info("saved ----");
        log.info("chartInfo 1 {}" , repository.findAll());
    }
}