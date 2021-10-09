package com.example.demo.frontConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class FrontConfigService {

    private final FrontConfigRepository repository;
    private final ResourceRepository resourceRepository;

    public List<ChartInfo> findAll() {
        return repository.findAll();
    }

    public ChartInfo findById(Long chartNo) {
        return repository.getById(chartNo);
    }

    public void deleteById(Long chartNo) {
        repository.deleteById(chartNo);
    }

    public ChartInfo updateById(Long chartNo,ChartInfo chartInfo) {
        ArrayList<Resource> resources = new ArrayList<>();
        for (Resource resource : chartInfo.getResourceList()) {
            Optional<Resource> resourceOptional = resourceRepository.findById(resource.getId());
            resourceOptional.ifPresent(resources::add);
        }
        
        Optional<ChartInfo> chart = repository.findById(chartNo);
        if (chart.isPresent()) {
            chart.get().setChartType(chartInfo.getChartType());
            chart.get().setRawDataType(chartInfo.getRawDataType());
            chart.get().setDateType(chartInfo.getDateType());
            chart.get().setHeight(chartInfo.getHeight());
            chart.get().setWidth(chartInfo.getWidth());
            chart.get().setX(chartInfo.getX());
            chart.get().setY(chartInfo.getY());
            chart.get().setResourceList(resources);
            repository.save(chart.get());

            return chart.get();
        } else {
            ChartInfo chartInfoNew = new ChartInfo();
            chartInfoNew.setChartType(chartInfo.getChartType());
            chartInfoNew.setRawDataType(chartInfo.getRawDataType());
            chartInfoNew.setDateType(chartInfo.getDateType());
            chartInfoNew.setX(chartInfo.getX());
            chartInfoNew.setY(chartInfo.getY());
            chartInfoNew.setHeight(chartInfo.getHeight());
            chartInfoNew.setWidth(chartInfo.getWidth());
            chartInfoNew.setResourceList(resources);
            repository.save(chartInfoNew);
        }
        return null;
    }

    public ChartInfo save(ChartInfo chartInfo) {
        log.info("ChartInfo save(ChartInfo chartInfo)");
        repository.save(chartInfo);
        log.info("ChartInfo save(ChartInfo chartInfo)2");
        return chartInfo;
    }
}
