package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.tblXeService;
import com.example.demo.entities.tblxe;
import com.example.demo.entities.tblnguoidung;
import com.example.demo.service.tblnguoidungService;
import com.example.demo.entities.tblxedasua;

import java.util.List;


@Controller
@RequestMapping("tblxe")
public class xeController {
    @Autowired
    private tblXeService tblXeService;

    @GetMapping("/get-all")
    public String getAllXe(ModelMap modelMap, @RequestParam(name = "pageNo",defaultValue = "1") Integer pageNo){
        Pageable pageable =  PageRequest.of(pageNo -1 ,5);
        Page <tblxe> list =tblXeService.getAll1(pageable);
        modelMap.addAttribute("totalPage", list.getTotalPages());
        modelMap.addAttribute("currentPage",pageNo);
        modelMap.addAttribute("listX",list.getContent());
        return ("list-xe");
    }
    @GetMapping("/search")
    public String dosearch(Model modelMap ,
                           @RequestParam(name = "keyword",defaultValue ="" ) String keyword,
                           @RequestParam(name ="pageNo" , defaultValue = "1") Integer pageNo
                           )
    {
        Pageable pageable = PageRequest.of(pageNo -1,5);
        Page <tblxe> list = tblXeService.dosearch(keyword,pageable);
        modelMap.addAttribute("totalPage",list.getTotalPages());
        modelMap.addAttribute("currentPage",pageNo);
        modelMap.addAttribute("listX",list.getContent());
        return "list-xe";
    }
    @GetMapping("/{id}")
    public String  doretrieve(ModelMap modelMap , @PathVariable Integer id){
        tblxe xe = tblXeService.retrieve(id);
        modelMap.addAttribute("tblxe",xe);
        return "detail-xe";
    }
    @GetMapping("/delete/{id}")
    public String dodelete(@PathVariable Integer id){
        tblXeService.delete(id);
        return"redirect:/tblxe/get-all";
    }
    @PostMapping("/savetblxe")
    public String savetblxe(@ModelAttribute("xe") tblxe xe){
        tblXeService.saveTblXe(xe);
        return "redirect:/tblxe/get-all";
    }
    @GetMapping("editXe/{id}")
    public String getFormEdit(@PathVariable (value = "id") Integer id , ModelMap modelMap){
        tblxe xe = tblXeService.findById(id);
        modelMap.addAttribute("tblxe",xe);
        return "edit-xe";
    }
//    @PostMapping("/createtblxe")
//    public String createtblxe(@ModelAttribute("xe") tblxe xe,ModelMap modelMap){
//        tblXeService.saveTblXe(xe);
//        return "redirect:/tblxe/get-all";
//    }
    @Autowired
    private tblnguoidungService userService;
    @GetMapping("/add")
    public String showAddCarForm(Model model) {
        List <tblnguoidung> userList = userService.getAll();
        model.addAttribute("users", userList);
//        model.addAttribute("car", new tblxe());
        return "add-xe";
    }
    @GetMapping("add/search")
    public String searchSdt(Model model, @RequestParam(name = "keywords")String keywords){
        List <tblnguoidung> list = userService.findBySdt(keywords);
        model.addAttribute("users",list);
        return "add-xe";
    }
    @GetMapping("add/{id}")
    public String addCar(Model model , @PathVariable(value = "id") Integer id){
        tblnguoidung nguoidung = userService.finById(id);
        tblxe xe = new tblxe();
        xe.setTblnguoidung(nguoidung);
        model.addAttribute("tblxe", xe);
        model.addAttribute("nguoidung",nguoidung);
        return "add-xe2";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("xe") tblxe xe,ModelMap modelMap){
        if (tblXeService.findByBienSo(xe.getBienso() )==null){
            tblXeService.creat(xe);
            return "redirect:/tblxe/get-all";
        }else{
            modelMap.addAttribute("errorMessage", "Xe đã dùng đã tồn tại");
            return "redirect:/tblxe/add";
        }
    }
}
