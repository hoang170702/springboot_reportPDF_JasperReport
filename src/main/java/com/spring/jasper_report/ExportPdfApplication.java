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
        try {
            String filePath = "C:\\Users\\admin\\Desktop\\Code\\JavaCode\\ExportPDF\\src\\main\\resources\\Simple_Blue.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("studentName", "Hoang");
            Student student = new Student(1L, "abc","dssd","ssss","ssss");
            Student student1 = new Student(2L, "abc1","dssd","ssss","ssss");


            List<Student> students = new ArrayList<Student>();
            students.add(student);
            students.add(student1);

            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(students);
            JasperReport report = JasperCompileManager.compileReport(filePath);
            JasperPrint print =  JasperFillManager.fillReport(report, params, jrBeanCollectionDataSource);

            JasperExportManager.exportReportToPdfFile(print,"D:\\test.pdf");
            System.out.println("report create ...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
