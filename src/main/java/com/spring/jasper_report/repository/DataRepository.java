package com.spring.jasper_report.repository;

import com.spring.jasper_report.entity.Datas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Datas,Integer> {
}
