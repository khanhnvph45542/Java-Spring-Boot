package com.example.assignment_gd1.service;

import com.example.assignment_gd1.model.KhachHang;
import com.example.assignment_gd1.model.NhanVien;
import com.example.assignment_gd1.model.SanPham;
import com.example.assignment_gd1.model.SanPhamChiTiet;
import com.example.assignment_gd1.repository.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KhachHangService {
//    ArrayList<KhachHang> listKH = new ArrayList<>();
    @Autowired
    KhachHangRepo khachHangRepo;

    public List<KhachHang> getListKH() {
        return khachHangRepo.findAll();
    }

    public List<KhachHang> ListIDKH(int idKH) {
        return (List<KhachHang>) khachHangRepo.findById(idKH).get();
    }

//    public KhachHang getByIDKH(int idKH) {
//        for (KhachHang khachHang:listKH ) {
//            if (khachHang.getIdKH() == idKH){
//                return khachHang;
//            }
//        }
//        return null;
//    }
    public ArrayList<KhachHang> getByIDKHTrue() {
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        for (KhachHang khachHang:getListKH() ) {
            if (khachHang.isTrangThai()== true){
                listKhachHang.add(khachHang);
            }
        }
        return listKhachHang;
    }
//    public void deleteKH(int idKH){
//        KhachHang khachHang = getByIDKH(idKH);
//        if (khachHang!=null){
//            listKH.remove(khachHang);
//        }
//    }
//    public void updateKH(KhachHang khachHang){
//        for (int i = 0; i < listKH.size(); i++) {
//            if (listKH.get(i).getIdKH() == khachHang.getIdKH()){
//                listKH.set(i,khachHang);
//            }
//        }
//    }
//
//    public void addKH(KhachHang khachHang){
//        try {
//            listKH.add(khachHang);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
