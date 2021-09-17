package com.example.demo.frontConfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FrontConfigServiceTest {

    @Autowired
    private FrontConfigService frontConfigService;
    @Test
    void findAll() {

        List<ChartInfo> all = frontConfigService.findAll();


    }

    @Test
    void findById() {
    }
}