package com.example.demo.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.tblnguoidung;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface tblnguoidungResponsitory extends JpaRepository<tblnguoidung,Integer> {
    tblnguoidung findByTaikhoan(String taikhoan);

    @Query(value = "select u from tblnguoidung u where (?1 is null or u.sdt like %?1%)")
    List<tblnguoidung> findBySdt(String sdt);
}
