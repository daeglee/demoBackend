package com.example.demo.frontConfig;

import com.example.demo.DateType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "chart")
@AllArgsConstructor
@NoArgsConstructor
public class ChartInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private int x;
    @NotNull
    private int y;
    @NotNull
    private int height;
    @NotNull
    private int width;
    @NotNull
    private DateType dateType;
    @NotNull
    private String chartType;
    @NotNull
    private String rawDataType;

}
