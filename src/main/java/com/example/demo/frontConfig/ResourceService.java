package com.example.demo.frontConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceRepository repository;

    public List<Resource> findAll() {
        return repository.findAll();
    }

    public Resource findById(Long chartNo) {
        return repository.getById(chartNo);
    }

    public void deleteById(Long chartNo) {
        repository.deleteById(chartNo);
    }

    public Resource save(Resource resource){
        repository.save(resource);
        return resource;
    }
}
