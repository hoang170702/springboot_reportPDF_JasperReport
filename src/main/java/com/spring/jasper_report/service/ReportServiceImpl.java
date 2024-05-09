package com.spring.jasper_report.service;

import com.spring.jasper_report.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ReportServiceImpl implements ReportService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void exportReportPDF() {
        try {
            String filePath = "C:\\Users\\admin\\Desktop\\Code\\JavaCode\\ExportPDF\\src\\main\\resources\\Simple_Blue.jrxml";

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("studentName", "Hoang");

            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(this.studentRepository.findAll());
            JasperReport report = JasperCompileManager.compileReport(filePath);
            JasperPrint print =  JasperFillManager.fillReport(report, params, jrBeanCollectionDataSource);

            JasperExportManager.exportReportToPdfFile(print,"D:\\test.pdf");
            System.out.println("report create ...");

        }catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
