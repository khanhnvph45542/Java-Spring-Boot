package com.example.assignment_gd1.controller;

import com.example.assignment_gd1.model.HoaDon;
import com.example.assignment_gd1.service.HoaDonChiTietService;
import com.example.assignment_gd1.service.HoaDonService;
import com.example.assignment_gd1.service.NhanVienService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/assignment")
public class HoaDonController {
    @Autowired
    HoaDonService hoaDonService;
     @Autowired
     HoaDonChiTietService hoaDonChiTietService;
    @GetMapping("/hoadon")
    public String hoadon(Model model, HttpServletRequest req, HttpSession session) {
        String vaiTro = (String) req.getSession().getAttribute("vaitro");
        if (vaiTro == null) {
            return "redirect:dangnhap";
        }else if (vaiTro.equals("Admin")){
            model.addAttribute("listHDCT",hoaDonChiTietService.getListHDCT());
            model.addAttribute("listHDon",hoaDonService.getListHD());
            return "hoadon";
        }else {
            session.setAttribute("error", "Chi admin moi vao duoc hoa don");
            return "redirect:banhang";
        }
    }
    @GetMapping("/ByHDCT/{idHoaDon}")
    public String ByHDCT(@PathVariable("idHoaDon") Integer idHoaDon, Model model){
        model.addAttribute("listHDCT", hoaDonChiTietService.getByIDHD(idHoaDon));
        model.addAttribute("listHDon", hoaDonService.getListHD());
        return "hoadon";
    }

    @PostMapping("/timKiemHD")
    public String timkiemhd(HttpServletRequest req, HttpSession session, Model model) {
       String idhd = req.getParameter("idHoaDonTK");
       boolean check = true;
       if (idhd.trim().isEmpty()){
           check=false;
//           session.setAttribute("errorr","Vui long nhap id hoa don");
       }
       if (check == false){
           return "redirect:hoadon";
       }
       Integer idHoaDon = Integer.parseInt(idhd);
        System.out.println(idHoaDon);
        ArrayList<HoaDon> lisHD = hoaDonService.timkiemHDByID(idHoaDon);
        model.addAttribute("listHDon",lisHD);
        session.setAttribute("errorr","");
        return "hoadon";
    }


    @RequestMapping("/timkiemTrangThaiHD")
    public String timkiemTrangThaiHD(HttpSession session, HttpServletRequest req,Model model){
        String trangThai = req.getParameter("trangTha");
        if (trangThai.equals("dathanhtoan")){
            model.addAttribute("listHDon", hoaDonService.getListHDDaTT());
        }else if (trangThai.equals("chothanhtoan")){
            model.addAttribute("listHDon", hoaDonService.getListHDChuaTT());
        }else if (trangThai.equals("huythanhtoan")){
            model.addAttribute("listHDon", hoaDonService.getListHDHuyTT());
        }
        session.setAttribute("errorr","");
        return "hoadon";
    }
}
