package com.example.demo.responsitory;
import com.example.demo.entities.tbldichvu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface tbldichvuResponsitory extends JpaRepository<tbldichvu,Integer> {

    @Query(value = "Select dichvu from tbldichvu dichvu where dichvu.ten =:ten")
    List <tbldichvu> finByName(String ten);
}
