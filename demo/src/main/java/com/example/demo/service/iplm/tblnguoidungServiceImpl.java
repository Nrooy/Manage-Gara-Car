package com.example.demo.service.iplm;

import com.example.demo.entities.tblnguoidung;
import com.example.demo.service.tblnguoidungService;
import com.example.demo.responsitory.tblnguoidungResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tblnguoidungServiceImpl implements tblnguoidungService {

    @Autowired
    private tblnguoidungResponsitory tblnguoidungResponsitory;
    @Override
    public tblnguoidung findByTaikhoan(String taikhoan){return tblnguoidungResponsitory.findByTaikhoan(taikhoan);}

    @Override
    public tblnguoidung create(tblnguoidung nguoidung) {
        return tblnguoidungResponsitory.save(nguoidung);
    }

    @Override
    public List<tblnguoidung> getAll() {
        return tblnguoidungResponsitory.findAll();
    }

    @Override
    public tblnguoidung finById(Integer Id) {
        return  tblnguoidungResponsitory.findById(Id).orElse(null);
    }

    @Override
    public List<tblnguoidung> findBySdt(String sdt) {
        return this.tblnguoidungResponsitory.findBySdt(sdt);
    }
}
