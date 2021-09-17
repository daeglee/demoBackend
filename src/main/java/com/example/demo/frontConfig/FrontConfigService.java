package com.example.demo.frontConfig;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FrontConfigService {

    private FrontConfigRepository repository;

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
        Optional<ChartInfo> chart = repository.findById(chartNo);
        if (chart.isPresent()) {
            chart.get().setChartType(chartInfo.getChartType());
            chart.get().setRawDataType(chartInfo.getRawDataType());
            chart.get().setDateType(chartInfo.getDateType());
            chart.get().setHeight(chartInfo.getHeight());
            chart.get().setWidth(chartInfo.getWidth());
            chart.get().setX(chartInfo.getX());
            chart.get().setY(chartInfo.getY());
            repository.save(chart.get());

            return chart.get();
        }
        return null;
    }

    public ChartInfo save(ChartInfo chartInfo) {
        repository.save(chartInfo);
        return chartInfo;
    }
}
