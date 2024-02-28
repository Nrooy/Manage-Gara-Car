package com.example.demo.controller;

import com.example.demo.service.tblnguoidungService;
import com.example.demo.entities.tblnguoidung;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class loginController {
    @Autowired
    private tblnguoidungService nguoidungService;

    @RequestMapping("/login")
    public String getLogin(){return "login";}

    @PostMapping("/login")
    public String login(ModelMap modelMap , @RequestParam("taikhoan") String taikhoan , @RequestParam("matkhau") String matkhau , HttpSession session){
        tblnguoidung nguoiDungExist = nguoidungService.findByTaikhoan(taikhoan);
        if(nguoiDungExist == null){
            modelMap.addAttribute("ERROR","Không tồn tại người dùng");
            return "login";
        }else{
            if(nguoiDungExist.getMatkhau().equals(matkhau)){
                session.setAttribute("tblnguoidung",nguoiDungExist);
                if(nguoiDungExist.getIsadmin()==1){
                    return "admin_home";
                }else return "client_home";
            }else{
                modelMap.addAttribute("ERROR","Sai mật khẩu");
                return "login";
            }
        }
    }
    @RequestMapping("/register")
    public String getRegister(){return "register";}

    @PostMapping("/register")
    public String register(ModelMap modelMap ,@ModelAttribute("tblnguoidung") tblnguoidung nguoidung){
        tblnguoidung ExitsNguoiDung = nguoidungService.findByTaikhoan(nguoidung.getTaikhoan());
        if(ExitsNguoiDung == null){
            tblnguoidung newnguoidung = new tblnguoidung();
            newnguoidung.setTen(nguoidung.getTen());
            newnguoidung.setDiachi(nguoidung.getDiachi());
            newnguoidung.setTaikhoan(nguoidung.getTaikhoan());
            newnguoidung.setMatkhau(nguoidung.getMatkhau());
            newnguoidung.setSdt(nguoidung.getSdt());
            newnguoidung.setIsadmin(0);
            nguoidungService.create(newnguoidung);
            return"login";
        }else{
            modelMap.addAttribute("ERROR","Người dùng đã tồn tại");
            return "register";
        }
    }

}
