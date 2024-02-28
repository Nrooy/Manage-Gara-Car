package com.example.demo.service.iplm;

import com.example.demo.entities.tbldichvu;
import com.example.demo.service.tbldichvuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.responsitory.*;

import java.util.List;

@Service
public class tbldichvuServiceImpl implements tbldichvuService {
    @Autowired
    tbldichvuResponsitory tbldichvuResponsitory;


    @Override
    public List<tbldichvu> getAll() {
        return tbldichvuResponsitory.findAll();
    }

    @Override
    public List<tbldichvu> finByName(String ten) {
        return tbldichvuResponsitory.finByName(ten);
    }

    @Override
    public tbldichvu finById(Integer Id) {
        return tbldichvuResponsitory.findById(Id).orElse(null);
    }
}
