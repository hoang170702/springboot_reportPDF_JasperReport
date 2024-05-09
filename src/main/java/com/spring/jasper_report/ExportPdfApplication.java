package com.spring.jasper_report;

import com.spring.jasper_report.entity.Student;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ExportPdfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExportPdfApplication.class, args);
    }

}
