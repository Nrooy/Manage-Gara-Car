package com.example.demo.service.iplm;

import com.example.demo.entities.tblslot;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.tblSlotService;
import com.example.demo.responsitory.tblSlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tblSlotServiceImpl implements tblSlotService{
    @Autowired
    tblSlotRepository tblSlotRespository;

    @Override
    public List<tblslot> getAllEmptySlot() {
        return tblSlotRespository.getAllEmptyXe();
    }

    @Override
    public tblslot findById(Integer Id) {
        return tblSlotRespository.findById(Id).orElse(null);
    }
}
