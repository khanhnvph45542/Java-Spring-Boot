package com.example.assignment_gd1.service;

import com.example.assignment_gd1.model.SanPham;
import com.example.assignment_gd1.model.SanPhamChiTiet;
import com.example.assignment_gd1.repository.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamService {
//    ArrayList<SanPham> listSP = new ArrayList<>();
    @Autowired
    SanPhamRepo sanPhamRepo;

    public List<SanPham> getListSP() {
        return sanPhamRepo.findAll();
    }
    public ArrayList<SanPham> getListSPTrue() {
        ArrayList<SanPham> listsp = new ArrayList<>();
        for (SanPham sanPham:getListSP()) {
            if (sanPham.isTrangThai() == true){
                listsp.add(sanPham);
            }
        }
        return listsp;
    }
//
    public void addSP(SanPham sanPham){
        try {
            sanPhamRepo.save(sanPham);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public SanPham getByIDSP(int idSP){
        return sanPhamRepo.findById(idSP).get();
    }
//    public void deleteSP(int idSP){
//        SanPham sanPham = getByIDSP(idSP);
//        if (sanPham!=null){
//            listSP.remove(sanPham);
//        }
//    }
    public void updateSP(SanPham sanPham){
        try {
            sanPhamRepo.save(sanPham);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
