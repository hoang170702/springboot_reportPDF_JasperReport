package com.spring.jasper_report.controller;

import com.spring.jasper_report.entity.Datas;
import com.spring.jasper_report.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Datas>> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.reportService.getAllReport());
        }catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
