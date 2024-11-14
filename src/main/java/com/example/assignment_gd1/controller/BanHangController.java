package com.example.assignment_gd1.controller;

import com.example.assignment_gd1.model.HoaDon;
import com.example.assignment_gd1.model.HoaDonChiTiet;
import com.example.assignment_gd1.model.SanPhamChiTiet;
import com.example.assignment_gd1.repository.HoaDonChiTietRepo;
import com.example.assignment_gd1.repository.HoaDonRepo;
import com.example.assignment_gd1.repository.KhachHangRepo;
import com.example.assignment_gd1.repository.SanPhamChiTietRepo;
import com.example.assignment_gd1.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/assignment")
public class BanHangController {
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    HoaDonChiTietService hoaDonChiTietService;
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    SanPhamChiTietService sanPhamChiTietService;


    @GetMapping("/banhang")
    public String nhanVien(Model model, HttpServletRequest req){
        String vaiTro = (String) req.getSession().getAttribute("vaitro");
        if (vaiTro == null) {
            return "redirect:dangnhap";
        }
        model.addAttribute("listHD", hoaDonService.getListHDChuaTT());
        model.addAttribute("listSPCT", sanPhamChiTietService.getBySPCTTrue());
        model.addAttribute("listKH", khachHangService.getByIDKHTrue());
            return "banhang";
    }
    @RequestMapping("/getByIDHD")
    public String getString(Model model,
                            HttpServletRequest req,
                            HttpSession session) {
        Integer idHD = Integer.parseInt(req.getParameter("idHoaDon"));
        session.setAttribute("listHDCT", hoaDonChiTietService.getByIDHD(idHD));
        session.setAttribute("q", hoaDonService.getByIDHD(idHD));
        session.setAttribute("tongtien", hoaDonChiTietService.tongTien(idHD));
        return "redirect:banhang";
    }

