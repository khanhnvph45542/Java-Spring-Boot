package com.example.assignment_gd1.controller;

import com.example.assignment_gd1.service.KhachHangService;
import com.example.assignment_gd1.service.NhanVienService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assignment")
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;

    @RequestMapping("/khachhang")
    public String khachhang(Model model, HttpServletRequest req) {
        String vaiTro = (String) req.getSession().getAttribute("vaitro");
        if (vaiTro == null) {
            return "redirect:dangnhap";
        }
        model.addAttribute("listKH", khachHangService.getListKH());
        return "khachhang";
    }
}
