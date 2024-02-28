package com.example.demo.service.iplm;
import com.example.demo.entities.*;
import com.example.demo.responsitory.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class tbldichvudasudungServiceImpl implements tblDichVuDaSuDungService{
    @Autowired
    tblDichVuDaSuDungRepository dichVuDaSuDungRepository;

    @Override
    public void create(tbldichvudasudung dichvudasudung) {
        dichvudasudung.setTbldichvu(dichvudasudung.getTbldichvu());
        dichvudasudung.setTblxedasua(dichvudasudung.getTblxedasua());
        dichVuDaSuDungRepository.save(dichvudasudung);
    }
}
