package com.example.assignment_gd1.service;

import com.example.assignment_gd1.model.NhanVien;
import com.example.assignment_gd1.model.SanPhamChiTiet;
import com.example.assignment_gd1.repository.NhanVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NhanVienService {
//    ArrayList<NhanVien> listNV = new ArrayList<>();

    @Autowired
    NhanVienRepo nhanVienRepo;


    public List<NhanVien> getListNV() {
        return nhanVienRepo.findAll();
    }

    public List<NhanVien> ListIDNV(int idNV) {
//        ArrayList<NhanVien> list = new ArrayList<>();
//        for (NhanVien nhanVien:getListNV() ) {
//            if (nhanVien.getIdNV() == idNV){
//                list.add(nhanVien);
//            }
//        }
        return (List<NhanVien>) nhanVienRepo.findById(idNV).get();
    }

    public NhanVien getByIDNV(int idNV) {
        return nhanVienRepo.findById(idNV).get();
    }

    public void deleteNV(int idNV){
        nhanVienRepo.deleteById(idNV);
    }

    public void updateNV(NhanVien nhanVien){
        try {
            nhanVienRepo.save(nhanVien);
        }catch (Exception e){
            e.printStackTrace();
        }    }

    public void addNV(NhanVien nhanVien){
        try {
            nhanVienRepo.save(nhanVien);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
