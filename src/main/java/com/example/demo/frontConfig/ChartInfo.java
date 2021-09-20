package com.example.demo.frontConfig;

import com.example.demo.type.ChartType;
import com.example.demo.type.DateType;
import com.example.demo.type.RawDataType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "charts")
@AllArgsConstructor
@NoArgsConstructor
public class ChartInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int x;
    private int y;
    private String height;
    private String width;
    private DateType dateType;
    private ChartType chartType;
    private RawDataType rawDataType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public DateType getDateType() {
        return dateType;
    }

    public void setDateType(DateType dateType) {
        this.dateType = dateType;
    }

    public ChartType getChartType() {
        return chartType;
    }

    public void setChartType(ChartType chartType) {
        this.chartType = chartType;
    }

    public RawDataType getRawDataType() {
        return rawDataType;
    }

    public void setRawDataType(RawDataType rawDataType) {
        this.rawDataType = rawDataType;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }
}
