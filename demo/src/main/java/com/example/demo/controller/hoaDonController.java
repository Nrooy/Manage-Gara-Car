package com.example.demo.controller;
import com.example.demo.service.*;
import com.example.demo.entities.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class hoaDonController {
    @Autowired
    tblHoaDonService hoaDonService;
    @Autowired
    tblXeService tblXeService;
    @Autowired
    tbldichvuService tbldichvuService;
    @Autowired
    tblSlotService tblSlotService;
    @Autowired
    tblXeDaSuaService XeDaSuaService;
    @Autowired
    tblDichVuDaSuDungService tblDichVuDaSuDungService;
    @PostMapping("/saveHoaDon")
    public String saveHoaDon (@RequestParam("selectSlot") Integer slotId,
                              @RequestParam("selectCar") Integer carId,
                              @RequestParam(name="selectDichVus",required = false) List<Integer> dichVuIds,
                              HttpSession session, ModelMap modelMap){

            if(dichVuIds == null){
                modelMap.addAttribute("ERROR", "Chưa nhập dịnh vụ");
//                return "client_home";
                return "redirect:/dat_lich";
            }
            else{
                tblhoadon hoadon =new tblhoadon();
                hoadon.setTblnguoidung((tblnguoidung) session.getAttribute("tblnguoidung"));
                hoaDonService.create(hoadon);

                tblxedasua xedasua =new tblxedasua();
                xedasua.setTblhoadon(hoadon);
                xedasua.setTblxe(tblXeService.findById(carId));
                xedasua.setTblslot(tblSlotService.findById(slotId));
                XeDaSuaService.create(xedasua);

                for (Integer id : dichVuIds){
                    tbldichvudasudung dichvudasudung =new tbldichvudasudung();
                    dichvudasudung.setTblxedasua(xedasua);
                    dichvudasudung.setTbldichvu(tbldichvuService.finById(id));
                    tblDichVuDaSuDungService.create(dichvudasudung);
                }
                return "client_home";
            }
    }

}
