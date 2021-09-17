//package com.example.demo.controller;
//
//import com.example.demo.dto.CPUUsage;
//import com.example.demo.dto.MemoryUsage;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.ArrayList;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//public class TestController {
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//    // 처음 받아올 데이터의 개수
//    // 만약 20개라고 하면
//    // 가장 최신값부터 총 20개의
//    // 값을 받아옴
//    @GetMapping(value = "/api/cpu/list/{listSize}", produces = "application/json")
//    public ArrayList<CPUUsage>  firstData(@PathVariable int listSize) throws IOException {
//
//        ArrayList<CPUUsage> cpuUsages = new ArrayList<>();
//        // 임시로 받은 number에 해당하는 값을 생성
//        // 현재 시간의 logTime에 해당하는 값부터 20
//        long currentTime = Instant.now().truncatedTo(ChronoUnit.SECONDS).getEpochSecond();
//
//        for (int i =0 ;i< listSize; i++){
//            CPUUsage cpuUsage = new CPUUsage();
//            cpuUsage.setCPUUSAGE(BigDecimal.valueOf((int)(Math.random() * 100)));
//            cpuUsage.setLogTime(currentTime - listSize + i + 1);
//
//            cpuUsages.add(cpuUsage);
//        }
////        objectMapper.writeValue(outputStream, cpuUsages);
//
////        return new String(outputStream.toString());
//    return cpuUsages;
//    }
//
//    @GetMapping(value = "/api/memory/list/{listSize}", produces = "application/json")
//    public ArrayList<MemoryUsage>  memoryFirstData(@PathVariable int listSize) throws IOException {
//
//        ArrayList<MemoryUsage> memoryUsages= new ArrayList<>();
//        long currentTime = Instant.now().truncatedTo(ChronoUnit.SECONDS).getEpochSecond();
//
//        for (int i =0 ;i< listSize; i++){
//            MemoryUsage memoryUsage = new MemoryUsage();
//            memoryUsage.setMemoryUsage(BigDecimal.valueOf((int)(Math.random() * 100)));
//            memoryUsage.setLogTime(currentTime - listSize + i + 1);
//
//            memoryUsages.add(memoryUsage);
//        }
//        return memoryUsages;
//    }
//
//
//    // logTime을 입력받으면, 그것에 해당하는 값을 돌려줌
//    // 실제 애플리케이션에서는 정밀한 테스트가 필요함
//    // 시나리오:
//    // 처음 20개의 데이터를 받은후, 가장 최신의 logTime을 프론트 서버에서 기록함
//    // 가장 최근의 LogTime에 해당하는 값에서 +1한 값을
//    // 백엔드 서버에 보냄
//    // 그렇게 1씩 값을 증가한 값을 보냄
//    @GetMapping(value = "/api/cpu/time/{logTime}", produces = "application/json")
//    public CPUUsage singleData(@PathVariable long logTime) throws IOException {
//        log.info("singleData logTime :[{}]", logTime);
//        CPUUsage cpuUsage = new CPUUsage();
//        cpuUsage.setCPUUSAGE(BigDecimal.valueOf((int)(Math.random() * 100)));
//        cpuUsage.setLogTime(logTime + 1L);
//        return cpuUsage;
//    }
//
//    // 1 = cpu usage, 2 = memory usage
//    @GetMapping(value = "/api/single/{logTime}/{types}", produces = "application/json")
//    public ArrayList<Object> singleDataAll(@PathVariable long logTime, @PathVariable int[] types) throws IOException {
//        log.info("singleData logTime :[{}]", logTime);
//        log.info("singleData types :[{}]", types);
//
//        ArrayList<Object> result = new ArrayList<>();
//
//        for (int type : types) {
//            switch (type){
//                case 1:
//                    CPUUsage cpuUsage = new CPUUsage();
//                    cpuUsage.setCPUUSAGE(BigDecimal.valueOf((int)(Math.random() * 100)));
//                    cpuUsage.setLogTime(logTime + 1L);
//                    result.add(cpuUsage);
//                    break;
//                case 2:
//                    MemoryUsage memoryUsage = new MemoryUsage();
//                    memoryUsage.setMemoryUsage(BigDecimal.valueOf((int)(Math.random() * 100)));
//                    memoryUsage.setLogTime(logTime + 1L);
//                    result.add(memoryUsage);
//                    break;
//                default:
//            }
//
//        }
//
//        return result;
//    }
//
//
//}
