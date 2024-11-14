package com.example.assignment_gd1.controller;

import com.example.assignment_gd1.model.NhanVien;
import com.example.assignment_gd1.service.NhanVienService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/assignment")
public class DangNhapController {

    @Autowired
    NhanVienService nhanVienService;
    @RequestMapping("/dangnhap")
    public String formdangnhap() {
        return "dangnhap";
    }
    @PostMapping("/dangnhap")
    public String dangnhap(Model model,
                           HttpServletRequest req,
                           RedirectAttributes redirectAttributes,
                           HttpSession session){
        String tendn = req.getParameter("tenDangNhap");
        String matKhau = req.getParameter("matKhau");

        for (int i = 0; i < nhanVienService.getListNV().size(); i++) {
            if (nhanVienService.getListNV().get(i).getTenDangNhap().equals(tendn) &&
                    nhanVienService.getListNV().get(i).getMatKhau().equals(matKhau)
            && nhanVienService.getListNV().get(i).isTrangThai() == true) {
                NhanVien nhanVien = nhanVienService.getListNV().get(i);

                session.setAttribute("vaitro", nhanVienService.getListNV().get(i).getVaiTro());
                session.setAttribute("tennv", nhanVienService.getListNV().get(i).getTen());
                session.setAttribute("idNhanVien", nhanVienService.getListNV().get(i).getIdNV());
                return "redirect:banhang";
            }
        }
                model.addAttribute("errorDN","Vui long ban nhap lai ten dang nhap hoac mat khau");
                return "dangnhap";
    }
}
