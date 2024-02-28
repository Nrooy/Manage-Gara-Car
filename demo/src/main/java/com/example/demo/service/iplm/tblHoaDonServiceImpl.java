package com.example.demo.service.iplm;
import com.example.demo.entities.*;
import com.example.demo.responsitory.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class tblHoaDonServiceImpl implements tblHoaDonService{
    @Autowired
    tblHoaDonRepository hoaDonRepository;

    @Override
    public void create(tblhoadon hoadon) {
        hoadon.setTblnguoidung(hoadon.getTblnguoidung());
        hoadon.setDathanhtoan(false);
        hoadon.setNgayDatDon(new Date());
        hoaDonRepository.save(hoadon);
    }
}
