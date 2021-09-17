package com.example.demo.frontConfig;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrontConfigRepository extends JpaRepository<ChartInfo, Long> {

}
