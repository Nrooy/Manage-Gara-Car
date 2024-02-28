package com.example.demo.service;

import com.example.demo.entities.tblnguoidung;

import java.util.List;

public interface tblnguoidungService {
    tblnguoidung findByTaikhoan(String taikhoan);

    tblnguoidung create(tblnguoidung nguoidung);

    List <tblnguoidung> getAll();

    tblnguoidung finById(Integer Id);

    List<tblnguoidung> findBySdt(String sdt);
}
