package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import com.example.demo.entities.tblxe;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface tblXeService {
    List <tblxe> getAll();

    void creat(tblxe xe);

    tblxe retrieve(Integer Id);

    tblxe findById(Integer Id);

    tblxe findByBienSo(String bienso);

    Page<tblxe> getAll1(Pageable pageable);

    Page <tblxe> dosearch(String keyword , Pageable pageable);

    void delete(Integer id );

//    public tblxe update(tblxe xe);

    void saveTblXe(tblxe xe);

    List <tblxe> getAllXeCuaNguoiDung(Integer Id);
}
