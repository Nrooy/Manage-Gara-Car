package com.example.demo.service.iplm;
import com.example.demo.entities.*;
import com.example.demo.service.*;
import com.example.demo.responsitory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class tblXeDaSuaServiceImpl implements tblXeDaSuaService{
    @Autowired
    tblXeDaSuaRepository xeDaSuaRepository;
    @Override
    public void create(tblxedasua tblxedasua) {
        tblxedasua.setTblhoadon(tblxedasua.getTblhoadon());
        tblxedasua.setTblslot(tblxedasua.getTblslot());
        tblxedasua.setTblhoadon(tblxedasua.getTblhoadon());
        xeDaSuaRepository.save(tblxedasua);
    }
}
