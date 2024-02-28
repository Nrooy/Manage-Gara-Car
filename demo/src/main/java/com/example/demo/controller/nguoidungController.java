package com.example.demo.controller;

import com.example.demo.service.*;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.entities.*;
import java.util.List;

@Controller
public class nguoidungController {
    @Autowired
    private tblnguoidungService tblnguoidungService;
    @Autowired
    private tblSlotService tblSlotService;
    @Autowired
    private tblXeService tblXeService;
    @Autowired
    private tbldichvuService tbldichvuService;


    @GetMapping("/dat_lich")
    private String datlich(HttpSession session , Model model){
        tblnguoidung nguoidung = (tblnguoidung) session.getAttribute("tblnguoidung");
        List <tblslot> slots = tblSlotService.getAllEmptySlot();
        if(slots.isEmpty()){
            model.addAttribute("errorMessage", "Xin lỗi cửa hàng của chúng tôi đang bận :))");
            return "client_home";
        }else{
            List <tblxe> listxe = tblXeService.getAllXeCuaNguoiDung(nguoidung.getId());
            List <tbldichvu> listDichVu = tbldichvuService.getAll();
            model.addAttribute("tblnguoidung",nguoidung);
            model.addAttribute("tblslot",slots);
            model.addAttribute("tblXe",listxe);
            model.addAttribute("tbldichvu",listDichVu);
            return ("/Client/dat-lich");
        }

    }
}
