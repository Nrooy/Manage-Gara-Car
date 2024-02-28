package com.example.demo.service;


import com.example.demo.entities.tbldichvu;

import java.util.List;

public interface tbldichvuService {

    List<tbldichvu> getAll();

    List <tbldichvu> finByName(String ten);

    tbldichvu finById(Integer Id);
}
