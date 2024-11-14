package com.example.assignment_gd1.service;

import com.example.assignment_gd1.model.KichThuoc;
import com.example.assignment_gd1.model.SanPhamChiTiet;
import com.example.assignment_gd1.repository.SanPhamChiTietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamChiTietService {
//    ArrayList<SanPhamChiTiet> listSPCT = new ArrayList<>();
    @Autowired
    SanPhamChiTietRepo sanPhamChiTietRepo;

    public List<SanPhamChiTiet> getListSPCT() {
        return sanPhamChiTietRepo.findAll();
    }

    public SanPhamChiTiet getByIdSPCT(int idSPCT){
        return sanPhamChiTietRepo.findById(idSPCT).get();
    }

    public List<SanPhamChiTiet> getBySPCTTrue(){
        List<SanPhamChiTiet> listspNew = new ArrayList<>();
        for (SanPhamChiTiet sanPhamChiTiet:getListSPCT()) {
            if (sanPhamChiTiet.isTrangThai() == true){
                listspNew.add(sanPhamChiTiet);
            }
        }
        return listspNew;
    }
    public void updatesoLuong(int idspct,int soluong){
        for (int i = 0; i < getListSPCT().size(); i++) {
            if (getListSPCT().get(i).getIdSPCT() == idspct){
                SanPhamChiTiet sanPhamChiTiet = getListSPCT().get(i);
                sanPhamChiTiet.setSoLuong(soluong);
                sanPhamChiTietRepo.save(sanPhamChiTiet);
            }
        }
    }
    public void updateSPCT(SanPhamChiTiet sanPhamChiTiet){
        sanPhamChiTietRepo.save(sanPhamChiTiet);
    }

    public void updateTrangThai(int idspct){
        for (int i = 0; i < getListSPCT().size(); i++) {
            if (getListSPCT().get(i).getIdSPCT() == idspct && getListSPCT().get(i).getSoLuong() ==0){
                SanPhamChiTiet sanPhamChiTiet = getListSPCT().get(i);
                sanPhamChiTiet.setTrangThai(false);
                sanPhamChiTietRepo.save(sanPhamChiTiet);
            }
        }
    }
    public void updateTrangThaiTrue(int idspct){
        for (int i = 0; i < getListSPCT().size(); i++) {
            if (getListSPCT().get(i).getIdSPCT() == idspct && getListSPCT().get(i).getSoLuong() !=0){
                SanPhamChiTiet sanPhamChiTiet = getListSPCT().get(i);
                sanPhamChiTiet.setTrangThai(true);
                sanPhamChiTietRepo.save(sanPhamChiTiet);
            }
        }
    }


    public void addSPCT(SanPhamChiTiet sanPhamChiTiet){
        try {
           sanPhamChiTietRepo.save(sanPhamChiTiet);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteSPCT(int idSPCT) {
        sanPhamChiTietRepo.deleteById(idSPCT);
    }
}
