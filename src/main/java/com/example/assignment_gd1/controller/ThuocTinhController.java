package com.example.assignment_gd1.controller;

import com.example.assignment_gd1.model.KichThuoc;
import com.example.assignment_gd1.model.MauSac;
import com.example.assignment_gd1.service.KichThuocService;
import com.example.assignment_gd1.service.MauSacService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assignment")
public class ThuocTinhController {
        @Autowired
        MauSacService mauSacService;

        @Autowired
        KichThuocService kichThuocService;





    @RequestMapping("/thuoctinh")
    public String thuoctinh(Model model) {
        model.addAttribute("listMS", mauSacService.getListMS());
        model.addAttribute("listKT", kichThuocService.getListKichThuoc());
        return "thuoctinh";
    }

    @RequestMapping("/listIDMS")
    public String ListIDMS(Model model, HttpServletRequest req, HttpSession session) {
        String idMS = req.getParameter("idMS");
        boolean check = true;
        if (idMS.trim().isEmpty()){
            check=false;
            session.setAttribute("errorr","Vui long nhap id hoa don chi tiet");
        }
        if (check == false){
            return "redirect:thuoctinh";
        }
        Integer idMauSac = Integer.parseInt(idMS);
        model.addAttribute("listMS", mauSacService.ListIDMS(idMauSac));
        return "thuoctinh";
    }
    @PostMapping("/themMS")
    public String addMS(Model model, HttpServletRequest req,HttpSession session) {
        boolean check = true;
        Integer idMS = mauSacService.getListMS().size() + 1;
        String maMS = req.getParameter("maMS");
        String tenMS = req.getParameter("tenMS");

        Boolean trangThai = Boolean.parseBoolean(req.getParameter("trangThai"));
        if (maMS.trim().isEmpty()){
            check = false;
            session.setAttribute("checkMS","Vui long nhap ma mau sac");
        }
        if (tenMS.trim().isEmpty()){
            check = false;
            session.setAttribute("checkMS","Vui long nhap ten mau sac");
        }

        if (check == false){
            session.setAttribute("ms",new MauSac(idMS,maMS,tenMS,trangThai));
            return "redirect:thuoctinh";
        }
        MauSac mauSac = new MauSac(idMS,maMS,tenMS,trangThai);
        mauSacService.addMS(mauSac);
        return "redirect:thuoctinh";
    }
    @GetMapping("/xoaMSac")
    public String xoaMSac(Model model,HttpServletRequest req,HttpSession session) {
        Integer idMauSac = Integer.parseInt(req.getParameter("idMauSac"));
        mauSacService.deleteMS(idMauSac);
        return "redirect:thuoctinh";
    }
    @PostMapping("/updateMS")
    public String updateMS(@RequestBody MauSac mauSac) {
        mauSacService.updateMS(mauSac);
        return "update/updateMS";
    }


    @RequestMapping("/listIDKT")
    public String ListIDKT(Model model,HttpServletRequest req,HttpSession session) {
        String idKT = req.getParameter("idKT");
        boolean check = true;
        if (idKT.trim().isEmpty()){
            check=false;
//            session.setAttribute("errorr","Vui long nhap id hoa don chi tiet");
        }
        if (check == false){
            return "redirect:thuoctinh";
        }
        Integer idKichThuoc = Integer.parseInt(idKT);
        model.addAttribute("listKT", kichThuocService.ListIDKT(idKichThuoc));
        return "thuoctinh";
    }
    @PostMapping("/addKT")
    public String addKT(Model model, HttpServletRequest req,HttpSession session) {
        boolean check = true;
        Integer idKT = kichThuocService.getListKichThuoc().size() + 1;
        String maKT = req.getParameter("maKT");
        String tenKT = req.getParameter("tenKT");

        Boolean trangThai = Boolean.parseBoolean(req.getParameter("trangThai"));
        if (maKT.trim().isEmpty()){
            check = false;
            session.setAttribute("checkMS","Vui long nhap ma kich thuoc");
        }
        if (tenKT.trim().isEmpty()){
            check = false;
            session.setAttribute("checkMS","Vui long nhap ten kich thuoc");
        }

        if (check == false){
            session.setAttribute("ms",new KichThuoc(idKT,maKT,tenKT,trangThai));
            return "redirect:thuoctinh";
        }
        KichThuoc kichThuoc = new KichThuoc(idKT,maKT,tenKT,trangThai);
        kichThuocService.addKT(kichThuoc);
        return "redirect:thuoctinh";
    }


    @GetMapping("/xoaKT")
    public String xoaKT(Model model,HttpServletRequest req,HttpSession session) {
        Integer idKichThuoc = Integer.parseInt(req.getParameter("idKichThuoc"));
        kichThuocService.deleteKT(idKichThuoc);
        return "redirect:thuoctinh";
    }

}
