package com.spring.jasper_report.controller;

import com.spring.jasper_report.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/export-pdf")
    public ResponseEntity<String> exportPdf() {
        try {
            this.reportService.exportReportPDF();
            return ResponseEntity.status(HttpStatus.OK).body("export PDF success");
        }catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("export pdf failed");
        }
    }
}
