package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.*;
import com.example.demo.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class dichVuController {

    @Autowired
    tbldichvuService tbldichvuService;

    @GetMapping("/searchDichVu")
    @ResponseBody
    public List<tbldichvu> getDichVu(@RequestParam("q") String query){
        return tbldichvuService.finByName(query);
    }
}
