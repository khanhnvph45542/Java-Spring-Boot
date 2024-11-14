package com.example.assignment_gd1.controller;

import com.example.assignment_gd1.repository.NhanVienRepo;
import com.example.assignment_gd1.service.NhanVienService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assignment")
public class NhanVienCotroller {
    @Autowired
    NhanVienService nhanVienService;
    @GetMapping("/nhanvien")
    public String nhanVien(Model model, HttpServletRequest req, HttpSession session) {
        String vaiTro = (String) req.getSession().getAttribute("vaitro");
        if (vaiTro == null) {
            return "redirect:dangnhap";
        }
        model.addAttribute("listNV", nhanVienService.getListNV());
        return "nhanvien";
    }
}
