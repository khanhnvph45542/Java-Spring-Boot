package com.example.assignment_gd1.controller;

import com.example.assignment_gd1.model.KichThuoc;
import com.example.assignment_gd1.model.MauSac;
import com.example.assignment_gd1.model.SanPham;
import com.example.assignment_gd1.model.SanPhamChiTiet;
import com.example.assignment_gd1.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/assignment")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    SanPhamChiTietService sanPhamChiTietService;
    @Autowired
    KichThuocService kichThuocService;
    @Autowired
    MauSacService mauSacService;
    @GetMapping("/sanpham")
    public String nhanVien(Model model, HttpServletRequest req,
                           HttpSession session){
        String vaiTro = (String) req.getSession().getAttribute("vaitro");
        if (vaiTro == null) {
            return "redirect:dangnhap";
        }else if (vaiTro.equals("Admin")){
            model.addAttribute("listSPham", sanPhamService.getListSP());
            model.addAttribute("listSPCT", sanPhamChiTietService.getListSPCT());
            return "sanpham";
        }else {
            session.setAttribute("error", "Chi admin moi vao duoc san pham");
            return "redirect:banhang";

        }

    }
//   san pham -------------------------------
    @PostMapping("/addSP")
    public String addSPCT(HttpServletRequest req,
                          HttpSession session,
                          Model model,
                          SanPham sanPham){
        Boolean check = true;

//            Integer idSP = sanPhamService.getListSP().size() + 1;

            String maSP = req.getParameter("maSP");
            String ten = req.getParameter("ten");
            boolean trangThai = true;

            if (maSP.trim().isEmpty()){
                check = false;
                session.setAttribute("checkMaSP", "Vui long nhap ma");
            }
            for (SanPham sanPham1 :sanPhamService.getListSP()) {
                if (sanPham1.getMaSP().equals(maSP)){
                    check = false;
                    session.setAttribute("checkMaSP", "Khong duoc trung ma Sp");
                }
            }
            if (ten.trim().isEmpty()){
                check = false;
                session.setAttribute("checkTen", "Vui long nhap Ten Sp");
            }
            if (check ==false){
                session.setAttribute("n", new SanPham(0,maSP,ten,trangThai));
                return "redirect:sanpham";
            }
            sanPham.setTrangThai(true);
            sanPhamService.addSP(sanPham);
            session.setAttribute("checkTen", "");
            session.setAttribute("checkMaSP", "");
        return "redirect:sanpham";
    }
    @GetMapping("/updateSP/{idSP}")
    public String updateSP(@PathVariable("idSP") Integer idSP,Model model){
        model.addAttribute("n",sanPhamService.getByIDSP(idSP));
        return "update/updateSP";
    }
    @PostMapping("/updateSP")
    public String update(SanPham sanPham,Model model){
        sanPhamService.updateSP(sanPham);
        return "redirect:sanpham";    }













//   san pham  chi tiet-------------------------------
    @PostMapping("/addSPCT")
    public String addSPCT(SanPhamChiTiet sanPhamChiTiet){
        sanPhamChiTietService.addSPCT(sanPhamChiTiet);
        return "redirect:/assignment/sanpham";
    }
       @RequestMapping("/deleteSPCT")
    public String deleteSPCT(@RequestParam("idSPCT") Integer id){
        sanPhamChiTietService.deleteSPCT(id);
        return "redirect:/assignment/sanpham";
    }
    @RequestMapping("/updateSPCT/{idSPCT}")
    public String UpdatSPCT(@PathVariable("idSPCT") Integer idSPCT, Model model){
        model.addAttribute("m",sanPhamChiTietService.getByIdSPCT(idSPCT));
        model.addAttribute("listSP" ,sanPhamService.getListSPTrue());
        model.addAttribute("listKT", kichThuocService.TrueListIDKT());
        model.addAttribute("listMS", mauSacService.TrueListIDMS());
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietService.getByIdSPCT(idSPCT);
        return "update/updateSPCT";
    }
    @PostMapping("/updateSPCT")
    public String updatteSPCT(@RequestParam("idSPCT") Integer idSPCT, SanPhamChiTiet sanPhamChiTiet){

        sanPhamChiTietService.updateSPCT(sanPhamChiTiet);
        sanPhamChiTietService.updateTrangThai(idSPCT);
        sanPhamChiTietService.updateTrangThaiTrue(idSPCT);
        return "redirect:sanpham";
    }












//    --------------------------------------------------
    @ModelAttribute("listSP")
    public List<SanPham> listSPTrue(){
        return sanPhamService.getListSPTrue();
    }
    @ModelAttribute("listKT")
    public List<KichThuoc> listKTTrue(){
        return kichThuocService.TrueListIDKT();
    }
    @ModelAttribute("listMS")
    public List<MauSac> listMSTrue(){
        return mauSacService.TrueListIDMS();
    }

}
