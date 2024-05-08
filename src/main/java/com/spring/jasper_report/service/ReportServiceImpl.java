package com.spring.jasper_report.service;

import com.spring.jasper_report.entity.Datas;
import com.spring.jasper_report.repository.DataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ReportServiceImpl implements ReportService{

    @Autowired
    private DataRepository dataRepository;

    @Override
    public List<Datas> getAllReport() {
        try {
           return this.dataRepository.findAll();
        }catch (Exception e) {
            log.error(e.getMessage());
            return Collections.emptyList();
        }
    }
}
