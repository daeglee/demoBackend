package com.example.demo.controller;

import com.example.demo.frontConfig.Resource;
import com.example.demo.frontConfig.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/resource/")
public class TempResourceController {

    private final ResourceService resourceService;


    @GetMapping("list")
    public List<Resource> getResourceLists() {
        return resourceService.findAll();
    }
}
