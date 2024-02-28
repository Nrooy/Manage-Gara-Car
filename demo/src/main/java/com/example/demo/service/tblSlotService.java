package com.example.demo.service;

import com.example.demo.entities.tblslot;

import java.util.List;

public interface tblSlotService {
    List <tblslot> getAllEmptySlot();

    tblslot findById(Integer Id);
}