    @RequestMapping("/addGioHang")
    public String add(Model model,
                      HttpServletRequest req,
                      HttpSession session,
                      HoaDonChiTiet hoaDonChiTiet){
        Boolean check = true;
        String idhd = req.getParameter("hoaDon");
        if (idhd.trim().isEmpty()){
            check= false;
            session.setAttribute("error","Moi ban chon hoa don");
        }
        if (check == false){
            return "redirect:banhang";
        }
        Integer idHoaDon = Integer.parseInt(idhd);
        Integer idSPCT = Integer.parseInt(req.getParameter("sanPhamChiTiet"));
        Integer sl = Integer.parseInt(req.getParameter("soLuong"));
        SanPhamChiTiet spct = sanPhamChiTietService.getByIdSPCT(idSPCT);
        Double donGia =spct.getDonGia();
        Boolean trangThai = false;
        hoaDonChiTiet.setDonGia(donGia);
        hoaDonChiTiet.setTrangThai(trangThai);
//        for (HoaDonChiTiet hdct:hoaDonChiTietService.getListHDCT()) {
//            if (hdct.getHoaDon().getIdHoaDon() == hoaDonChiTiet.getHoaDon().getIdHoaDon()
//                    && hdct.getSanPhamChiTiet().getIdSPCT() == hoaDonChiTiet.getSanPhamChiTiet().getIdSPCT()){
//                hoaDonChiTietService.capNhatsoluongHDCT(idHoaDon,idSPCT, sl);
//            }
//        }
//        for (HoaDonChiTiet hdct:hoaDonChiTietService.getListHDCT()) {
//            if (hdct.getHoaDon().getIdHoaDon() != hoaDonChiTiet.getHoaDon().getIdHoaDon()
//                    && hdct.getSanPhamChiTiet().getIdSPCT() != hoaDonChiTiet.getSanPhamChiTiet().getIdSPCT()){
//                    hoaDonChiTietService.addHDCT(hoaDonChiTiet, sl);
//
//            }
//        }
        boolean found = false;
        for (HoaDonChiTiet hdct : hoaDonChiTietService.getListHDCT()) {
            if (hdct.getHoaDon().getIdHoaDon() == hoaDonChiTiet.getHoaDon().getIdHoaDon()
                    && hdct.getSanPhamChiTiet().getIdSPCT() == hoaDonChiTiet.getSanPhamChiTiet().getIdSPCT()) {
                hoaDonChiTietService.capNhatsoluongHDCT(hdct.getHoaDon().getIdHoaDon(), hdct.getSanPhamChiTiet().getIdSPCT(), sl);
                found = true;
                break;
            }
        }

        if (!found) {
            hoaDonChiTietService.addHDCT(hoaDonChiTiet, sl);
        }

        session.setAttribute("listHDCT", hoaDonChiTietService.getByIDHD(idHoaDon));
        session.setAttribute("tongtien",hoaDonChiTietService.tongTien(idHoaDon));
        Integer spdamua = hoaDonChiTietService.soluongspdamua(idHoaDon,idSPCT);
        Integer soluongtong = spct.getSoLuong();
        Integer sospConLai = soluongtong-spdamua;
        sanPhamChiTietService.updatesoLuong(idSPCT,sospConLai);
        sanPhamChiTietService.updateTrangThai(idSPCT);

        session.setAttribute("error","");
        return "redirect:banhang";
    }
    @PostMapping("/addHD")
    public String addHD(Model model,HttpServletRequest req,
                        HttpSession session,
                        HoaDon hoaDon){
        LocalDate date = LocalDate.now();
        String trangthai = "Chưa Thanh Toán";
        hoaDon.setTrangThai(trangthai);
        hoaDon.setNgayMuaHang(date);
        hoaDonService.addHD(hoaDon);
        session.setAttribute("error","Them hoa don thanh cong");
        return "redirect:banhang";
    }
    @RequestMapping("/huyHoaDon")
    public String huyHoaDon(HttpServletRequest req,HttpSession session) {
        Integer idHD =Integer.parseInt(req.getParameter("idHoaDon"));
        hoaDonService.HuyHoaDon(idHD);
        session.setAttribute("error","Huy hoa don thanh cong");
        session.setAttribute("q",new HoaDon());
        return "redirect:banhang";
    }

    @PostMapping("/tienthua")
    public String tienthua(Model model,HttpServletRequest req,
                           HttpSession session) {
        boolean check = true;
        boolean check1 = true;
        String tt = req.getParameter("tongTienKhachTra");
        String tk = req.getParameter("tienKhach");
        if (tt.trim().isEmpty()){
            check = false;
            session.setAttribute("error","Vui long them san pham");
        }
        if (tk.trim().isEmpty()){
            check = false;
            session.setAttribute("error","Khach hang chua thanh toan");
        }
        if (check==false){
            return "redirect:banhang";
        }
        Double tongTienKhachTra = Double.parseDouble(tt);
        Double tienKhach = Double.parseDouble(tk);
        if (tongTienKhachTra > tienKhach){
            check1 = false;
            session.setAttribute("error","Tien khach tra chua du");
        }
        if (check1==false){
            return "redirect:banhang";
        }
        session.setAttribute("tienKhach",tienKhach);
        session.setAttribute("tienthuatrakhach",tienKhach-tongTienKhachTra);
        return "redirect:banhang";
    }

