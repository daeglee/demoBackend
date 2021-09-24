package com.example.demo.frontConfig;

import com.example.demo.type.ChartType;
import com.example.demo.type.DateType;
import com.example.demo.type.RawDataType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestDataInit {
    private final FrontConfigRepository repository;
    private final ResourceRepository resourceRepository;

    @PostConstruct
    public void init() {
        log.info("init ----");
        Resource resource0 = new Resource();
        resource0.setResource("R000");


        Resource resource1 = new Resource();
        resource1.setResource("R001");

        ArrayList<Resource> resources = new ArrayList<>();
        resourceRepository.save(resource0);
        resourceRepository.save(resource1);
        resources.add(resource0);
        resources.add(resource1);


        ChartInfo chartInfo = new ChartInfo();
        chartInfo.setX((int)(Math.random() * 100));
        chartInfo.setY((int)(Math.random() * 100));
        chartInfo.setWidth("400");
        chartInfo.setHeight("400");
        chartInfo.setDateType(DateType.second);
        chartInfo.setChartType(ChartType.area);
        chartInfo.setRawDataType(RawDataType.cpu);
        chartInfo.setResourceList(resources);

        ChartInfo chartInfo2 = new ChartInfo();
        chartInfo2.setX((int)(Math.random() * 100)+ 600);
        chartInfo2.setY((int)(Math.random() * 100) +600);
        chartInfo2.setWidth("500");
        chartInfo2.setHeight("500");
        chartInfo2.setDateType(DateType.minute);
        chartInfo2.setChartType(ChartType.bar);
        chartInfo2.setRawDataType(RawDataType.memory);
        chartInfo2.setResourceList(resources);

        repository.save(chartInfo);
        repository.save(chartInfo2);
        log.info("saved ----");
        log.info("chartInfo 1 {}" , repository.findAll());
    }
}