    @PostMapping("/thanhToanHD")
    public String thanhToanHD(Model model,HttpServletRequest req,
                        HttpSession session,
                              HoaDon hoaDon){
        boolean check = true;
        String idHDon = req.getParameter("idHoaDon");
        String idNVien = req.getParameter("nhanVien");
        String idKHang = req.getParameter("khachHang");
        String tt = req.getParameter("tongTienKhachTra");
        String tk = req.getParameter("tienKhach");

        if (tt.trim().isEmpty()){
            check = false;
            session.setAttribute("error","Vui long them san pham");
        }
        if (tk.trim().isEmpty()){
            check = false;
            session.setAttribute("error","Khach hang chua thanh toan");
        }
        if (idHDon.trim().isEmpty()){
            check = false;
            session.setAttribute("error","Vui long chon hoa don");
        }
        if (idNVien.trim().isEmpty()){
            check = false;
            session.setAttribute("error","Xin moi ban dang nhap");
        }
        if (idKHang.trim().isEmpty()){
            check = false;
            session.setAttribute("error","Vui long chon khach hang");
        }
        if (check == false){
            return "redirect:banhang";
        }
        Integer idHD =Integer.parseInt(idHDon);
        Integer idNV =Integer.parseInt(idNVien);
        Integer idKH =Integer.parseInt(idKHang);
//        HoaDon hoaDon = hoaDonService.getByIDHD(idHD);
//        System.out.println(hoaDon.getIdHoaDon());
        boolean check1  = true;
        Double tongTienKhachTra = Double.parseDouble(tt);
        Double tienKhach = Double.parseDouble(tk);
        if (tongTienKhachTra > tienKhach){
            check1 = false;
            session.setAttribute("error","Tien khach tra chua du");
        }
        if (check1==false){
            return "redirect:banhang";
        }
        LocalDate date = LocalDate.now();
        String trangthai = "Đã Thanh Toán";
        hoaDon.setTrangThai(trangthai);
        hoaDon.setNgayMuaHang(date);
        hoaDonService.thanhToanHD(hoaDon);
        session.setAttribute("listHDCT", hoaDonChiTietService.getByIDHD(0));
        session.setAttribute("tongtien", "");
        session.setAttribute("tienKhach", "");
        session.setAttribute("tienthuatrakhach", "");
        session.setAttribute("error","Thanh toan thanh cong");
        session.setAttribute("q",new HoaDon());
        return "redirect:banhang";
    }
    @RequestMapping("/updateslspgh")
    public String updateslspgh(HttpServletRequest req,
                               HttpSession session) {
        Boolean check = true;
        String sl = req.getParameter("soluongsanphamthaydoi");
        if (sl.trim().isEmpty()){
            check = false;
            session.setAttribute("error","Vui long nhap so luong thay doi");
        }
        if (check == false){
            return "redirect:banhang";
        }
        Integer idHDCT = Integer.parseInt(req.getParameter("idHDCT"));
        Integer idSPCTGH = Integer.parseInt(req.getParameter("idSPCTGH"));
        Integer idHoaDon = Integer.parseInt(req.getParameter("idHoaD"));
        Integer soLuong = Integer.parseInt(req.getParameter("soLuong"));
        Integer soLuongThayDoi = Integer.parseInt(sl);
        SanPhamChiTiet spct = sanPhamChiTietService.getByIdSPCT(idSPCTGH);
//        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietService.hoaDonChiTiet(idHDCT);
        Integer soluongtong = spct.getSoLuong();
        Integer sospConLai = soluongtong-soLuongThayDoi + soLuong;
        sanPhamChiTietService.updatesoLuong(idSPCTGH,sospConLai);
        hoaDonChiTietService.updatesoluongHDCT(idHDCT,soLuongThayDoi);
        session.setAttribute("tongtien",hoaDonChiTietService.tongTien(idHoaDon));
        return "redirect:banhang";
    }
    @GetMapping("/deleteHDCT")
    public String deleteHDCT(HttpServletRequest req,
                               HttpSession session) {
        Integer idHDCT = Integer.parseInt(req.getParameter("idHDCT"));
        hoaDonChiTietService.deleteHDCT(idHDCT);
        Integer idHD = Integer.parseInt(req.getParameter("idHoaDon"));
        session.setAttribute("listHDCT", hoaDonChiTietService.getByIDHD(idHD));
        session.setAttribute("tongtien", hoaDonChiTietService.tongTien(idHD));
        return "redirect:banhang";
    }

}
